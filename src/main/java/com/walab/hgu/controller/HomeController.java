package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.service.ClubService;
import com.walab.hgu.service.CommunityInfoService;
import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.PagingDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ClubService clubService;

	@Autowired
	CommunityInfoService communityInfoService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView header(ModelAndView mv) {

		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		mv.addObject("categoryNameList", categoryNameList);// 인터셉터에서 넣어주기
		mv.setViewName("home");
		System.out.println(mv);

		return mv;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchHome(ModelAndView mv, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {

		int listCnt = communityInfoService.countInfo();

		PagingDTO pagination = new PagingDTO();
		pagination.pageInfo(page, range, listCnt);

		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo(pagination);

		mv.addObject("pagination", pagination);
		mv.addObject("communityInfoList", communityInfoList);

		mv.setViewName("homeSearch");

		return mv;
	}
}
