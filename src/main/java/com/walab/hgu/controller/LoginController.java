package com.walab.hgu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@Controller
@RequestMapping("/loginGoogle")
public class LoginController {
	
	final static String GOOGLE_AUTH_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
	final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
	final static String GOOGLE_REVOKE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/revoke";
	final static String REDIRECTION_URL = "http://localhost:8080/google/auth";

//	@Value("${api.client_id}")
	String clientId = "client_id=330229354393-gevcnmd1sbv0fvmjovljh695o8pjq8q6.apps.googleusercontent.com";
//	@Value("${api.client_secret}")
	String clientSecret="fqzMiDz-Cru2IU2kCh6T0Uf2";
	
	@GetMapping(value = "")
	public ModelAndView login() {
		String redirectUrl = "redirect:https://accounts.google.com/o/oauth2/v2/auth?"
				+ "client_id=330229354393-gevcnmd1sbv0fvmjovljh695o8pjq8q6.apps.googleusercontent.com"
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
		session.setAttribute("tempUser", ud);
		session.setAttribute("token", result.getAccessToken());
		
		model.setView(new RedirectView("home",true));
		
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

//@RequestMapping(value = "/google/auth", method = RequestMethod.GET)
//	public String googleAuth(Model model, @RequestParam(value = "code") String authCode,HttpServletRequest request)
//			throws Exception {
//		
//		//HTTP Request를 위한 RestTemplate
//		RestTemplate restTemplate = new RestTemplate();
// 
//		//Google OAuth Access Token 요청을 위한 파라미터 세팅
//		GoogleOAuthRequestDTO googleOAuthRequestParam =  new GoogleOAuthRequestDTO();
//		googleOAuthRequestParam.setClientId("330229354393-gevcnmd1sbv0fvmjovljh695o8pjq8q6.apps.googleusercontent.com");
//		googleOAuthRequestParam.setClientSecret("fqzMiDz-Cru2IU2kCh6T0Uf2");
//		googleOAuthRequestParam.setCode(authCode);
//		googleOAuthRequestParam.setRedirectUri("http://localhost:8080//hgu/google/auth");
//		googleOAuthRequestParam.setGrantType("authorization_code");
//		
//		//JSON 파싱을 위한 기본값 세팅
//		//요청시 파라미터는 스네이크 케이스로 세팅되므로 Object mapper에 미리 설정해준다.
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//		mapper.setSerializationInclusion(Include.NON_NULL);
// 
//		//AccessToken 발급 요청
//		ResponseEntity<String> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token", googleOAuthRequestParam, String.class);
// 
//		//Token Request
//		GoogleOAuthResponseDTO result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponseDTO>() {
//		});
// 
//		//ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
//		String jwtToken = result.getIdToken();
//		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo").queryParam("id_token", jwtToken).toUriString();
//		
//		String resultJson = restTemplate.getForObject(requestUrl, String.class);
//		
//		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
//		model.addAllAttributes(userInfo);
//		model.addAttribute("token", result.getAccessToken());
//		
//		return "home";
//	}
//}
//	import javax.inject.Inject;
//	import javax.servlet.http.HttpSession;
//
//	import org.slf4j.Logger;
//	import org.slf4j.LoggerFactory;
//	import org.springframework.stereotype.Controller;
//	import org.springframework.ui.Model;
//	import org.springframework.web.bind.annotation.RequestMapping;
//	import org.springframework.web.bind.annotation.RequestMethod;
//	import org.springframework.web.bind.annotation.RequestParam;
//	import org.springframework.web.bind.annotation.ResponseBody;
//	import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//
//	@Controller
//	@RequestMapping(value = "/member/*")
//	public class LoginController {
//
//		@Inject
//		//@Autowired
//		private MemberService service;
//		
//		private static final Logger l = LoggerFactory.getLogger(MemberController.class);
//		
//		/* 회원가입 */
//		// http://localhost:8088/member/join
//		
//		@RequestMapping(value = "/join", method = RequestMethod.GET)
//		public String insertGET() throws Exception {
//			return "/member/loginandjoin";
//		}
//		
//		@RequestMapping(value = "/join", method = RequestMethod.POST)
//		public String insertPOST(MemberVO vo) throws Exception{
//			l.info("C: 회원가입포스트메서드"+ vo);
//			service.joinMember(vo);		
//			return "redirect:/member/login";
//		}
//		
//		//회원가입시 아이디중복확인
//		@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
//		public @ResponseBody int idCheck(@RequestParam("id") String id) throws Exception {
//			MemberVO ck = service.idCheck(id);
//			if(ck != null) return 1;
//			else return 0;
//		}
//		
//		/* 로그인 기능 */
//		// http://localhost:8088/member/login
//		
//		@RequestMapping(value = "/login", method = RequestMethod.GET)
//		public String loginGET() throws Exception{
//			return "/member/loginandjoin";
//		}
//		
//		@RequestMapping(value = "/login", method = RequestMethod.POST)
//		public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
//			MemberVO returnVO = service.loginMember(vo);
//			System.out.println("C: 리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) "+returnVO);
//			
//			if(returnVO != null) {
//				session.setAttribute("id", returnVO.getId());			
//				rttr.addFlashAttribute("mvo", returnVO);
//				return "redirect:/member/main"; 
//			} else {
//				return "redirect:/member/login";
//			}
//		}
//		
//		/* 로그아웃 */
//		@RequestMapping(value = "/logout", method = RequestMethod.GET)
//		public void logoutGET(HttpSession session) throws Exception{
//			l.info("C: 로그아웃 GET");
//			session.invalidate();
//			// return "redirect:/member/main"; 얼럿창출력안하고싶을때 사용
//		}
//		
//		/* 구글아이디로 로그인 */	
//	    @ResponseBody
//		@RequestMapping(value = "/loginGoogle", method = RequestMethod.POST)
//		public String loginGooglePOST(MemberVO vo, HttpSession session, RedirectAttributes rttr, MemberVO mvo) throws Exception{
//			MemberVO returnVO = service.loginMemberByGoogle(vo);
//			String mvo_ajaxid = mvo.getId(); 
//			System.out.println("C: 구글아이디 포스트 db에서 가져온 vo "+ vo);
//			System.out.println("C: 구글아이디 포스트 ajax에서 가져온 id "+ mvo_ajaxid);
//			
//			if(returnVO == null) { //아이디가 DB에 존재하지 않는 경우
//				//구글 회원가입
//				service.joinMemberByGoogle(vo);	
//				
//				//구글 로그인
//				returnVO = service.loginMemberByGoogle(vo);
//				session.setAttribute("id", returnVO.getId());			
//				rttr.addFlashAttribute("mvo", returnVO);
//			}
//			
//			if(mvo_ajaxid.equals(returnVO.getId())){ //아이디가 DB에 존재하는 경우
//				//구글 로그인
//				service.loginMemberByGoogle(vo);
//				session.setAttribute("id", returnVO.getId());			
//				rttr.addFlashAttribute("mvo", returnVO);
//			}else {//아이디가 DB에 존재하지 않는 경우
//				//구글 회원가입
//				service.joinMemberByGoogle(vo);	
//				
//				//구글 로그인
//				returnVO = service.loginMemberByGoogle(vo);
//				session.setAttribute("id", returnVO.getId());			
//				rttr.addFlashAttribute("mvo", returnVO);
//			}
//			
//			return "redirect:/member/main";
//		}