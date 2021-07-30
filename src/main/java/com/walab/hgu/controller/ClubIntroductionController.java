package com.walab.hgu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.service.ClubService;

@Controller
public class ClubIntroductionController {

	private static final Logger logger = LoggerFactory.getLogger(ClubAdvertiseController.class);
	
	@Autowired
	ClubService clubService;
	
	//동아리 홍보 페이지 컨트롤러 
	@RequestMapping(value = "/clubIntroduction/{categoryId}")
	public ModelAndView clubIntroduction(@PathVariable int categoryId, HttpSession session, HttpServletRequest request ) {
		ModelAndView mv = new ModelAndView();
		System.out.println(categoryId);
		List<ClubDTO> clubIntroList = clubService.readClubIntroductionPreview(categoryId);
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		//String categoryName = clubIntroList.get(0).getCategoryName();
		
		String categoryName = categoryNameList.get(categoryId-1).getCategoryName();
		
		
		mv.addObject("clubIntroList", clubIntroList);
		mv.addObject("categoryName", categoryName);
		
		mv.setViewName("clubIntroduction");
		
		System.out.println(mv);
		
		return mv;
	}
	
	@RequestMapping(value = "/clubIntroduction/{categoryId}/{clubId}", method = RequestMethod.GET)//나중에는 동아리별 이름이나 번호로 연결하면 될것같아요..? 
	public ModelAndView clubIntroductionDetail(@PathVariable int categoryId,@PathVariable int clubId, HttpSession session, HttpServletRequest request ) {
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, Integer> clubMappingInfo = new HashMap<String, Integer>();
		clubMappingInfo.put("categoryId", categoryId);
		clubMappingInfo.put("clubId", clubId);
		List<ClubDTO> clubDetailList = clubService.getClubDetailList(categoryId,clubId);
		
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		String categoryName = categoryNameList.get(categoryId-1).getCategoryName();
		
		List<ClubDTO> clubImgList = clubService.getClubImg(clubId);
		
		mv.addObject("categoryName", categoryName);
		mv.addObject("clubDetailList", clubDetailList);
		mv.addObject("clubImgList", clubImgList);
		mv.setViewName("clubIntroductionDetail");
		
		System.out.println(mv);
		
		
		return mv;
	}
	
	//동아리 홍보 글쓰기 
	@RequestMapping(value = "/clubIntroduction/write", method = RequestMethod.GET)//나중에는 동아리별 이름이나 번호로 연결하면 될것같아요..? 
	public String createClubIntro(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "createClubIntro";
	}
}
