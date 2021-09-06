package com.walab.hgu.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.UserDTO;
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

	// 동아리 홍보 페이지 컨트롤러
	@RequestMapping(value = "/clubIntroduction")
	public ModelAndView clubIntroductionDefault(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		ModelAndView mv = new ModelAndView();
		
		if(request.getSession().getAttribute("user") != null) {
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);	
		}
		// System.out.println(categoryId);
		List<ClubDTO> clubIntroList = clubService.getAllClubIntroduction(keyword);
		// List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		// String categoryName = clubIntroList.get(0).getCategoryName();
		String defaultImage = settingService.readSetting().get(2).getTextValue();

		mv.addObject("defaultImage", defaultImage);
		System.out.println("defaultImage 입니다" + defaultImage);
		mv.addObject("clubIntroList", clubIntroList);
		System.out.println("clubIntroList 입니다" + clubIntroList);
		mv.addObject("keyword", keyword);

		mv.setViewName("clubIntroduction");

		System.out.println(mv);

		return mv;
	}

	// 동아리 소개 분과별 페이지
	@RequestMapping(value = "/clubIntroduction/{categoryId}")
	public ModelAndView clubIntroduction(@PathVariable int categoryId, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		ModelAndView mv = new ModelAndView();

		System.out.println(categoryId);

		List<ClubDTO> clubIntroList = clubService.readClubIntroductionPreview(categoryId, keyword);
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		// String categoryName = clubIntroList.get(0).getCategoryName();

		String categoryName = categoryNameList.get(categoryId - 1).getCategoryName();
		int newCategoryId = categoryNameList.get(categoryId - 1).getId();

		mv.addObject("clubIntroList", clubIntroList);
		mv.addObject("categoryName", categoryName);
		mv.addObject("newCategoryId", newCategoryId);
		mv.addObject("keyword", keyword);

		mv.setViewName("clubIntroduction");

		System.out.println(mv);

		return mv;
	}

	@RequestMapping(value = "/clubIntroduction/{categoryId}/{clubId}", method = RequestMethod.GET) // 나중에는 동아리별 이름이나 번호로
																									// 연결하면 될것같아요..?
	public ModelAndView clubIntroductionDetail(@PathVariable int categoryId, @PathVariable int clubId,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

//		HashMap<String, Integer> clubMappingInfo = new HashMap<String, Integer>();
//		clubMappingInfo.put("categoryId", categoryId);
//		clubMappingInfo.put("clubId", clubId);
		
		if(request.getSession().getAttribute("user") != null) {
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);
			int userId = ((UserDTO)request.getSession().getAttribute("user")).getId();
			mv.addObject("userId", userId);
		}
		
		List<ClubDTO> clubDetailList = clubService.getClubDetailList(categoryId, clubId);
		System.out.println("clubDetailList: " + clubDetailList);

		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();

		String categoryName = categoryNameList.get(categoryId - 1).getCategoryName();

		List<ClubDTO> clubImgList = clubService.getClubImg(clubId);

		mv.addObject("categoryName", categoryName);
		mv.addObject("clubDetailList", clubDetailList);
		mv.addObject("clubImgList", clubImgList);
		mv.setViewName("clubIntroductionDetail");

		System.out.println(mv);
		System.out.println("clubDetailList in controller: " +clubDetailList);


		return mv;
	}

	// 동아리 홍보 글쓰기
	@RequestMapping(value = "/clubIntroduction/write", method = RequestMethod.GET) // 나중에는 동아리별 이름이나 번호로 연결하면 될것같아요..?
	public ModelAndView createClubIntro(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();

		// int foundationYearEnd = settingService.getFoundationYearEnd();
		int recentYear = Calendar.getInstance().get(Calendar.YEAR);
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();

		List<Integer> foundationYearList = new ArrayList<Integer>();
		for (int i = 1995; i <= recentYear; i++) {
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
	public ModelAndView createClubIntro(ModelAndView mv, MultipartHttpServletRequest request,
			@RequestParam(value = "categoryName") String categoryName,
			@RequestParam(value = "clubName") String clubName,
			@RequestParam(value = "clubLocation") String clubLocation,
			@RequestParam(value = "foundationDate") @DateTimeFormat(pattern = "yyyy") Date foundationDate,
			@RequestParam(value = "instagramLink") String instagramLink,
			@RequestParam(value = "facebookLink") String facebookLink,
			@RequestParam(value = "newContent") String newContent) throws ParseException {

		ClubDTO info = new ClubDTO();
		ClubDTO sns = new ClubDTO();
		FileDTO infoImageFile = new FileDTO();
		int recentId = clubService.readRecentClub() + 1;
		System.out.println("recentId: "+recentId);
		
		newContent = newContent.replaceAll("(\r|\n|\r\n|\n\r)","");
		
		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		int categoryId = 0;

		for (int i = 0; i < categoryNameList.size(); i++) {
			if (categoryNameList.get(i).getCategoryName().equals(categoryName)) {
				categoryId = i + 1;
				break;
			}
		}
		int userId = ((UserDTO)request.getSession().getAttribute("user")).getId();
		int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
		mv.addObject("admin", admin);

		int imgOrder = 1;
		
		info.setCategoryId(categoryId);
		info.setClubName(clubName);
		info.setUserId(userId);
		info.setClubDescription(newContent);
		info.setFoundationDate(foundationDate);
		info.setClubLocation(clubLocation);
		sns.setInstagramLink(instagramLink);
		sns.setFacebookLink(facebookLink);
		sns.setId(recentId);

		clubService.createClubIntro(info);
		

		List<MultipartFile> fileList = request.getFiles("file");
		for (MultipartFile imgFile : fileList) {

			String originalUrl = imgFile.getOriginalFilename();
			infoImageFile.setClubId(recentId);
			infoImageFile.setFileOrder(imgOrder);
			infoImageFile.setOriginalUrl(originalUrl);
			imgOrder++;
			clubService.createClubIntroImage(infoImageFile);

			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/clubIntro");

			File imgDir = new File(saveDir);

			if (!imgDir.exists()) {
				imgDir.mkdirs();
			}

			if (!imgFile.isEmpty()) {
				String ext = originalUrl.substring(originalUrl.lastIndexOf("."));

				try {
					imgFile.transferTo(new File(saveDir + "/" + originalUrl));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("club introduction controller saveDir: " + saveDir);


		}
		clubService.createClubSNS(sns);

		mv.setViewName("redirect:/clubIntroduction");

		return mv;
	}

	@RequestMapping(value = "/clubIntroduction/update/{categoryId}/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView updateCommunityInfo(@PathVariable int id, @PathVariable int categoryId, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		List<ClubDTO> clubDetailList = clubService.getClubDetailList(categoryId, id);

		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		String categoryName = categoryNameList.get(categoryId - 1).getCategoryName();

		List<ClubDTO> clubImgList = clubService.getClubImg(id);

		mv.addObject("categoryName", categoryName);
		mv.addObject("clubDetailList", clubDetailList);
		mv.addObject("clubImgList", clubImgList);

		mv.setViewName("updateClubIntro");

		return mv;
	}

	@RequestMapping(value = "/clubIntroduction/write/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateCommunityInfo(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file,
			@RequestParam(value = "categoryName") String categoryName,
			@RequestParam(value = "clubName") String clubName,
			@RequestParam(value = "clubLocation") String clubLocation,
			@RequestParam(value = "foundationDate") @DateTimeFormat(pattern = "yyyy") Date foundationDate,
			@RequestParam(value = "instagramLink") String instagramLink,
			@RequestParam(value = "facebookLink") String facebookLink,
			@RequestParam(value = "newContent") String newContent) {

		ClubDTO info = new ClubDTO();
		ClubDTO sns = new ClubDTO();
		FileDTO infoImageFile = new FileDTO();

		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		List<CategoryDTO> categoryNameList = clubService.getCategoryNameList();
		int categoryId = 0;

		for (int i = 0; i < categoryNameList.size(); i++) {
			if (categoryNameList.get(i).getCategoryName().equals(categoryName)) {
				categoryId = i + 1;
				break;
			}
		}
		// int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		// int clubOrder = 1;

		info.setId(id);
		info.setCategoryId(categoryId);
		info.setClubName(clubName);
		info.setUserId(userId);
		info.setClubDescription(newContent);
		info.setFoundationDate(foundationDate);
		info.setClubLocation(clubLocation);
		sns.setInstagramLink(instagramLink);
		sns.setFacebookLink(facebookLink);
		sns.setId(id);

		clubService.updateClubSNS(sns);
		
		List<MultipartFile> fileList = request.getFiles("file");
		System.out.println(fileList);
		
		int imgOrder = 1;
		
		if(fileList.get(0).getOriginalFilename() != "") {
			//선택된 파일이 있을 때 기존의 파일을 모두 삭제
			System.out.println("실행");
			clubService.deleteClubIntroImage(id);
			
			for (MultipartFile newfile : fileList) {
				String originalUrl = newfile.getOriginalFilename();
	
				infoImageFile.setClubId(id);
				infoImageFile.setOriginalUrl(originalUrl);
				infoImageFile.setFileOrder(imgOrder);
				imgOrder++;
	
				clubService.createClubIntroImage(infoImageFile);
	
				String originFileName = newfile.getOriginalFilename(); // 원본 파일 명
				long fileSize = newfile.getSize(); // 파일 사이즈
	
				System.out.println("originFileName : " + originFileName);
				System.out.println("fileSize : " + fileSize);
	
				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/clubIntro");
	
				File dir = new File(saveDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
	
				if (!newfile.isEmpty()) {
					String ext = originalUrl.substring(originalUrl.lastIndexOf("."));
					try {
						newfile.transferTo(new File(saveDir + "/" + originalUrl));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
	
				System.out.println(saveDir);
			}
		}

		clubService.updateClubIntro(info);
		System.out.println(info.toString());
		System.out.println(infoImageFile.toString());

		mv.setViewName("redirect:/clubIntroduction");

		return mv;
	}

	@RequestMapping(value = "/clubIntroduction/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteClubIntroduction(@PathVariable int id,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		clubService.deleteClubIntroImage(id);
		clubService.deleteClubSNS(id);
		clubService.deleteClubIntroduction(id);

//		List<ClubDTO> clubIntroList = clubService.getAllClubIntroduction(keyword);
//
//		mv.addObject("clubIntroList", clubIntroList);
//		System.out.println("clubIntroList 입니다" + clubIntroList);
//		mv.addObject("keyword", keyword);
//
//		System.out.println(mv);

		mv.setViewName("redirect:/clubIntroduction");

		return mv;
	}

}
