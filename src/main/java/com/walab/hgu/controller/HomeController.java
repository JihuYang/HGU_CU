package com.walab.hgu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.DTO.ReservationInfoDTO;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpServletRequest httpServletRequest) {
		
		if(httpServletRequest.getSession().getAttribute("user") != null) {
			int userID = ((UserDTO)httpServletRequest.getSession().getAttribute("user")).getId();
			mv.addObject("userID", userID);
		}
		
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		
		List<ReservationInfoDTO> officeHour = settingService.getOfficeHour();
		
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
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(value = "tag", required = false, defaultValue = "") String tag) {
		
		List<Page> page = new ArrayList<Page>(4);
		for(int i=0;i<4;i++) {
			page.add(new Page());
			page.get(i).setNum(num); 
			page.get(i).setSearchType(searchType);
			page.get(i).setKeyword(keyword);
		}
		// 커뮤니티 공지사항 
		page.get(0).setCount(communityInfoService.countInfo(searchType, keyword));
		//System.out.println("count: "+page.get(0).getCount());
		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo(page.get(0).getDisplayPost(),page.get(0).getPostNum(),searchType, keyword);
		
		// 커뮤니티 자료실
		page.get(1).setCount(communityMaterialService.countInfo(searchType, keyword));
		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService.readCommunityMaterial(page.get(1).getDisplayPost(),page.get(1).getPostNum(), searchType, keyword);
		
		// 동아리 소개
		List<ClubDTO> clubIntroList = clubService.getAllClubIntroduction(keyword);
		int count = 0;
		for (ClubDTO list : clubIntroList) {
			FileDTO imageFile = clubService.readClubPreviewImage(list.getId());
			if (imageFile != null) {
				clubIntroList.get(count).setOriginalUrl(imageFile.getOriginalUrl());
			}
			count++;
		}
		// List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		// String categoryName = clubIntroList.get(0).getCategoryName();
		String defaultImage = settingService.readSetting().get(2).getTextValue();

		mv.addObject("defaultImage", defaultImage);
		
		// 동아리 홍보
		page.get(3).setCount(clubAdvertiseService.countInfo(searchType, keyword));
		List<ClubAdvertiseDTO> clubAdvertiseList = clubAdvertiseService
				.readClubAdvertisePreview(page.get(3).getDisplayPost(), page.get(3).getPostNum(), searchType, keyword);

		int communityInfoListCount = page.get(0).getCount();
		int communityMaterialListCount = page.get(1).getCount();
		int clubIntroListCount = page.get(2).getCount();
		int clubAdvertiseListCount = page.get(3).getCount();
		int allCount = communityInfoListCount+communityMaterialListCount+clubIntroListCount+clubAdvertiseListCount;
		
		
		mv.addObject("communityInfoListCount", communityInfoListCount);
		mv.addObject("communityMaterialListCount", communityMaterialListCount);
		mv.addObject("clubIntroListCount", clubIntroListCount);
		mv.addObject("clubAdvertiseListCount", clubAdvertiseListCount);
		mv.addObject("allCount", allCount);


		mv.addObject("communityInfoList", communityInfoList);
		mv.addObject("communityMaterialList", communityMaterialList);
		mv.addObject("clubIntroList", clubIntroList);
		mv.addObject("clubAdvertiseList", clubAdvertiseList);

		//mv.addObject("pageNum", pageNum);
		mv.addObject("page", page);
		mv.addObject("selected", num);
		mv.addObject("tag", tag);

		System.out.println(mv);
		//System.out.println("getSearchTypeKeyword: "+page.get(0).getSearchTypeKeyword());
		mv.setViewName("homeSearch");

		return mv;
	}
}
