package com.walab.hgu.controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SettingDTO;
import com.walab.hgu.DTO.SpaceDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.ReservationInfoService;
import com.walab.hgu.service.SettingService;
import com.walab.hgu.service.SpaceService;
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
	
	@Autowired
	SpaceService spaceService;

	@RequestMapping(value = "/adminReservation", method = RequestMethod.GET)
	public ModelAndView readReservationInfo(ModelAndView mv, @RequestParam("num") int num) {
		
		Page page = new Page();
		page.setNum(num); 
		page.setCount(reservationInfoService.countInfo());
		
		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfoPaging(page.getDisplayPost(),page.getPostNum());
		List<SpaceDTO> spaceList = spaceService.readSpace();
		
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		System.out.println(mv);

		
		mv.setViewName("adminReservation");
			
		return mv;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView readSetting(ModelAndView mv, @RequestParam("num") int num) {
		
		Page page = new Page();
		page.setNum(num); 
		page.setCount(settingService.countInfo());
		
		List<SettingDTO> settingList = settingService.readSetting(page.getDisplayPost(),page.getPostNum());
		
		mv.addObject("settingList", settingList); 
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		System.out.println(mv);

		
		mv.setViewName("admin");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminUser", method = RequestMethod.GET)
	public ModelAndView readUser(ModelAndView mv, @RequestParam("num") int num) {
		
		Page page = new Page();
		page.setNum(num); 
		page.setCount(userService.countInfo());
		
		List<UserDTO> userList = userService.readUser(page.getDisplayPost(),page.getPostNum());
		List<ClubDTO> clubList = clubService.readClubList(page.getDisplayPost(),page.getPostNum());
		
		mv.addObject("userList", userList); 
		mv.addObject("clubList", clubList); 
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		System.out.println(mv);
		
		mv.setViewName("adminUser");
			
		return mv;
	}

	
	
	@RequestMapping(value = "/adminReservation", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createAdminReservationInfo(ModelAndView mv,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="spaceId") int spaceId,
			@RequestParam(value="startTime") Time startTime,
			@RequestParam(value="endTime") Time endTime,
			@RequestParam(value="purpose") String purpose,
			@RequestParam(value="reservationDate") Date reservationDate) {
		
		ReservationInfoDTO info = new ReservationInfoDTO();
		
		info.setUserId(userId);
		info.setSpaceId(spaceId);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setPurpose(purpose);
		info.setReservationDate(reservationDate);
		
		System.out.println(info.toString());

		reservationInfoService.createAdminReservationInfo(info);
	
		mv.setViewName("adminReservation");
			
		return mv;
	}
}
