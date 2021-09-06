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
