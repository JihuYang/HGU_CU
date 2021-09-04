package com.walab.hgu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.UserService;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	UserService userService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("tempUser");
		int id = 0;
		id = userService.readUserIDByEmail(userDTO.getEmail());
		if(id > 0) {
			userDTO.setId(id);
			//userDTO.setAdmin(userService.readAdminByUserID(id));
			session.setAttribute("user", userDTO);
			modelAndView.setView(new RedirectView("/",true));
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
