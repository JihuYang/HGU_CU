package com.walab.hgu.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

	@RequestMapping(value = "/communityInfo/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		List<CommunityInfoDTO> communityInfoDetailList = communityInfoService.readCommunityInfoDetail(id);

		mv.addObject("communityInfoDetailList", communityInfoDetailList);

		System.out.println(mv);

		mv.setViewName("communityInfoDetail");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/write", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView createCommunityInfo(ModelAndView mv) {

		mv.setViewName("createCommunityInfo");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createCommunityInfo(ModelAndView mv, @RequestParam(value = "userId") int userId,
			@RequestParam(value = "title") String title, @RequestParam(value = "content") String content,
			@RequestParam(value = "originalUrl") String originalUrl) {

		CommunityInfoDTO info = new CommunityInfoDTO();

		info.setUserId(userId);
		info.setTitle(title);
		info.setContent(content);
		info.setOriginalUrl(originalUrl);

		System.out.println(info.toString());
//		
//		System.out.println(originalUrl);

		communityInfoService.createCommunityInfo(info);

		mv.setViewName("communityInfo");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView uploadFile(ModelAndView mv, MultipartHttpServletRequest request,
			@RequestParam(value = "originalUrl") MultipartFile upload) {
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		MultipartFile f = upload;
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		System.out.println(f);

		mv.setViewName("communityInfo");

		return mv;

//		// 파일이 업로드 될 경로 설정
//		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
//		MultipartFile f = upload;
//		// 위에서 설정한 경로의 폴더가 없을 경우 생성
//		File dir = new File(saveDir);
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//
//		if (!f.isEmpty()) {
//			String orifileName = f.getOriginalFilename();
//			String ext = orifileName.substring(orifileName.lastIndexOf("."));
//
//			// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
//			// int rand = (int)(Math.random()*1000);
//
//			// String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;
//
//			try {
//				f.transferTo(new File(saveDir + "/" + orifileName));
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println(saveDir);
//		return "communityInfo";

	}
}
