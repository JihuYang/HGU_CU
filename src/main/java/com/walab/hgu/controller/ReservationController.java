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

import com.walab.hgu.DTO.SpaceDTO;
import com.walab.hgu.service.SpaceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReservationController {
	
	/*
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "reservation";
	}*/
	
	
	@Autowired
	SpaceService spaceService;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public ModelAndView readSpace(ModelAndView mv) {

		List<SpaceDTO> spaceList = spaceService.readSpace();
		
		mv.addObject("spaceList", spaceList);
		
		mv.setViewName("reservation");
		
		System.out.println(mv);
	
		return mv;
	}
	
	
}

