package com.walab.hgu.controller;

import java.text.DateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.walab.hgu.DTO.SettingDTO;
import com.walab.hgu.DTO.SpaceDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SettingService;
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
	
	@Autowired
	SettingService settingService;

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView readReservationInfo(ModelAndView mv, HttpServletRequest httpServletRequest) {

		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfo();
		List<SpaceDTO> spaceList = spaceService.readSpace();
		String userName = "admin";
		String email = "email";
		if (httpServletRequest.getSession().getAttribute("user") != null) {
			userName = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getName();
			email = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getEmail();
			int admin = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);

		}
		mv.addObject("email", email);
		mv.addObject("userName", userName);
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);

		mv.setViewName("reserve");

		System.out.println(mv);

		return mv;
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public @ResponseBody Object createReservation(ModelAndView mv, HttpServletRequest httpServletRequest,
			@RequestParam(value = "spaceId") int spaceId, @RequestParam(value = "reservationDate") Date reservationDate,
			@RequestParam(value = "startTime") Time startTime, @RequestParam(value = "endTime") Time endTime,
			@RequestParam(value = "purpose") String purpose, @RequestParam(value = "memo") String memo)
			throws IOException {

		int userId = 0;
		if (httpServletRequest.getSession().getAttribute("user") != null) {
			userId = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getId();
			System.out.println("userId" + userId);
			String userName = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getName();
			int admin = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);
			System.out.println("userName" + userName);
			mv.addObject("userID", userId);
		}

		ReservationInfoDTO info = new ReservationInfoDTO();

		info.setSpaceId(spaceId);
		info.setUserId(userId);
		info.setReservationDate(reservationDate);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setPurpose(purpose);
		info.setMemo(memo);

		System.out.println("?????? ??????:" + info.toString());

		int result = reservationInfoService.createReservation(info);

		System.out.println("DB ?????? ??????:" + result);

		String errorMsg = "reservationAgain";
		String successMsg = "reservationSuccess";

		if (result == 0) {
			return 0;
		}

		else {
			return 1;
		}
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ResponseBody
	public int validate(ModelAndView mv, HttpServletRequest httpServletRequest,
			@RequestParam(value = "spaceId") int spaceId, @RequestParam(value = "startTime") Time startTime,
			@RequestParam(value = "endTime") Time endTime, @RequestParam(value = "reservationDate") Date reservationDate) {

		ReservationInfoDTO info = new ReservationInfoDTO();
		System.out.println("reservationDate: " + reservationDate);
		int userID = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getId();
		int admin = ((UserDTO) httpServletRequest.getSession().getAttribute("user")).getAdmin();


		info.setUserId(userID);
		info.setSpaceId(spaceId);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setReservationDate(reservationDate);
		
//		List<ReservationInfoDTO> weekInfoList = reservationInfoService.readWeekSumReservation(userID);
//		System.out.println("weekInfoList: " + weekInfoList);
		
		if(admin != 0) {
			int intervalTime = reservationInfoService.readTimeDifference(startTime, endTime);
	
			List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readSumReservation(userID, reservationDate);
			List<SettingDTO> settingList = settingService.readSetting();
			
			int dayLimit = settingList.get(1).getValue();
			dayLimit *= 10000;
			
			int weekLimit = settingList.get(0).getValue();
			weekLimit *= 10000;
			
			if(!reservationInfoList.isEmpty()) {
				int sumReserve = reservationInfoList.get(0).getSumReservation();
				System.out.println("sumReserve: " + sumReserve);
				System.out.println("dayLimit: " + dayLimit);

				if (intervalTime + sumReserve > dayLimit) {
					return 0;
				} else return 1;
			}
			List<ReservationInfoDTO> weekInfoList = reservationInfoService.readWeekSumReservation(userID);
			System.out.println("weekInfoList: " + weekInfoList);

			if(!weekInfoList.isEmpty()) {
				int sumWeekReserve = 0;
				for (ReservationInfoDTO temp: weekInfoList) {
					sumWeekReserve += temp.getSumReservation();
				}
				System.out.println("weekInfoList: " + weekInfoList);
				System.out.println("sumWeekReserve: " + sumWeekReserve);
				System.out.println("weekLimit: " + weekLimit);
				if (intervalTime + sumWeekReserve > weekLimit) {
					return -1;
				} else return 1;
			}

			else return 1;
		} else return 1;
	}

}
