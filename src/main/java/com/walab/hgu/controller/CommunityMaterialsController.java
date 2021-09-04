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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.UserDTO;
import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.service.CommunityMaterialService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityMaterialsController {

	@Autowired
	CommunityMaterialService communityMaterialService;

	@RequestMapping(value = "/communityMaterials", method = RequestMethod.GET)
	public ModelAndView readCommunityMaterial(ModelAndView mv, HttpSession session, HttpServletRequest request,
			@RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		
		if(request.getSession().getAttribute("user") != null) {
			int admin = ((UserDTO)request.getSession().getAttribute("user")).getAdmin();
			mv.addObject("admin", admin);
			
		}
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(communityMaterialService.countInfo(searchType, keyword));

		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService
				.readCommunityMaterial(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		System.out.println(searchType + keyword);
		mv.addObject("communityMaterialList", communityMaterialList);
		mv.addObject("page", page);
		mv.addObject("selected", num);

		mv.setViewName("communityMaterials");

		return mv;
	}

	// 각 페이지 read
	@RequestMapping(value = "/communityMaterials/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityMaterialDetail(@PathVariable int id, HttpSession session,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		// 조회수 업데이트
		communityMaterialService.updateViewCount(id);
		// 자료실 read
		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		// 자료실 file read
		List<FileDTO> communityMaterialFileDetail = communityMaterialService.readCommunityMaterialFileDetail(id);

		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

		mv.addObject("communityMaterialDetail", communityMaterialDetail);
		mv.addObject("communityMaterialFileDetail", communityMaterialFileDetail);

		mv.setViewName("communityMaterialDetail");

		return mv;
	}

	@RequestMapping(value = "/communityMaterials/write", method = RequestMethod.GET)
	public ModelAndView createCommunityMaterial(ModelAndView mv) {

		mv.setViewName("createCommunityMaterials");

		return mv;
	}

	@RequestMapping(value = "/communityMaterials/write/create", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createCommunityMaterial(ModelAndView mv, MultipartHttpServletRequest request, HttpServletRequest servletRequest,
			MultipartFile file) {

		CommunityMaterialDTO material = new CommunityMaterialDTO();
		FileDTO materialFile = new FileDTO();
		
		//int userId = ((UserDTO)servletRequest.getSession().getAttribute("user")).getId();
		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("newContent");

		content = content.replaceAll("(\r|\n|\r\n|\n\r)","");
		
		List<MultipartFile> fileList = request.getFiles("file");
		System.out.println(fileList);

		material.setUserId(userId);
		material.setTitle(title);
		material.setContent(content);
		material.setFile(file);

		communityMaterialService.createCommunityMaterial(material);

		int recentId = communityMaterialService.readRecentCommunityMaterial();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();
		String folder = format.format(time);
		int order = 1;
		for (MultipartFile newfile : fileList) {
			String originalUrl = newfile.getOriginalFilename();

			materialFile.setCommunityMaterialId(recentId);
			materialFile.setOriginalUrl(originalUrl);
			materialFile.setOrder(order);
			order++;

			communityMaterialService.createCommunityMaterialFile(materialFile);

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
		System.out.println(material.toString());
		System.out.println(materialFile.toString());

		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}

	@RequestMapping(value = "/communityMaterials/write/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateCommunityMaterial(ModelAndView mv, MultipartHttpServletRequest request,
			MultipartFile file) {

		CommunityMaterialDTO material = new CommunityMaterialDTO();
		FileDTO materialFile = new FileDTO();

		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		material.setId(id);
		material.setUserId(userId);
		material.setTitle(title);
		material.setContent(content);
		// material.setFile(file);

		communityMaterialService.updateCommunityMaterial(material);

		List<MultipartFile> fileList = request.getFiles("newfile");

		if (fileList.get(0).getOriginalFilename() != "") {
			// 선택된 파일이 있을 때 기존의 파일을 모두 삭제
			System.out.println("실행");
			communityMaterialService.deleteCommunityMaterialFile(id);
			System.out.println("update file");
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date time = new Date();
			String folder = format.format(time);
			for (MultipartFile newfile : fileList) {
				String originalUrl = newfile.getOriginalFilename();

				materialFile.setCommunityMaterialId(id);
				materialFile.setOriginalUrl(originalUrl);
				materialFile.setRegdate(material.getRegdate());
				communityMaterialService.createCommunityMaterialFile(materialFile);

				String originFileName = newfile.getOriginalFilename(); // 원본 파일 명
				long fileSize = newfile.getSize(); // 파일 사이즈

				System.out.println("originFileName : " + originFileName);
				System.out.println("fileSize : " + fileSize);

				String saveDir = request.getSession().getServletContext()
						.getRealPath("/resources/upload/file/" + folder);

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
		}

		System.out.println(material.toString());
		System.out.println(materialFile.toString());

		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}

	@RequestMapping(value = "/communityMaterials/update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateCommunityMaterial(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		communityMaterialService.updateViewCount(id);

		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		List<FileDTO> communityMaterialFileDetail = communityMaterialService.readCommunityMaterialFileDetail(id);

		mv.addObject("communityMaterialDetail", communityMaterialDetail);
		mv.addObject("communityMaterialFileDetail", communityMaterialFileDetail);

		System.out.println(mv);

		mv.setViewName("updateCommunityMaterial");

		return mv;
	}

	@RequestMapping(value = "/communityMaterials/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteCommunityMaterial(@PathVariable int id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		communityMaterialService.deleteCommunityMaterialFile(id);
		communityMaterialService.deleteCommunityMaterial(id);
		
		System.out.println(mv);

		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}

	@RequestMapping("/communityMaterials/detail/{id}/filedownload")
	public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		// file read
		FileDTO communityMaterialFileDetail = communityMaterialService.readCommunityMaterialFileOneDetail(id);
		// file의 regdate를 불러와 저장된 폴더 read
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String folder = format.format(communityMaterialFileDetail.getRegdate());
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/" + folder);
		String fileName = communityMaterialFileDetail.getOriginalUrl();

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
