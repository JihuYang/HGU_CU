package com.walab.hgu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.service.CommunityInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityInfoController {

	@Autowired
	CommunityInfoService communityInfoService;

	@RequestMapping(value = "/communityInfo", method = RequestMethod.GET)
	public ModelAndView readCommunityInfo(ModelAndView mv, @RequestParam("num") int num) {
		//ModelAndView mv = new ModelAndView();
		
		//게시물 총 갯수 
		int count = communityInfoService.countInfo();
		
		//한 페이지에 출력할 게시물 갯수 
		int postNum = 10;
		//하단 페이징 번호
		int pageNum = (int)Math.ceil((double)count/postNum);
		//출력할 게시물 
		int displayPost = (num - 1) * postNum;

		//한번에 표시할 페이징 번호의 갯수 
		int pageNum_cnt = 5;
		//표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num/(double)pageNum_cnt) * pageNum_cnt);
		//표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		//마지막 페이징 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count/(double)postNum));
		if(endPageNum > endPageNum_tmp)
			endPageNum = endPageNum_tmp;
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * postNum >= count ? false : true;
		
		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo(displayPost,postNum);
		
		mv.addObject("communityInfoList", communityInfoList);
		mv.addObject("pageNum", pageNum);
		mv.addObject("startPageNum", startPageNum);
		mv.addObject("endPageNum", endPageNum);
		mv.addObject("prev", prev);
		mv.addObject("next", next);
		mv.addObject("selected", num);
		
		System.out.println(mv);
		
		mv.setViewName("communityInfo");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		communityInfoService.updateViewCount(id);

		CommunityInfoDTO communityInfoDetail = communityInfoService.readCommunityInfoDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		String fileName = communityInfoDetail.getOriginalUrl();
		System.out.println("filename: " + fileName);
		
//		File file = new File(saveDir + "/" + fileName);
//		FileInputStream fis = null;
//		BufferedInputStream bis = null;
//		ServletOutputStream sos = null;
//		try {
//			fis = new FileInputStream(file);
//			bis = new BufferedInputStream(fis);
//			sos = response.getOutputStream();
//			String reFilename = "";
//			boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
//					|| request.getHeader("user-agent").indexOf("Trident") != -1;
//			if (isMSIE) {
//				reFilename = URLEncoder.encode("이미지 파일.jpg", "utf-8");
//				reFilename = reFilename.replaceAll("\\+", "%20");
//			} else {
//				reFilename = new String("이미지 파일.jpg".getBytes("utf-8"), "ISO-8859-1");
//			}
//			response.setContentType("application/octet-stream;charset=utf-8");
//			response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
//			response.setContentLength((int) file.length());
//			int read = 0;
//			while ((read = bis.read()) != -1) {
//				sos.write(read);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				sos.close();
//				bis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		mv.addObject("communityInfoDetail", communityInfoDetail);

		System.out.println(mv);

		mv.setViewName("communityInfoDetail");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/write", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView createCommunityInfo(ModelAndView mv) {

		mv.setViewName("createCommunityInfo");

		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateCommunityInfo(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		communityInfoService.updateViewCount(id);

		CommunityInfoDTO communityInfoDetail = communityInfoService.readCommunityInfoDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		String fileName = communityInfoDetail.getOriginalUrl();
		System.out.println("filename: " + fileName);
		
		mv.addObject("communityInfoDetail", communityInfoDetail);

		System.out.println(mv);


		mv.setViewName("updateCommunityInfo");

		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createCommunityInfo(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {

		CommunityInfoDTO info = new CommunityInfoDTO();
		FileDTO infoFile = new FileDTO();

		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MultipartFile newfile = request.getFile("file");
		String originalUrl = newfile.getOriginalFilename();

		info.setUserId(userId);
		info.setTitle(title);
		info.setContent(content);
		info.setFile(file);
		
		communityInfoService.createCommunityInfo(info);
		
		int recentId = communityInfoService.readRecentCommunityInfo();
		
		System.out.println(recentId);
	
		infoFile.setCommunityInfoId(recentId);
		infoFile.setOriginalUrl(originalUrl);
		
		communityInfoService.creatCommunityInfoFile(infoFile);

		System.out.println(info.toString());
		System.out.println(infoFile.toString());


		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		if (!newfile.isEmpty()) {
			String ext = originalUrl.substring(originalUrl.lastIndexOf("."));

			// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
			// int rand = (int)(Math.random()*1000);

			// String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;

			try {
				newfile.transferTo(new File(saveDir + "/" + originalUrl));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(saveDir);


		mv.setViewName("redirect:/communityInfo");

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

	@RequestMapping("/communityInfo/detail/{id}/filedownload")
	public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		CommunityInfoDTO communityInfoDetail = communityInfoService.readCommunityInfoDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		String fileName = communityInfoDetail.getOriginalUrl();
		System.out.println("filename: " + fileName);

		File file = new File(saveDir + "/" + fileName);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			sos = response.getOutputStream();
			String reFilename = "";
			boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
					|| request.getHeader("user-agent").indexOf("Trident") != -1;
			if (isMSIE) {
				reFilename = URLEncoder.encode(fileName, "utf-8");
				reFilename = reFilename.replaceAll("\\+", "%20");
			} else {
				reFilename = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
			}
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
			response.setContentLength((int) file.length());
			int read = 0;
			while ((read = bis.read()) != -1) {
				sos.write(read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
