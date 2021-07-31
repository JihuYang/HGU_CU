package com.walab.hgu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SettingDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SettingService;
import com.walab.hgu.service.UserService;
import com.walab.hgu.service.ClubService;

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
	
	@Autowired
	ClubService clubService;

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
		List<ClubDTO> clubList = clubService.readClubList();
		
		mv.addObject("userList", userList); 
		mv.addObject("clubList", clubList); 
		
		System.out.println(mv);

		
		mv.setViewName("adminUser");
			
		return mv;
	}
	
	@RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
	public void favicon( HttpServletRequest request, HttpServletResponse reponse ) {

		try {

			reponse.sendRedirect("/resources/favicon.ico");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
