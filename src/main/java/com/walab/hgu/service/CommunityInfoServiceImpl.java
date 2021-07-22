package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityInfoDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;

@Service
public class CommunityInfoServiceImpl implements CommunityInfoService{
	
	@Autowired
	CommunityInfoDAO communityInfoDAO;
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfo(){
		
		List<CommunityInfoDTO> infoList = communityInfoDAO.readCommunityInfo();
		
		return infoList;
		
	}

}
