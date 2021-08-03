package com.walab.hgu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SpaceDTO;
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
	public ModelAndView readReservationInfo(ModelAndView mv) {

		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfo();
		List<SpaceDTO> spaceList = spaceService.readSpace();
		
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		
		mv.setViewName("myReservation");
		
		System.out.println(mv);
	
		return mv;
	}
}
