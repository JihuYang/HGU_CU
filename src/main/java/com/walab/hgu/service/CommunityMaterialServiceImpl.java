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
	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum){
		
		List<CommunityMaterialDTO> infoList = communityMaterialDAO.readCommunityMaterial(displayPost, postNum);

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

	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return communityMaterialDAO.countInfo();
	}
}
