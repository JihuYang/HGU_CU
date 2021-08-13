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

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.Page;
import com.walab.hgu.service.ClubAdvertiseService;

@Controller
public class ClubAdvertiseController {
		
	@Autowired
	ClubAdvertiseService clubAdvertiseService;
	
		//동아리 홍보 페이지 컨트롤러 
		@RequestMapping(value = "/clubAdvertise", method = RequestMethod.GET)
		public ModelAndView clubAdvertise(ModelAndView mv, @RequestParam("num") int num) {
			Page page = new Page();
			page.setPostNum(4);
			page.setNum(num);
			page.setCount(clubAdvertiseService.countInfo());
			
			List<ClubAdvertiseDTO> clubAdvertiseList = clubAdvertiseService.readClubAdvertisePreview(page.getDisplayPost(),page.getPostNum());
			
			mv.addObject("clubAdvertiseList", clubAdvertiseList);
			mv.addObject("page", page);
			mv.addObject("selected", num);
			
			mv.setViewName("clubAdvertise");
			
			System.out.println(mv);
		
			return mv;
		}
		
		@RequestMapping(value = "/clubAdvertise/detail/{id}", method = RequestMethod.GET)
		public ModelAndView readCommunityInfoDetail(@PathVariable int id, HttpSession session, HttpServletRequest request ) {
			ModelAndView mv = new ModelAndView();
			
			List<ClubAdvertiseDTO> clubAdDetailList = clubAdvertiseService.readClubAdvertiseDetail(id);
			
			List<ClubAdvertiseDTO> clubAdImgList = clubAdvertiseService.getClubAdImg(id);  
			
			mv.addObject("clubAdDetailList", clubAdDetailList);
			mv.addObject("clubAdImgList", clubAdImgList);
			
			System.out.println(mv);
			
			mv.setViewName("clubAdvertiseDetail");
				
			return mv;
		}
		
		//동아리 홍보 게시글 쓰는 페이지 
		@RequestMapping(value = "/clubAdvertise/write", method = RequestMethod.GET)
		public ModelAndView createClubAd(ModelAndView mv) {
			
			mv.setViewName("createClubAd");
			
			return mv;
		}
		
//		@RequestMapping(value = "/clubAdvertise/write/create", method = RequestMethod.POST)
//		@ResponseBody
//		public ModelAndView createClubAd(ModelAndView mv,
//				@RequestParam(value="title") String title,
//				@RequestParam(value="content") String content,
//				@RequestParam(value="originalUrl") String originalUrl,
//				@RequestParam(value="fileOriginalUrl") String fileOriginalUrl) {
//			
//			ClubAdvertiseDTO info = new ClubAdvertiseDTO();
//			
//			info.setTitle(title);
//			info.setContent(content);
//			
//			//info.setOriginalUrl(originalUrl);
//			
//			clubAdvertiseService.createClubAd(info);
//			
//			mv.setViewName("createClubAd");
//			
//			return mv;
//		}
		@RequestMapping(value = "/clubAdvertise/write/create", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView createClubAd(ModelAndView mv, MultipartHttpServletRequest request, MultipartFile file) {

			ClubAdvertiseDTO info = new ClubAdvertiseDTO();
			FileDTO infoFile = new FileDTO();
			FileDTO infoImageFile = new FileDTO();

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			MultipartFile imagefile = request.getFile("originalUrl");
			String originalUrl = imagefile.getOriginalFilename();
			
			MultipartFile newfile = request.getFile("fileOriginalUrl");
			String fileOriginalUrl = newfile.getOriginalFilename();

			info.setTitle(title);
			info.setContent(content);
			//info.setFile(file);
			
			clubAdvertiseService.createClubAd(info);
			
			int recentId = clubAdvertiseService.readRecentClubAd();
			
			System.out.println(recentId);
		
			infoImageFile.setClubAdvertiseId(recentId);
			infoImageFile.setOriginalUrl(originalUrl);
			
			infoFile.setClubAdvertiseId(recentId);
			infoFile.setFileOriginalUrl(fileOriginalUrl);
			
			clubAdvertiseService.createClubAdFile(infoFile);
			clubAdvertiseService.createClubAdImage(infoImageFile);

			System.out.println(info.toString());
			System.out.println(infoFile.toString());


			String saveDir = request.getSession().getServletContext().getRealPath("/resources/img");
			String savefileDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");

			File imgDir = new File(saveDir);
			File dir = new File(savefileDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			if (!imgDir.exists()) {
				imgDir.mkdirs();
			}

			if (!newfile.isEmpty()) {
				String ext = originalUrl.substring(originalUrl.lastIndexOf("."));

				// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
				// int rand = (int)(Math.random()*1000);

				// String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;

				try {
					imagefile.transferTo(new File(saveDir + "/" + originalUrl));
					newfile.transferTo(new File(savefileDir + "/" + fileOriginalUrl));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println(saveDir);
			System.out.println(savefileDir);


			mv.setViewName("redirect:/clubAdvertise?num=1");

			return mv;
		}
		
		@RequestMapping(value = "/clubAdvertise/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView deleteclubAdvertise(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mv = new ModelAndView();
			
			clubAdvertiseService.deleteClubAdvertiseFile(id);
			clubAdvertiseService.deleteClubAdvertiseImage(id);
			clubAdvertiseService.deleteClubAdvertise(id);
			
			
			ClubAdvertiseDTO clubAdvertiseDetail = clubAdvertiseService.readClubAdvertiseDetailId(id);
			//String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
			
			//String fileName = clubAdvertiseDetail.getOriginalUrl();
			//System.out.println("filename: " + fileName);
			
			mv.addObject("clubAdvertiseDetail", clubAdvertiseDetail);

			System.out.println(mv);

			mv.setViewName("redirect:/clubAdvertise?num=1");

			return mv;
		}
		
		@RequestMapping("/clubAdvertise/detail/{id}/filedownload")
		public void fileDownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mv = new ModelAndView();

			ClubAdvertiseDTO clubAdDetail = clubAdvertiseService.readClubAdvertiseDetailId(id);
			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
			
			String fileName = clubAdDetail.getFileOriginalUrl();
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
