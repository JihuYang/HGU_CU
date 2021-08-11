package com.walab.hgu.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.CommunityMaterialDTO;
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
	public ModelAndView readCommunityMaterial(ModelAndView mv, @RequestParam("num") int num) {
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(communityMaterialService.countInfo());

		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService.readCommunityMaterial(page.getDisplayPost(),page.getPostNum());
		
		mv.addObject("communityMaterialList", communityMaterialList);
		mv.addObject("page", page);
		mv.addObject("selected", num);
		
		mv.setViewName("communityMaterials");
	
		return mv;
	}
	
	@RequestMapping(value = "/communityMaterials/detail/{id}", method = RequestMethod.GET)
	public ModelAndView readCommunityMaterialDetail(@PathVariable int id, HttpSession session, HttpServletRequest request ) {
		ModelAndView mv = new ModelAndView();
		
		communityMaterialService.updateViewCount(id);
		
		List<CommunityMaterialDTO> communityMaterialDetail = communityMaterialService.readCommunityMaterialDetail(id);
		
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
	public ModelAndView createCommunityMaterial(ModelAndView mv,
			@RequestParam(value="userId") int userId,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="originalUrl") String originalUrl) {
		
		CommunityMaterialDTO material = new CommunityMaterialDTO();
		
		material.setUserId(userId);
		material.setTitle(title);
		material.setContent(content);
		material.setOriginalUrl(originalUrl);

//		System.out.println(material.toString());
//		
//		System.out.println(originalUrl);

		communityMaterialService.createCommunityMaterial(material);
		

		mv.setViewName("communityMaterials");
			
		return mv;
	}
}
