package com.walab.hgu.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView readReservationInfo(ModelAndView mv, @RequestParam("num") int num, 
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) {
		
		Page page = new Page();
		page.setNum(num); 
		page.setCount(reservationInfoService.countInfo(keyword));
		
		page.setKeyword(keyword);
		
		List<ReservationInfoDTO> reservationInfoList = reservationInfoService.readReservationInfoPaging(page.getDisplayPost(),page.getPostNum(),keyword);
		List<SpaceDTO> spaceList = spaceService.readSpace();
		List<UserDTO> userList = userService.readAllUsers();
		mv.addObject("reservationInfoList", reservationInfoList);
		mv.addObject("spaceList", spaceList);
		mv.addObject("userList", userList);
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		System.out.println(mv);

		
		mv.setViewName("adminReservation");
			
		return mv;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView readSetting(ModelAndView mv) {
//		
//		Page page = new Page();
//		page.setNum(num); 
//		page.setCount(settingService.countInfo());
		
		List<SettingDTO> settingList = settingService.readSetting();
		List<ReservationInfoDTO> officeHour = settingService.getOfficeHour();
		
		mv.addObject("settingList", settingList);
		mv.addObject("officeHour", officeHour);
//		mv.addObject("page", page);
//		mv.addObject("selected", num);
		
		System.out.println(mv);

		
		mv.setViewName("admin");
			
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/settingUpdate", method = RequestMethod.POST)
	public ModelAndView updateSetting(ModelAndView mv,HttpServletRequest request, int value,int id) {
		System.out.println(value);
		
		Map<String, Object> settingList = new HashMap<String, Object>();
		settingList.put("value",value);
		settingList.put("id",id);
		
		settingService.updateSetting(settingList);

		
		mv.setViewName("admin");
			
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/startHourUpdate", method = RequestMethod.POST)
	public ModelAndView updateStartHour(ModelAndView mv,HttpServletRequest request, Time value,int id) {
		System.out.println(value);
		
		Map<String, Object> officeHourStart = new HashMap<String, Object>();
		officeHourStart.put("value",value);
		officeHourStart.put("id",id);
		
		reservationInfoService.updateStartHour(officeHourStart);

		
		mv.setViewName("admin");
			
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/endHourUpdate", method = RequestMethod.POST)
	public ModelAndView updateEndHour(ModelAndView mv,HttpServletRequest request, Time value,int id) {
		System.out.println(value);
		
		Map<String, Object> officeHourEnd = new HashMap<String, Object>();
		officeHourEnd.put("value",value);
		officeHourEnd.put("id",id);
		System.out.println(officeHourEnd);
		reservationInfoService.updateEndHour(officeHourEnd);

		
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
	
	@ResponseBody
	@RequestMapping(value = "/adminUser/clubUpdate", method = RequestMethod.POST)
	public ModelAndView updateUserClub(ModelAndView mv,HttpServletRequest request, String clubName,int id) {
		if(clubName.equals("없음")) {
			int clubId = clubService.getClubIdByUserId(id);
			
			Map<String, Object> userClub = new HashMap<String, Object>();
			userClub.put("clubId",clubId);
			userClub.put("userId",id);
			
			clubService.updateUserNull(userClub);
		}else {
			int clubId = clubService.getClubIdByName(clubName);
			
			Map<String, Object> userClub = new HashMap<String, Object>();
			userClub.put("clubId",clubId);
			userClub.put("userId",id);
			
			clubService.updateUserClub(userClub);
		}
		
		System.out.println(mv);
		
		mv.setViewName("adminUser");
			
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/adminUser/authorityUpdate", method = RequestMethod.POST)
	public ModelAndView updateUserAuthority(ModelAndView mv,HttpServletRequest request,int authority, int id) {
		Map<String, Object> authorityParam = new HashMap<String, Object>();
		authorityParam.put("admin",authority);
		authorityParam.put("id",id);
		
		userService.updateAuthority(authorityParam);
		
		System.out.println(mv);
		
		mv.setViewName("adminUser");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminReservation/validate", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView validation(ModelAndView mv,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="spaceId") int spaceId,
			@RequestParam(value="startTime") Time startTime,
			@RequestParam(value="endTime") Time endTime,
			@RequestParam(value="purpose") String purpose,
			@RequestParam(value="date") Date date) {
		
		ReservationInfoDTO info = new ReservationInfoDTO();
		
		info.setUserId(userId);
		info.setSpaceId(spaceId);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setPurpose(purpose);
		info.setReservationDate(date);
		
		System.out.println(info.toString());

		reservationInfoService.createAdminReservationInfo(info);
	
		mv.setViewName("redirect:/adminReservation?num=1");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminReservation/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createAdminReservationInfo(ModelAndView mv,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="spaceId") int spaceId,
			@RequestParam(value="startTime") Time startTime,
			@RequestParam(value="endTime") Time endTime,
			@RequestParam(value="date") Date date) {
		
		ReservationInfoDTO info = new ReservationInfoDTO();
        SimpleDateFormat simpleDateFormat
        = new SimpleDateFormat("HH:mm:ss");

    // Parsing the Time Period
//    Date date1 = simpleDateFormat.parse(startTime);
//    Date date2 = simpleDateFormat.parse(startTime);
//		Math.abs(endTime -  startTime);
//		Duration duration = Duration.between(startTime, endTime);
//
//		Time interval = Period.between(endTime, startTime);
		info.setUserId(userId);
		info.setSpaceId(spaceId);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setReservationDate(date);
		
		System.out.println(info.toString());

		reservationInfoService.createAdminReservationInfo(info);
	
		mv.setViewName("redirect:/adminReservation?num=1");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminReservation/update", method =RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateAdminReservationInfo(ModelAndView mv,
			@RequestParam(value="id") int id,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="spaceId") int spaceId,
			@RequestParam(value="startTime") Time startTime,
			@RequestParam(value="endTime") Time endTime,
			@RequestParam(value="purpose") String purpose,
			@RequestParam(value="date") Date date) {
		
		ReservationInfoDTO info = new ReservationInfoDTO();
		
		info.setId(id);
		info.setUserId(userId);
		info.setSpaceId(spaceId);
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setPurpose(purpose);
		info.setReservationDate(date);
		
		System.out.println(info.toString());

		reservationInfoService.updateAdminReservationInfo(info);
	
		mv.setViewName("redirect:/adminReservation?num=1");
			
		return mv;
	}
	
	@RequestMapping(value = "/adminReservation/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteEvent(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		reservationInfoService.deleteAdminReservation(id);

		System.out.println(mv);

		mv.setViewName("redirect:/adminReservation?num=1");

		return mv;
	}
}
