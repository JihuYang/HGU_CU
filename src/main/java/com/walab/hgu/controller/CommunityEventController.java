package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.EventDTO;
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

}
