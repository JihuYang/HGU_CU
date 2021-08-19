package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

public interface CommunityInfoDAO {
		
	public List<CommunityInfoDTO> readCommunityInfo(int displayPost, int postNum, String searchType,String keyword);
	public CommunityInfoDTO readCommunityInfoDetail(int id);
	public List<FileDTO> readCommunityInfoFileDetail(int communityInfoId);
	public FileDTO readCommunityInfoFileOneDetail(int id);
	public int readRecentCommunityInfo();
	public int createCommunityInfo(CommunityInfoDTO communityInfo);
	public int createCommunityInfoFile(FileDTO communityInfoFile);
	public int updateCommunityInfo(CommunityInfoDTO communityInfo);
	public int updateCommunityInfoFile(FileDTO communityInfoFile);
	public int deleteCommunityInfoFile(int id);
	public int deleteCommunityInfo(int id);
	public int updateViewCount(int id);
	public int countInfo(String searchType,String keyword);

}
