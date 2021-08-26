package com.walab.hgu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
import com.walab.hgu.DTO.Page;
import com.walab.hgu.service.CommunityInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityInfoController {

	@Autowired
	CommunityInfoService communityInfoService;

	@RequestMapping(value = "/communityInfo", method = RequestMethod.GET)
	public ModelAndView readCommunityInfo(ModelAndView mv, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		// ModelAndView mv = new ModelAndView();

		Page page = new Page();
		page.setNum(num);
		page.setCount(communityInfoService.countInfo(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<CommunityInfoDTO> communityInfoList = communityInfoService.readCommunityInfo(page.getDisplayPost(),
				page.getPostNum(), searchType, keyword);

		mv.addObject("communityInfoList", communityInfoList);
		mv.addObject("page", page);
		mv.addObject("selected", num);

		System.out.println(mv);

		mv.setViewName("communityInfo");

		return mv;
	}
	
	// 각 페이지 read
	@RequestMapping(value = "/communityInfo/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		// 조회수 업데이트
		communityInfoService.updateViewCount(id);
		// 공지사항 read
		CommunityInfoDTO communityInfoDetail = communityInfoService.readCommunityInfoDetail(id);
		// 공지사항 file read
		List<FileDTO> communityInfoFileDetail = communityInfoService.readCommunityInfoFileDetail(id);

		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

		mv.addObject("communityInfoDetail", communityInfoDetail);
		mv.addObject("communityInfoFileDetail", communityInfoFileDetail);

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
	public ModelAndView createCommunityInfo(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {

		CommunityInfoDTO info = new CommunityInfoDTO();
		FileDTO infoFile = new FileDTO();

		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		List<MultipartFile> fileList = request.getFiles("file");
		System.out.println(fileList);

		info.setUserId(userId);
		info.setTitle(title);
		info.setContent(content);
		info.setFile(file);

		communityInfoService.createCommunityInfo(info);

		int recentId = communityInfoService.readRecentCommunityInfo();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();
		String folder = format.format(time);
		int order = 1;
		for (MultipartFile newfile : fileList) {
			String originalUrl = newfile.getOriginalFilename();

			infoFile.setCommunityInfoId(recentId);
			infoFile.setOriginalUrl(originalUrl);
			infoFile.setOrder(order);
			order++;

			communityInfoService.createCommunityInfoFile(infoFile);

			String originFileName = newfile.getOriginalFilename(); // 원본 파일 명
			long fileSize = newfile.getSize(); // 파일 사이즈

			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);

			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/" + folder);

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
		}

		System.out.println(info.toString());
		System.out.println(infoFile.toString());

		mv.setViewName("redirect:/communityInfo?num=1");

		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/write/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateCommunityInfo(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {

		CommunityInfoDTO info = new CommunityInfoDTO();
		FileDTO infoFile = new FileDTO();

		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		info.setId(id);
		info.setUserId(userId);
		info.setTitle(title);
		info.setContent(content);
		//info.setFile(file);

		communityInfoService.updateCommunityInfo(info);
		
		List<MultipartFile> fileList = request.getFiles("newfile");
		
		if(fileList.get(0).getOriginalFilename() != "") {
			//선택된 파일이 있을 때 기존의 파일을 모두 삭제
			System.out.println("실행");
			communityInfoService.deleteCommunityInfoFile(id);
			System.out.println("update file");
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date time = new Date();
			String folder = format.format(time);
			for (MultipartFile newfile : fileList) {
				String originalUrl = newfile.getOriginalFilename();
	
				infoFile.setCommunityInfoId(id);
				infoFile.setOriginalUrl(originalUrl);
				infoFile.setRegdate(info.getRegdate());
				communityInfoService.createCommunityInfoFile(infoFile);
	
				String originFileName = newfile.getOriginalFilename(); // 원본 파일 명
				long fileSize = newfile.getSize(); // 파일 사이즈
	
				System.out.println("originFileName : " + originFileName);
				System.out.println("fileSize : " + fileSize);
	
				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/" + folder);
	
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
			}
		}

		System.out.println(info.toString());
		System.out.println(infoFile.toString());

		mv.setViewName("redirect:/communityInfo?num=1");

		return mv;
	}
	
	@RequestMapping(value = "/communityInfo/update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateCommunityInfo(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		communityInfoService.updateViewCount(id);

		CommunityInfoDTO communityInfoDetail = communityInfoService.readCommunityInfoDetail(id);

		List<FileDTO> communityInfoFileDetail = communityInfoService.readCommunityInfoFileDetail(id);

		mv.addObject("communityInfoDetail", communityInfoDetail);
		mv.addObject("communityInfoFileDetail", communityInfoFileDetail);

		System.out.println(mv);

		mv.setViewName("updateCommunityInfo");

		return mv;
	}

	@RequestMapping(value = "/communityInfo/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteCommunityInfo(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		communityInfoService.deleteCommunityInfoFile(id);
		communityInfoService.deleteCommunityInfo(id);

		System.out.println(mv);

		mv.setViewName("redirect:/communityInfo?num=1");

		return mv;
	}

	@RequestMapping("/communityInfo/detail/{id}/filedownload")
	public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		// file read
		FileDTO communityInfoFileDetail = communityInfoService.readCommunityInfoFileOneDetail(id);
		// file의 regdate를 불러와 저장된 폴더 read
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String folder = format.format(communityInfoFileDetail.getRegdate());
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/" + folder);
		String fileName = communityInfoFileDetail.getOriginalUrl();


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
