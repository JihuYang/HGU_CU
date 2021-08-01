package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;

public interface ClubService {
	public List<ClubDTO> readClubIntroductionPreview(int categoryId);
	
	public List<ClubDTO> readClubList();

	public List<CategoryDTO> getCategoryNameList();

	public List<ClubDTO> getClubDetailList(int categoryId, int clubId);
	
	public List<ClubDTO> getClubImg(int clubId);

	public int createClubIntro(ClubDTO intro);

	//club id & name을 데이터베이스 추가 최신 순으로 가져옴
	public List<ClubDTO> getClubList();

	public int createClubSNS(ClubDTO sns);
}
