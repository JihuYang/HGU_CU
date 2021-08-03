package com.walab.hgu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.service.ClubService;
import com.walab.hgu.service.SettingService;
import com.walab.hgu.service.UserService;

@Controller
public class ClubIntroductionController {

	@Autowired
	ClubService clubService;
	@Autowired
	SettingService settingService;
	@Autowired
	UserService userService;
	
	//동아리 홍보 페이지 컨트롤러
	@RequestMapping(value = "/clubIntroduction")
	public ModelAndView clubIntroductionDefault(HttpSession session, HttpServletRequest request ) {
		ModelAndView mv = new ModelAndView();
		//System.out.println(categoryId);
		List<ClubDTO> clubIntroList = clubService.getAllClubIntroduction();
		//List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		//String categoryName = clubIntroList.get(0).getCategoryName();
		
		mv.addObject("clubIntroList", clubIntroList);
		
		mv.setViewName("clubIntroduction");
		
		System.out.println(mv);
		
		return mv;
	}
	
	//동아리 소개 분과별 페이 
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
		
//		HashMap<String, Integer> clubMappingInfo = new HashMap<String, Integer>();
//		clubMappingInfo.put("categoryId", categoryId);
//		clubMappingInfo.put("clubId", clubId);
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
	public ModelAndView createClubIntro(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		
		//int foundationYearEnd = settingService.getFoundationYearEnd();
		int recentYear = Calendar.getInstance().get(Calendar.YEAR);
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		
		List<Integer> foundationYearList = new ArrayList<Integer>();
		for(int i=1995;i<=recentYear;i++) {
			foundationYearList.add(i);
		}
		mv.addObject("foundationYearList", foundationYearList);
		mv.addObject("categoryNameList", categoryNameList);
		mv.setViewName("createClubIntro");
		 
		System.out.println(mv);
		return mv;
	}
	
	@RequestMapping(value = "/clubIntroduction/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createClubIntro(ModelAndView mv,
			@RequestParam(value="categoryName") String categoryName,
			@RequestParam(value="clubName") String clubName,
			@RequestParam(value="clubLocation") String clubLocation,
			@RequestParam(value="foundationDate") String foundationDate,
			@RequestParam(value="instagramLink") String instagramLink,
			@RequestParam(value="facebookLink") String facebookLink,
			@RequestParam(value="clubDescription") String clubDescription,
			@RequestParam(value="originalUrl") String originalUrl) {
		System.out.println(foundationDate);
		ClubDTO intro = new ClubDTO();
		ClubDTO sns = new ClubDTO();
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		int categoryId =0;
		
		for(int i=0;i<categoryNameList.size();i++) {
			if(categoryNameList.get(i).getCategoryName().equals(categoryName)) {
				categoryId=i+1;
				break;
			}
		}
		System.out.println(categoryId);
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

		Date foundationDateRE = null;
		try {
			foundationDateRE = fm.parse(foundationDate);
			System.out.println(foundationDateRE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// userDTO끌고 와서 clubName 비교해서 userId 찾기
		//userService.getUser --> 동아리 대표는 관리자가 나중에 삽입
				
		intro.setClubName(clubName);
		intro.setCategoryId(categoryId);
		intro.setClubLocation(clubLocation);
		intro.setFoundationDate(foundationDateRE);
		intro.setClubDescription(clubDescription);
		
		clubService.createClubIntro(intro);
		
		//위에 넣고 다시 club끌고 와서 마지막 추가된 것의 clubId 함께 ClubSns table에 삽입,,,
		List<ClubDTO> clubList = clubService.getClubList();
		int id = clubList.get(0).getId();
		sns.setId(id);
		sns.setInstagramLink(instagramLink);
		sns.setFacebookLink(facebookLink);
		
		clubService.createClubSNS(sns);
		
		//intro.setOriginalUrl(originalUrl);

//		System.out.println(intro.toString());
//		
//		System.out.println(originalUrl);

		
		

		mv.setViewName("createClubIntro");
			
		return mv;
	}
}
