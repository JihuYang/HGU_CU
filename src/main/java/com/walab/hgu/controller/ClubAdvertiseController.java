package com.walab.hgu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.DTO.SettingDTO;
import com.walab.hgu.service.ClubAdvertiseService;
import com.walab.hgu.service.SettingService;

@Controller
public class ClubAdvertiseController {

	@Autowired
	ClubAdvertiseService clubAdvertiseService;
	
	@Autowired
	SettingService settingService;

	// 동아리 홍보 페이지 컨트롤러
	@RequestMapping(value = "/clubAdvertise", method = RequestMethod.GET)
	public ModelAndView clubAdvertise(ModelAndView mv, HttpSession session, HttpServletRequest request,
			@RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		if(request.getSession().getAttribute("user") != null) {
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);		
		}

		Page page = new Page();
		page.setPostNum(4);
		page.setNum(num);
		page.setCount(clubAdvertiseService.countInfo(searchType, keyword));

		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<ClubAdvertiseDTO> clubAdvertiseList = clubAdvertiseService.readClubAdvertisePreview(page.getDisplayPost(),
				page.getPostNum(), searchType, keyword);

		int count = 0;
		for (ClubAdvertiseDTO list : clubAdvertiseList) {
			FileDTO imageFile = clubAdvertiseService.readClubAdvertisePreviewImage(list.getId());
			if (imageFile != null) {
				clubAdvertiseList.get(count).setOriginalUrl(imageFile.getOriginalUrl());
			}
			count++;
		}
		
		String defaultImage = settingService.readSetting().get(2).getTextValue();

		mv.addObject("defaultImage", defaultImage);
		mv.addObject("clubAdvertiseList", clubAdvertiseList);
		mv.addObject("page", page);
		mv.addObject("selected", num);

		mv.setViewName("clubAdvertise");

		System.out.println(mv);

