package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.service.CommunityInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityInfoController {
	
	
	@Autowired
	CommunityInfoService communityInfoService;

	@RequestMapping(value = "/communityInfo", method = RequestMethod.GET)
	public ModelAndView readCommunityInfo(ModelAndView mv) {

		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo();
		
		mv.addObject("communityInfoList", communityInfoList);
		
		mv.setViewName("communityInfo");
			
		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/detail", method = RequestMethod.GET)
	public ModelAndView readCommunityInfoDetail(ModelAndView mv) {

		List<CommunityInfoDTO> communityInfoDetailList = communityInfoService.readCommunityInfoDetail();
		
		mv.addObject("communityInfoDetailList", communityInfoDetailList);
		
		System.out.println(mv);
		
		mv.setViewName("communityInfoDetail");
			
		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/write", method = RequestMethod.GET)
	public ModelAndView createCommunityInfo(ModelAndView mv) {

				
		mv.setViewName("createCommunityInfo");
			
		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createCommunityInfo(ModelAndView mv,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="originalUrl") String originalUrl) {
		
		CommunityInfoDTO info = new CommunityInfoDTO();
		
		info.setUserId(userId);
		info.setTitle(title);
		info.setContent(content);
		
		//info.setOriginalUrl(originalUrl);

		System.out.println(info.toString());
		
		System.out.println(originalUrl);

		communityInfoService.createCommunityInfo(info);
		

		mv.setViewName("createCommunityInfo");
			
		return mv;
	}
}
