package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

public interface CommunityInfoDAO {
		
	public List<CommunityInfoDTO> readCommunityInfo(int displayPost, int postNum);
	public CommunityInfoDTO readCommunityInfoDetail(int id);
	public int readRecentCommunityInfo();
	public int createCommunityInfo(CommunityInfoDTO communityInfo);
	public int creatCommunityInfoFile(FileDTO communityInfoFile);
	public int updateViewCount(int id);
	public int countInfo();

}
