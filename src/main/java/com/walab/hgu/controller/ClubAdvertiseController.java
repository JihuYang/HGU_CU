package com.walab.hgu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.service.ClubAdvertiseService;

@Controller
public class ClubAdvertiseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClubAdvertiseController.class);
		
	@Autowired
	ClubAdvertiseService clubAdvertiseService;
	
		//동아리 홍보 페이지 컨트롤러 
		@RequestMapping(value = "/clubAdvertise", method = RequestMethod.GET)
		public ModelAndView clubAdvertise(ModelAndView mv) {
			
			List<ClubAdvertiseDTO> clubAdvertiseList = clubAdvertiseService.readClubAdvertisePreview();
			
			mv.addObject("clubAdvertiseList", clubAdvertiseList);
			
			mv.setViewName("clubAdvertise");
			
			System.out.println(mv);
		
			return mv;
		}
		//동아리 홍보 게시글 쓰는 페이지 
		@RequestMapping(value = "/clubAdvertise/write", method = RequestMethod.GET)
		public String createClubAd(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			return "createClubAd";
		}

}
