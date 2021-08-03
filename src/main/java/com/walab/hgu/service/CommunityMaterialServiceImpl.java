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

	@Override
	public List<CommunityMaterialDTO> readCommunityMaterialDetail(int id) {
		

		List<CommunityMaterialDTO> infoDetailList = communityMaterialDAO.readCommunityMaterialDetail(id);
		
		return infoDetailList;
	}

	@Override
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial) {

		return communityMaterialDAO.createCommunityMaterial(communityMaterial);
		
	}

	@Override
	public int updateViewCount(int id) {
		// TODO Auto-generated method stub
		return communityMaterialDAO.updateViewCount(id);
	}
}
