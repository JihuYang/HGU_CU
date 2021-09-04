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
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SpaceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReservationController {
	
	@Autowired
	SpaceService spaceService;
	
	@Autowired
	ReservationInfoService reservationInfoService;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public ModelAndView readSpace(ModelAndView mv,
			@RequestParam(value = "spaceName",required = false, defaultValue = "") String spaceName,
			HttpServletRequest request) {
		if(request.getSession().getAttribute("user") != null) {
			int userId = ((UserDTO)request.getSession().getAttribute("user")).getId();
			mv.addObject("userId", userId);		
		}
		System.out.println(spaceName);
		List<SpaceDTO> spaceList = spaceService.readSpace();
		List<SpaceDTO> spaceList2 = spaceService.readSpaceByName(spaceName);
		List<ReservationInfoDTO> reservationInfoList = new ArrayList<ReservationInfoDTO>();
		if(spaceName.equals("전체")) {
			reservationInfoList = reservationInfoService.readReservationInfo();
		}else {
			reservationInfoList = reservationInfoService.readReservationBySpaceName(spaceName);
		}
		System.out.println(reservationInfoList);
//		System.out.println(spaceList2);
//		System.out.println(spaceList);

		mv.addObject("spaceList", spaceList);
		mv.addObject("spaceList2", spaceList2);
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceName",spaceName);
		
		mv.setViewName("reservation");
		
		//System.out.println(mv);
	
		return mv;
	}
	
}

