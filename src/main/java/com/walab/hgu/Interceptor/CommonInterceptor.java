package com.walab.hgu.Interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.ClubService;
import com.walab.hgu.service.SettingService;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {
	

	@Autowired
	ClubService clubService;
	@Autowired
	SettingService settingService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인하지 않을 경우 시설 예약 불가
		if(request.getSession().getAttribute("user") == null) {
			if(request.getRequestURI().contains("reserve")) {
				response.sendRedirect(request.getContextPath() + "/");
		        return false;
			}
		}else {
			// 일반 회원인 경우 관리자 페이지, CUD 페이지 접근 불가
			if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() == 2) {
				if(request.getRequestURI().contains("admin") || request.getRequestURI().contains("update") || request.getRequestURI().contains("delete") || request.getRequestURI().contains("create") || request.getRequestURI().contains("write")) {
					response.sendRedirect(request.getContextPath() + "/");
			        return false;
				}
			}
			// 동아리 대표 계정인 경우 관리자 페이지 접근 불가
			else if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() == 1) {
				if(request.getRequestURI().contains("admin")) {
					response.sendRedirect(request.getContextPath() + "/");
			        return false;
				}
			}
			// 차단 계정인 경우 관리자 페이지, CUD 페이지 접근 불가
			else if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() == 3) {
				if(request.getRequestURI().contains("reserve") || request.getRequestURI().contains("admin") || request.getRequestURI().contains("update") || request.getRequestURI().contains("delete") || request.getRequestURI().contains("create") || request.getRequestURI().contains("write")) {
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
			request.setAttribute("header", "headerLogout.jsp");
		}else if(((UserDTO)request.getSession().getAttribute("user")).getAdmin() == 0) {
			request.setAttribute("header", "headerAdmin.jsp");
		}else {
			request.setAttribute("header", "headerLogin.jsp");
		}
		
		
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		
		List<ReservationInfoDTO> officeHour = settingService.getOfficeHour();
	
		
		
		request.setAttribute("categoryNameList", categoryNameList);
		request.setAttribute("officeHour", officeHour);


		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
