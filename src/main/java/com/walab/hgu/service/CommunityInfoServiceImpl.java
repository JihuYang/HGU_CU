package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityInfoDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

@Service
public class CommunityInfoServiceImpl implements CommunityInfoService {

	@Autowired
	CommunityInfoDAO communityInfoDAO;

	@Override
	public List<CommunityInfoDTO> readCommunityInfo(int displayPost, int postNum) {

		List<CommunityInfoDTO> infoList = communityInfoDAO.readCommunityInfo(displayPost,postNum);

		return infoList;

	}

	@Override
	public CommunityInfoDTO readCommunityInfoDetail(int id) {

		CommunityInfoDTO infoDetailList = communityInfoDAO.readCommunityInfoDetail(id);

		return infoDetailList;

	}
	
	@Override
	public int readRecentCommunityInfo() {

		int recentId = communityInfoDAO.readRecentCommunityInfo();

		return recentId;

	}

	@Override
	public int createCommunityInfo(CommunityInfoDTO communityInfo) {

		return communityInfoDAO.createCommunityInfo(communityInfo);
		
	}
	
	@Override
	public int creatCommunityInfoFile(FileDTO communityInfoFile) {

		return communityInfoDAO.creatCommunityInfoFile(communityInfoFile);
		
	}

	@Override
	public int updateViewCount(int id) {
		
		return communityInfoDAO.updateViewCount(id);
	}

	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return communityInfoDAO.countInfo();
	}

}