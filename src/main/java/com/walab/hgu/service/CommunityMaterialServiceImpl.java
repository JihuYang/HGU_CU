package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityMaterialDAO;
import com.walab.hgu.DTO.CommunityMaterialDTO;

@Service
public class CommunityMaterialServiceImpl implements CommunityMaterialService{
	
	@Autowired
	CommunityMaterialDAO communityMaterialDAO;
	
	@Override
	public List<CommunityMaterialDTO> readCommunityMaterial(){
		
		List<CommunityMaterialDTO> infoList = communityMaterialDAO.readCommunityMaterial();

		return infoList;
		
	}

}
