package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;

public interface ClubService {
	public List<ClubDTO> readClubIntroductionPreview(int categoryId);

	public List<CategoryDTO> getCategoryNameList();

	public List<ClubDTO> getClubDetailList(int categoryId, int clubId);
	
	public List<ClubDTO> getClubImg(int clubId);
}
