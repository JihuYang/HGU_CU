package com.walab.hgu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.service.ClubAdvertiseService;
import com.walab.hgu.service.ClubService;
import com.walab.hgu.service.CommunityInfoService;
import com.walab.hgu.service.CommunityMaterialService;
import com.walab.hgu.service.SettingService;
import com.walab.hgu.service.UserService;
import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.DTO.SettingDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ClubService clubService;
	@Autowired
	CommunityInfoService communityInfoService;
	@Autowired
	CommunityMaterialService communityMaterialService;
	@Autowired
	SettingService settingService;
	@Autowired
	UserService userService;
	@Autowired
	ClubAdvertiseService clubAdvertiseService;
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
	public ModelAndView header(ModelAndView mv, HttpServletRequest httpServletRequest) {
		
		if(httpServletRequest.getSession().getAttribute("user") != null) {
			int userID = ((UserDTO)httpServletRequest.getSession().getAttribute("user")).getId();
			System.out.println(userID);
			mv.addObject("userID", userID);
		}
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		
		List<SettingDTO> fullSettingList = settingService.readSetting();
		List<Integer> officeHour = new ArrayList<>();
		
		for(int i=0;i<fullSettingList.size();i++) {
			if(fullSettingList.get(i).getKey().equals("오피스 아워 시작 시간") || fullSettingList.get(i).getKey().equals("오피스 아워 마감 시간")) {
				officeHour.add(fullSettingList.get(i).getValue());
			}
		}
		
		
		mv.addObject("categoryNameList", categoryNameList);// 인터셉터에서 넣어주기
		mv.addObject("officeHour", officeHour);
		mv.setViewName("home");
		System.out.println(mv);

		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView logintest(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchHome(ModelAndView mv, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		int count = communityInfoService.countInfo(searchType, keyword);// 게시물 총 갯수
		int postNum = 10;// 한 페이지에 출력할 게시물 갯수
		int pageNum = (int) Math.ceil((double) count / postNum);// 하단 페이징 번호
		int displayPost = (num - 1) * postNum;

		// 커뮤니티 공지사항 
		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo(displayPost, postNum,
				searchType, keyword);
		// 커뮤니티 자료실
		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService.readCommunityMaterial(displayPost,
				postNum, searchType, keyword);
		// 동아리 소개
		List<ClubDTO> clubIntroList = clubService.getAllClubIntroduction(keyword);
		// 동아리 홍보
		Page page = new Page();
		page.setPostNum(4);
		page.setNum(num);
		page.setCount(clubAdvertiseService.countInfo(searchType, keyword));
		
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		List<ClubAdvertiseDTO> clubAdvertiseList = clubAdvertiseService.readClubAdvertisePreview(page.getDisplayPost(),page.getPostNum(),searchType,keyword);
		
		int communityInfoListCount = communityInfoList.size();
		int communityMaterialListCount = communityMaterialList.size();
		int clubIntroListCount = clubIntroList.size();
		int clubAdvertiseListCount = clubAdvertiseList.size();
		
		mv.addObject("communityInfoListCount", communityInfoListCount);
		mv.addObject("communityMaterialListCount", communityMaterialListCount);
		mv.addObject("clubIntroListCount", clubIntroListCount);
		mv.addObject("clubAdvertiseListCount", clubAdvertiseListCount);


		mv.addObject("communityInfoList", communityInfoList);
		mv.addObject("communityMaterialList", communityMaterialList);
		mv.addObject("clubIntroList", clubIntroList);
		mv.addObject("clubAdvertiseList", clubAdvertiseList);

		mv.addObject("pageNum", pageNum);
		mv.addObject("page", page);
		mv.addObject("selected", num);

		System.out.println(mv);
		mv.setViewName("homeSearch");

		return mv;
	}
}
