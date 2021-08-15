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

import com.walab.hgu.DTO.CommunityInfoDTO;
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
	public ModelAndView readCommunityMaterial(ModelAndView mv, @RequestParam("num") int num, 
			@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType, 
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) {
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(communityMaterialService.countInfo(searchType, keyword));
		
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService.readCommunityMaterial(page.getDisplayPost(),page.getPostNum(),searchType, keyword);
		
		System.out.println(searchType + keyword);
		mv.addObject("communityMaterialList", communityMaterialList);
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		mv.setViewName("communityMaterials");
	
		return mv;
	}

	@RequestMapping(value = "/communityMaterials/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityMaterialDetail(@PathVariable int id, HttpSession session,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		communityMaterialService.updateViewCount(id);

		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

		String fileName = communityMaterialDetail.getOriginalUrl();

		System.out.println("filename: " + fileName);

		mv.addObject("communityMaterialDetail", communityMaterialDetail);

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
	public ModelAndView createCommunityMaterial(ModelAndView mv, MultipartHttpServletRequest request,
			MultipartFile file) {

		CommunityMaterialDTO material = new CommunityMaterialDTO();

		FileDTO materialFile = new FileDTO();

		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MultipartFile newfile = request.getFile("file");
		String originalUrl = newfile.getOriginalFilename();

		material.setUserId(userId);
		material.setTitle(title);
		material.setContent(content);
		material.setFile(file);

		communityMaterialService.createCommunityMaterial(material);

		int recentId = communityMaterialService.readRecentCommunityMaterial();

		System.out.println(recentId);

		materialFile.setCommunityMaterialId(recentId);
		materialFile.setOriginalUrl(originalUrl);

		communityMaterialService.createCommunityMaterialFile(materialFile);

		System.out.println(material.toString());
		System.out.println(materialFile.toString());

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

		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}
	@RequestMapping(value = "/communityMaterials/write/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateCommunityMaterial(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {

		CommunityMaterialDTO material = new CommunityMaterialDTO();
		FileDTO materialFile = new FileDTO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MultipartFile newfile = request.getFile("file");
		String originalUrl = newfile.getOriginalFilename();

		material.setId(id);
		material.setUserId(userId);
		material.setTitle(title);
		material.setContent(content);
		material.setFile(file);
		
		communityMaterialService.updateCommunityMaterial(material);
	
		materialFile.setCommunityMaterialId(id);
		materialFile.setOriginalUrl(originalUrl);
		
		communityMaterialService.updateCommunityMaterialFile(materialFile);

		System.out.println(material.toString());
		System.out.println(materialFile.toString());


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


		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}
	@RequestMapping(value = "/communityMaterials/update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateCommunityInfo(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		communityMaterialService.updateViewCount(id);

		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		String fileName = communityMaterialDetail.getOriginalUrl();
		System.out.println("filename: " + fileName);
		
		mv.addObject("communityMaterialDetail", communityMaterialDetail);

		System.out.println(mv);


		mv.setViewName("updateCommunityMaterial");

		return mv;
	}
	@RequestMapping(value = "/communityMaterials/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteCommunityMaterial(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		communityMaterialService.deleteCommunityMaterialFile(id);
		communityMaterialService.deleteCommunityMaterial(id);
		
		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		//String fileName = communityInfoDetail.getOriginalUrl();

		//System.out.println("filename: " + fileName);
		
		mv.addObject("communityMaterialDetail", communityMaterialDetail);

		System.out.println(mv);

		mv.setViewName("redirect:/communityMaterials?num=1");

		return mv;
	}
	@RequestMapping("/communityMaterial/detail/{id}/filedownload")
	public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		CommunityMaterialDTO communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

		String fileName = communityMaterialDetail.getOriginalUrl();
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
