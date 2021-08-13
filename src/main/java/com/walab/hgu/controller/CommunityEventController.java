package com.walab.hgu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.EventDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;
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
	public ModelAndView communityEvent(ModelAndView mv) {

		List<EventDTO> eventList = eventService.readEvent();
		
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

}
