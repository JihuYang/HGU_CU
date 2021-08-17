package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.FileDTO;

public interface ClubService {
	public List<ClubDTO> readClubIntroductionPreview(int categoryId, String keyword);
	
	public List<ClubDTO> readClubList(int displayPost, int postNum);

	public List<CategoryDTO> getCategoryNameList();

	public List<ClubDTO> getClubDetailList(int categoryId, int clubId);
	
	public List<ClubDTO> getClubImg(int clubId);

	public List<ClubDTO> getAllClubIntroduction(String keyword);

	//club id & name을 데이터베이스 추가 최신 순으로 가져옴
	public List<ClubDTO> getClubList();

	public int createClubSNS(ClubDTO sns);
	
	public int createClubIntro(ClubDTO intro);
	
	public int createClubIntroImage(FileDTO clubIntroImage);
	
	public int readRecentClub();

	public int updateUserClub(Map<String, Object> userClub);
	
	public int updateUserNull(Map<String, Object> userClub);

	public int getClubIdByName(String clubName);

	public int getClubIdByUserId(int id);

}
