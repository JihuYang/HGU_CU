package com.walab.hgu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SpaceDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.SpaceService;
import com.walab.hgu.service.ReservationInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MyReservationController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@Autowired
	SpaceService spaceService;

	@RequestMapping(value = "/myReservation", method = RequestMethod.GET)
	public ModelAndView readReservationInfo(ModelAndView mv, HttpServletRequest request,
			@RequestParam(value = "spaceName",required = false, defaultValue = "") String spaceName) {

		List<SpaceDTO> spaceList = spaceService.readSpace();
		List<ReservationInfoDTO> reservationInfoList = new ArrayList<ReservationInfoDTO>();
		int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
		int userId = ((UserDTO)request.getSession().getAttribute("user")).getId();

		if(admin == 0) {
			if(spaceName.equals("전체")) {
				reservationInfoList = reservationInfoService.readReservationInfo();
			}else {
				reservationInfoList = reservationInfoService.readReservationBySpaceName(spaceName);
			}
		} else {
			if(spaceName.equals("전체")) {
				reservationInfoList = reservationInfoService.readReservationInfoById(userId);
			}else {
				reservationInfoList = reservationInfoService.readReservationBySpaceName(spaceName);
			}
			
			
		}

		
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		mv.addObject("spaceName",spaceName);
		
		mv.setViewName("myReservation");
		
		System.out.println(mv);
	
		return mv;
	}
}
