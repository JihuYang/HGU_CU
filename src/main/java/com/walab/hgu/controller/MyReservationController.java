package com.walab.hgu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		// 관리자인 경우 전체 예약 내역 확인 가능
		if(admin == 0) {
			if(spaceName.equals("전체")) {
				reservationInfoList = reservationInfoService.readReservationInfo();
			}else {
				reservationInfoList = reservationInfoService.readReservationBySpaceName(spaceName);
			}
		} 
		// 관리자가 아닌 경우 본인의 예약 내역만 확인 가능
		else {
			if(spaceName.equals("전체")) {
				reservationInfoList = reservationInfoService.readReservationInfoById(userId);
			}else {
				reservationInfoList = reservationInfoService.readReservationBySpaceNameById(spaceName, userId);
			}
			
			
		}

		
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		mv.addObject("spaceName",spaceName);
		
		mv.setViewName("myReservation");
		
		System.out.println(mv);
	
		return mv;
	}
	
	@RequestMapping(value = "/myReservation/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteMyReservation(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		reservationInfoService.deleteMyReservation(id);
		
		System.out.println("아이디 확인!!!!!!!!!"+id);

		mv.addObject("spaceName","전체");
		mv.setViewName("redirect:/myReservation");

		return mv;
	}
}
