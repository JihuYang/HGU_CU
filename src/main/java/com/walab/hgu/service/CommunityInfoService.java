package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

public interface CommunityInfoService {
	
	public List<CommunityInfoDTO> readCommunityInfo();
	public CommunityInfoDTO readCommunityInfoDetail(int id);
	public int readRecentCommunityInfo();
	public int createCommunityInfo(CommunityInfoDTO communityInfo);
	public int creatCommunityInfoFile(FileDTO communityInfoFile);

}
