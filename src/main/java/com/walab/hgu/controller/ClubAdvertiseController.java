package com.walab.hgu.controller;

import java.io.File;
import java.io.IOException;
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

import com.walab.hgu.DTO.ClubAdvertiseDTO;
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

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			MultipartFile newfile = request.getFile("originalUrl");
			String originalUrl = newfile.getOriginalFilename();

			info.setTitle(title);
			info.setContent(content);
			info.setFile(file);
			
			clubAdvertiseService.createClubAd(info);
			
			int recentId = clubAdvertiseService.readRecentClubAd();
			
			System.out.println(recentId);
		
			infoFile.setClubAdvertiseId(recentId);
			infoFile.setOriginalUrl(originalUrl);
			
			clubAdvertiseService.createClubAdFile(infoFile);

			System.out.println(info.toString());
			System.out.println(infoFile.toString());


			String saveDir = request.getSession().getServletContext().getRealPath("/resources/img");

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


			mv.setViewName("redirect:/clubAdvertise?num=1");

			return mv;
		}

}
