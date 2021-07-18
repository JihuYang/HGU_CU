package com.walab.hgu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClubIntroductionController {

	private static final Logger logger = LoggerFactory.getLogger(ClubAdvertiseController.class);
	
	//동아리 홍보 페이지 컨트롤러 
	@RequestMapping(value = "/clubIntroduction", method = RequestMethod.GET)
	public String clubAdvertise(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "clubIntroduction";
	}
}