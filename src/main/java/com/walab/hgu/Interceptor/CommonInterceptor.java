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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("user") == null) {
			if(request.getRequestURI().contains("mypage") || request.getRequestURI().contains("manageCodingsite") || request.getRequestURI().contains("usermanage")) {
				response.sendRedirect(request.getContextPath() + "/");
		        return false;
			}

		}else {
			if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() <= 0) {
				if(request.getRequestURI().contains("manageCodingsite") || request.getRequestURI().contains("usermanage")) {
					response.sendRedirect(request.getContextPath() + "/");
			        return false;
				}
			}
			request.setAttribute("userID", ((UserDTO)request.getSession().getAttribute("user")).getId());
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(request.getSession().getAttribute("user") == null) {
			request.setAttribute("header", "headerLogut.jsp");
		}else if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() > 0) {
			request.setAttribute("header", "headerAdmin.jsp");
		}else {
			request.setAttribute("header", "headerLogin.jsp");
		}
		
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
