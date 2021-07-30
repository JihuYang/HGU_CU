package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityInfoDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;

@Service
public class CommunityInfoServiceImpl implements CommunityInfoService {

	@Autowired
	CommunityInfoDAO communityInfoDAO;

	@Override
	public List<CommunityInfoDTO> readCommunityInfo() {

		List<CommunityInfoDTO> infoList = communityInfoDAO.readCommunityInfo();

		return infoList;

	}

	@Override
	public List<CommunityInfoDTO> readCommunityInfoDetail(int id) {

		List<CommunityInfoDTO> infoDetailList = communityInfoDAO.readCommunityInfoDetail(id);

		return infoDetailList;

	}

	@Override
	public int createCommunityInfo(CommunityInfoDTO communityInfo) {

		return communityInfoDAO.createCommunityInfo(communityInfo);
		
	}

}