package com.walab.hgu.DAO;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.FileDTO;

public interface ClubDAO {
	
	public List<ClubDTO> readClubIntroductionPreview(int categoryId, String keyword);
	
	public List<ClubDTO> readClubList(int displayPost, int postNum);

	public List<CategoryDTO> getCategoryNameList();

	public List<ClubDTO> getClubDetailList(int categoryId, int clubId);
	
	public List<ClubDTO> getClubImg(int clubId);

	public int createClubIntro(ClubDTO intro);

	public List<ClubDTO> getClubList();

	public int createClubSNS(ClubDTO sns);

	public List<ClubDTO> getAllClubIntroduction(String keyword);
	
	public int readRecentClub();
	
	public int createClubIntroImage(FileDTO clubAdImage);

	public int updateUserClub(Map<String, Object> userClub);
	
	public int updateUserNull(Map<String, Object> userClub);

	public int getClubIdByName(String clubName);

	public int getClubIdByUserId(int id);

	

}
