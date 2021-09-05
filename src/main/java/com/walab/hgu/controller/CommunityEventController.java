package com.walab.hgu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.EventDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.EventService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityEventController {
	
	
	@Autowired
	EventService eventService;

	@RequestMapping(value = "/communityEvent", method = RequestMethod.GET)
	public ModelAndView communityEvent(ModelAndView mv, HttpServletRequest request) {

		List<EventDTO> eventList = eventService.readEvent();
		
		if(request.getSession().getAttribute("user") != null) {
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);		
		}
		mv.addObject("eventList", eventList);
		
		mv.setViewName("communityEvent");
			
		return mv;
	}
	
	@RequestMapping(value = "/communityEvent", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createEvent(ModelAndView mv,
			@RequestParam(value="eventName") String eventName,
			@RequestParam(value="eventSpace") String eventSpace,
			@RequestParam(value="eventContent") String eventContent,
			@RequestParam(value="startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date startDate,
			@RequestParam(value="endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date endDate) {
		
		EventDTO info = new EventDTO();
		
		info.setEventName(eventName);
		info.setEventSpace(eventSpace);
		info.setEventContent(eventContent);
		info.setStartDate(startDate);
		info.setEndDate(endDate);
		
		System.out.println(info.toString());

		eventService.createEvent(info);
	
		mv.setViewName("communityEvent");
			
		return mv;
	}
	
	@RequestMapping(value = "/communityEvent/update/{id}", method =RequestMethod.POST)
	public ModelAndView updateEvent(@PathVariable int id, 
			@RequestParam(value="eventName") String eventName,
			@RequestParam(value="eventSpace") String eventSpace,
			@RequestParam(value="eventContent") String eventContent,
			@RequestParam(value="start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date startDate,
			@RequestParam(value="end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date endDate) {
		ModelAndView mv = new ModelAndView();
		
		EventDTO info = new EventDTO();
		
		info.setId(id);
		info.setEventName(eventName);
		info.setEventSpace(eventSpace);
		info.setEventContent(eventContent);
		info.setStartDate(startDate);
		info.setEndDate(endDate);


		eventService.updateEvent(info);

//		CommunityInfoDTO communityInfoDetail = eventService.readEvent();
//
//		mv.addObject("communityInfoDetail", communityInfoDetail);

//		System.out.println(mv);

		mv.setViewName("redirect:/communityEvent");

		return mv;
	}
	
	@RequestMapping(value = "/communityEvent/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteEvent(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		eventService.deleteEvent(id);
		
		//EventDTO communityEvent = eventService.readEvent(id);
		//String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		//String fileName = communityInfoDetail.getOriginalUrl();

		//System.out.println("filename: " + fileName);
		
		//mv.addObject("communityEvent", communityEvent);

		System.out.println(mv);

		mv.setViewName("redirect:/communityEvent");

		return mv;
	}

}
