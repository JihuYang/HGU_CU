package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityMaterialDTO;

public interface CommunityMaterialService {
	
	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum);
	public List<CommunityMaterialDTO> readCommunityMaterialDetail(int id);
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial);
	public int updateViewCount(int id);
	public int countInfo();

}
