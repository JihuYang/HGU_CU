package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;

public interface CommunityInfoDAO {
		
	public List<CommunityInfoDTO> readCommunityInfo();
	
}