package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;

public interface CommunityInfoService {
	
	public List<CommunityInfoDTO> readCommunityInfo();
	public List<CommunityInfoDTO> readCommunityInfoDetail(int id);
	public int createCommunityInfo(CommunityInfoDTO communityInfo);
}
