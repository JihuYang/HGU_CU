package com.walab.hgu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.walab.hgu.DTO.UserDTO;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {
	


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(request.getSession().getAttribute("user") == null) {
			request.setAttribute("header", "headerLogout.jsp");
		}else if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() == 0) {
			request.setAttribute("header", "headerAdmin.jsp");
		}else {
			request.setAttribute("header", "headerLogin.jsp");
		}
		
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
