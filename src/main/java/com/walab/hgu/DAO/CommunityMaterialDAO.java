package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.CommunityMaterialDTO;

public interface CommunityMaterialDAO {
		
	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum ,String searchType, String keyword);
	public List<CommunityMaterialDTO> readCommunityMaterialDetail(int id);
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial);
	public int updateViewCount(int id);
	public int countInfo(String searchType, String keyword);
	
}
