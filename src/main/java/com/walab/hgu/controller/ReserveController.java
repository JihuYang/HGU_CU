package com.walab.hgu.controller;

import java.text.DateFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SpaceDTO;
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SpaceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReserveController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@Autowired
	SpaceService spaceService;

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView readReservationInfo(ModelAndView mv) {

		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfo();
		List<SpaceDTO> spaceList = spaceService.readSpace();
		
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		
		mv.setViewName("reserve");
		
		System.out.println(mv);
	
		return mv;
	}
	
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createReservation(ModelAndView mv,
			@RequestParam(value="spaceId") int spaceId,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="reservationDate") Date reservationDate,
			@RequestParam(value="startTime")Time startTime,
			@RequestParam(value="endTime")Time endTime,
			@RequestParam(value="purpose")String purpose,
			@RequestParam(value="memo")String memo){
		
		ReservationInfoDTO info = new ReservationInfoDTO();
		
		info.setSpaceId(spaceId);
		info.setUserId(userId);
		info.setReservationDate(reservationDate);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setPurpose(purpose);
		info.setMemo(memo);
		
		System.out.println(info.toString());

		reservationInfoService.createReservation(info);
	
		mv.setViewName("redirect:/reservation");
			
		return mv;
	}
	
}
