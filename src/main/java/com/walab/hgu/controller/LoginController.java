package com.walab.hgu.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.walab.hgu.DTO.GoogleOAuthRequestDTO;
import com.walab.hgu.DTO.GoogleOAuthResponseDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.UserService;

@Controller
@RequestMapping("/loginGoogle")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	final static String GOOGLE_AUTH_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
	final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
	final static String GOOGLE_REVOKE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/revoke";
	final static String REDIRECTION_URL = "http://hsca219.cafe24.com/loginGoogle/google/auth";
	//final static String REDIRECTION_URL = "http://localhost:8080/loginGoogle/google/auth";


	@Value("${api.client_id}")
	String clientId;
	@Value("${api.client_secret}")
	String clientSecret;
	
	@GetMapping(value = "")
	public ModelAndView login() {
		String redirectUrl = "redirect:https://accounts.google.com/o/oauth2/v2/auth?"
				+ "client_id="+ clientId
				+ "&redirect_uri="+REDIRECTION_URL
				+ "&response_type=code"
				+ "&scope=email%20profile%20openid"
				+ "&access_type=offline";
		return new ModelAndView(redirectUrl);
	}
	
	@GetMapping(value = "cancel")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("token");
		
		ModelAndView mv = new ModelAndView();
		mv.setView(new RedirectView("/",true));
		return mv;
	}
	
	/**
	 * Authentication Code를 전달 받는 엔드포인트
	 * @throws IOException 
	 **/
	@GetMapping("google/auth")
	public ModelAndView googleAuth(HttpServletRequest request, ModelAndView model, @RequestParam(value = "code") String authCode) throws IOException {
		
		//HTTP Request를 위한 RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		//Google OAuth Access Token 요청을 위한 파라미터 세팅
		GoogleOAuthRequestDTO googleOAuthRequestParam = new GoogleOAuthRequestDTO(clientId, clientSecret, authCode, REDIRECTION_URL, "authorization_code");

		
		//JSON 파싱을 위한 기본값 세팅
		//요청시 파라미터는 스네이크 케이스로 세팅되므로 Object mapper에 미리 설정해준다.
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);

		//AccessToken 발급 요청
		ResponseEntity<String> resultEntity = restTemplate.postForEntity(GOOGLE_TOKEN_BASE_URL, googleOAuthRequestParam, String.class);

		//Token Request
		GoogleOAuthResponseDTO result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponseDTO>() {
		});
		
		//ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
		String jwtToken = result.getIdToken();
		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
		.queryParam("id_token", jwtToken).toUriString();
		
		String resultJson = restTemplate.getForObject(requestUrl, String.class);
		
		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
		
		HttpSession session = request.getSession();
		UserDTO ud = new UserDTO();
		ud.setEmail(userInfo.get("email"));
		ud.setName(userInfo.get("name"));

		// 회원 정보가 없는 경우 회원 가입 페이지로 연결
		if(userService.readUserIDByEmail(ud.getEmail())==0) {
			session.setAttribute("tempUser", ud);
			session.setAttribute("token", result.getAccessToken());
			
			model.addObject("tempUser", ud);
			model.setViewName("register");

		} 
		// 회원 정보가 있는 경우  기존의 아이디를 불러옴
		else {
			request.getSession().setAttribute("user", ud);
			int id = userService.readUserIDByEmail(userInfo.get("email"));
			ud.setId(userService.readUserIDByEmail(userInfo.get("email")));
			ud.setAdmin(userService.readAdminByUserID(id));
			session.setAttribute("tempUser", ud);
			session.setAttribute("token", result.getAccessToken());
			
			model.addObject("tempUser", ud);
			model.setViewName("home");
		}
		

		return model;

	}

	/**
	 * 토큰 무효화 
	 **/
	@GetMapping("google/revoke/token")
	@ResponseBody
	public Map<String, String> revokeToken(@RequestParam(value = "token") String token) throws JsonProcessingException {

		Map<String, String> result = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();
		final String requestUrl = UriComponentsBuilder.fromHttpUrl(GOOGLE_REVOKE_TOKEN_BASE_URL).queryParam("token", token).toUriString();
		
		System.out.println("TOKEN ? " + token);
		
		String resultJson = restTemplate.postForObject(requestUrl, null, String.class);
		result.put("result", "success");
		result.put("resultJson", resultJson);

		return result;

	}
	
	
}
