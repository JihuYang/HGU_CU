package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.CommunityMaterialDTO;

public interface CommunityMaterialDAO {
		
	public List<CommunityMaterialDTO> readCommunityMaterial();
	public List<CommunityMaterialDTO> readCommunityMaterialDetail(int id);
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial);
	
}
