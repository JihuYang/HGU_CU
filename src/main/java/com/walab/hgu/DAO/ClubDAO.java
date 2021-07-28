package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.ClubDTO;

public interface ClubDAO {
	
	public List<ClubDTO> readClubIntroductionPreview(int categoryId);

	public List<ClubDTO> getCategoryNameList();

	public List<ClubDTO> getClubDetailList(int categoryId, int clubId);

}
