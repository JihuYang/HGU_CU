package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.PagingDTO;

public interface CommunityInfoService {
	
	public List<CommunityInfoDTO> readCommunityInfo(PagingDTO pagination);
	public CommunityInfoDTO readCommunityInfoDetail(int id);
	public int readRecentCommunityInfo();
	public int createCommunityInfo(CommunityInfoDTO communityInfo);
	public int creatCommunityInfoFile(FileDTO communityInfoFile);
	public int updateViewCount(int id);
	public int countInfo();

}
