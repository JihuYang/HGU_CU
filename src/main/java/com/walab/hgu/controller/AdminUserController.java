package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;

import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminUserController {
	
	@Autowired
	UserService userService;	

	@RequestMapping(value = "/adminUser", method = RequestMethod.GET)
	public ModelAndView readUser(ModelAndView mv) {
		
		List<UserDTO> userList = userService.readUser();
		
		mv.addObject("userList", userList); 
		
		System.out.println(mv);

		
		mv.setViewName("adminUser");
			
		return mv;
	}
	
//	@RequestMapping(value = "/communityInfo/detail", method = RequestMethod.GET)
//	public ModelAndView readCommunityInfoDetail(ModelAndView mv) {
//
//		List<CommunityInfoDTO> communityInfoDetailList = communityInfoService.readCommunityInfoDetail();
//		
//		mv.addObject("communityInfoDetailList", communityInfoDetailList);
//		
//		System.out.println(mv);
//		
//		mv.setViewName("communityInfoDetail");
//			
//		return mv;
//	}
}