		return mv;
	}

	@RequestMapping(value = "/clubAdvertise/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(request.getSession().getAttribute("user") != null) {
			int userId = ((UserDTO)request.getSession().getAttribute("user")).getId();
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("userId", userId);		
			mv.addObject("admin", admin);		
		}

		List<ClubAdvertiseDTO> clubAdDetailList = clubAdvertiseService.readClubAdvertiseDetail(id);

		List<ClubAdvertiseDTO> clubAdImgList = clubAdvertiseService.getClubAdImg(id);

		List<FileDTO> clubAdFileList = clubAdvertiseService.readClubAdvertiseDetailFile(id);
		System.out.println("clubAdFileList: " + clubAdFileList);

		mv.addObject("clubAdDetailList", clubAdDetailList);
		mv.addObject("clubAdFileList", clubAdFileList);
		mv.addObject("clubAdImgList", clubAdImgList);

		System.out.println(mv);

		mv.setViewName("clubAdvertiseDetail");

		return mv;
	}

	// 동아리 홍보 게시글 쓰는 페이지
	@RequestMapping(value = "/clubAdvertise/write", method = RequestMethod.GET)
	public ModelAndView createClubAd(ModelAndView mv) {

		mv.setViewName("createClubAd");

		return mv;
	}

	@RequestMapping(value = "/clubAdvertise/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createClubAd(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {
		
		int id = ((UserDTO)request.getSession().getAttribute("user")).getId();
		
		ClubAdvertiseDTO info = new ClubAdvertiseDTO();
		FileDTO infoFile = new FileDTO();
		FileDTO infoImageFile = new FileDTO();

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		info.setWriter(id);
		info.setTitle(title);
		info.setContent(content);
		info.setFile(file);

		clubAdvertiseService.createClubAd(info);

		int recentId = clubAdvertiseService.readRecentClubAd();

		List<MultipartFile> imagefile = request.getFiles("imagefile");
		List<MultipartFile> adfile = request.getFiles("adfile");

		// 이미지 파일 저장
		int imgOrder = 1;
		for (MultipartFile newfile : imagefile) {
			String originalUrl = newfile.getOriginalFilename();

			infoImageFile.setClubAdvertiseId(recentId);
			infoImageFile.setOriginalUrl(originalUrl);
			infoImageFile.setFileOrder(imgOrder);

			clubAdvertiseService.createClubAdImage(infoImageFile);
			imgOrder++;

			System.out.println("image file print: " + infoImageFile);

			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/clubAd");

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
		}

		// 첨부파일 저장
		int order = 1;
		for (MultipartFile newfile : adfile) {
			String originalUrl = newfile.getOriginalFilename();

			infoFile.setClubAdvertiseId(recentId);
			infoFile.setFileOriginalUrl(originalUrl);
			infoFile.setFileOrder(order);
			order++;

			clubAdvertiseService.createClubAdFile(infoFile);

			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/clubAd");

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
		}

		System.out.println(info.toString());
		System.out.println(infoFile.toString());

		mv.setViewName("redirect:/clubAdvertise?num=1");

		return mv;
	}

	@RequestMapping(value = "/clubAdvertise/write/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateClubAdvertise(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {
		

		ClubAdvertiseDTO info = new ClubAdvertiseDTO();
		FileDTO infoFile = new FileDTO();
		FileDTO infoImageFile = new FileDTO();

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		info.setId(id);
		info.setTitle(title);
		info.setContent(content);
		info.setFile(file);
		
		clubAdvertiseService.updateClubAdvertise(info);

		// 동아리 소개 이미지 업데이트
		List<MultipartFile> imagefile = request.getFiles("imagefile");

		if (imagefile.get(0).getOriginalFilename() != "") {
			// 선택된 파일이 있을 때 기존의 파일을 모두 삭제
			System.out.println("실행");
			clubAdvertiseService.deleteClubAdvertiseImage(id);
			System.out.println("update file");
			int imgOrder = 1;
			for (MultipartFile newfile : imagefile) {
				String originalUrl = newfile.getOriginalFilename();
				
				infoImageFile.setClubAdvertiseId(id);
				infoImageFile.setOriginalUrl(originalUrl);
				infoImageFile.setFileOrder(imgOrder);
				
				clubAdvertiseService.createClubAdImage(infoImageFile);
				imgOrder++;

				String originFileName = newfile.getOriginalFilename(); // 원본 파일 명
				long fileSize = newfile.getSize(); // 파일 사이즈

				System.out.println("originFileName : " + originFileName);
				System.out.println("fileSize : " + fileSize);

				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/clubAd");

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

		// 동아리 소개 첨부파일 업데이트
		List<MultipartFile> adfile = request.getFiles("adfile");

		if (adfile.get(0).getOriginalFilename() != "") {
			// 선택된 파일이 있을 때 기존의 파일을 모두 삭제
			System.out.println("실행");
			clubAdvertiseService.deleteClubAdvertiseFile(id);
			System.out.println("update file");
			// 첨부파일 저장
			int order = 1;
			for (MultipartFile newfile : adfile) {
				String originalUrl = newfile.getOriginalFilename();

				infoFile.setClubAdvertiseId(id);
				infoFile.setFileOriginalUrl(originalUrl);
				infoFile.setFileOrder(order);
				order++;

				clubAdvertiseService.createClubAdFile(infoFile);

				String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/clubAd");

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
			}
		}
		System.out.println(info.toString());
		System.out.println(infoFile.toString());

		mv.setViewName("redirect:/clubAdvertise?num=1");

		return mv;
	}

	@RequestMapping(value = "/clubAdvertise/update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateCommunityInfo(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		ModelAndView mv = new ModelAndView();
		
		List<ClubAdvertiseDTO> clubAdDetailList = clubAdvertiseService.readClubAdvertiseDetail(id);

		List<ClubAdvertiseDTO> clubAdImgList = clubAdvertiseService.getClubAdImg(id);

		List<FileDTO> clubAdFileList = clubAdvertiseService.readClubAdvertiseDetailFile(id);
		
		mv.addObject("clubAdDetailList", clubAdDetailList);
		mv.addObject("clubAdFileList", clubAdFileList);
		mv.addObject("clubAdImgList", clubAdImgList);

		System.out.println(mv);

		mv.setViewName("updateClubAd");

		return mv;
	}

	@RequestMapping(value = "/clubAdvertise/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteclubAdvertise(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		clubAdvertiseService.deleteClubAdvertiseFile(id);
		clubAdvertiseService.deleteClubAdvertiseImage(id);
		clubAdvertiseService.deleteClubAdvertise(id);

		List<FileDTO> clubAdvertiseDetail = clubAdvertiseService.readClubAdvertiseDetailFile(id);
		// String saveDir =
		// request.getSession().getServletContext().getRealPath("/resources/upload/file");

		// String fileName = clubAdvertiseDetail.getOriginalUrl();
		// System.out.println("filename: " + fileName);

		mv.addObject("clubAdvertiseDetail", clubAdvertiseDetail);

		System.out.println(mv);

		mv.setViewName("redirect:/clubAdvertise?num=1");

		return mv;
	}

	@RequestMapping("/clubAdvertise/detail/{id}/filedownload")
	public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		FileDTO clubAdDetail = clubAdvertiseService.readClubAdvertiseDetailFileOne(id);
		
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/clubAd");
		String fileName = clubAdDetail.getFileOriginalUrl();

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
