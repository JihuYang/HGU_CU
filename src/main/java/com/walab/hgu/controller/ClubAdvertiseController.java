package com.walab.hgu.controller;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		@RequestMapping(value = "/clubAdvertise/detail/{id}", method = RequestMethod.GET)
		public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request ) {
			ModelAndView mv = new ModelAndView();
			
			List<ClubAdvertiseDTO> clubAdDetailList = clubAdvertiseService.readClubAdvertiseDetail(id);
			
			List<ClubAdvertiseDTO> clubAdImgList = clubAdvertiseService.getClubAdImg(id);  
			
			mv.addObject("clubAdDetailList", clubAdDetailList);
			mv.addObject("clubAdImgList", clubAdImgList);
			
			System.out.println(mv);
			
			mv.setViewName("clubAdvertiseDetail");
				
			return mv;
		}
		
		//동아리 홍보 게시글 쓰는 페이지 
		@RequestMapping(value = "/clubAdvertise/write", method = RequestMethod.GET)
		public ModelAndView createClubAd(ModelAndView mv) {
			
			mv.setViewName("createClubAd");
			
			return mv;
		}
		
		@RequestMapping(value = "/clubAdvertise/write/create", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView createClubAd(ModelAndView mv,
				@RequestParam(value="title") String title,
				@RequestParam(value="content") String content,
				@RequestParam(value="originalUrl") String originalUrl,
				@RequestParam(value="fileOriginalUrl") String fileOriginalUrl) {
			
			ClubAdvertiseDTO info = new ClubAdvertiseDTO();
			
			info.setTitle(title);
			info.setContent(content);
			
			//info.setOriginalUrl(originalUrl);
			
			clubAdvertiseService.createClubAd(info);
			
			mv.setViewName("createClubAd");
			
			return mv;
		}

}
