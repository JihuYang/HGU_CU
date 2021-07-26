package com.walab.hgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.service.CommunityMaterialService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommunityMaterialsController {
	
	@Autowired
	CommunityMaterialService communityMaterialService;

	@RequestMapping(value = "/communityMaterials", method = RequestMethod.GET)
	public ModelAndView readCommunityInfo(ModelAndView mv) {

		List<CommunityMaterialDTO> communityMaterialList = communityMaterialService.readCommunityMaterial();
		
		mv.addObject("communityMaterialList", communityMaterialList);
		
		mv.setViewName("communityMaterials");
	
		return mv;
	}
	
}
