package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SettingDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SettingService;
import com.walab.hgu.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@Autowired
	SettingService settingService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/adminReservation", method = RequestMethod.GET)
	public ModelAndView readReservationInfo(ModelAndView mv) {
		
		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfo();
		
		mv.addObject("reservationInfoList", reservationInfoList); 
		
		System.out.println(mv);

		
		mv.setViewName("adminReservation");
			
		return mv;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView readSetting(ModelAndView mv) {
		
		List<SettingDTO> settingList = settingService.readSetting();
		
		mv.addObject("settingList", settingList); 
		
		System.out.println(mv);

		
		mv.setViewName("admin");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminUser", method = RequestMethod.GET)
	public ModelAndView readUser(ModelAndView mv) {
		
		List<UserDTO> userList = userService.readUser();
		
		mv.addObject("userList", userList); 
		
		System.out.println(mv);

		
		mv.setViewName("adminUser");
			
		return mv;
	}
}
