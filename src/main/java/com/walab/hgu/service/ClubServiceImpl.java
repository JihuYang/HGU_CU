package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ClubDAO;
import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;

@Service
public class ClubServiceImpl implements ClubService{

	@Autowired
	ClubDAO clubDAO ;
	
	@Override
	public List<ClubDTO> readClubIntroductionPreview(int categoryId, String keyword) {
		
		List<ClubDTO> clubIntroList = clubDAO.readClubIntroductionPreview(categoryId,keyword);
		
		return clubIntroList;
	}

	@Override
	public List<CategoryDTO> getCategoryNameList() {
		

		List<CategoryDTO> categoryNameList = clubDAO.getCategoryNameList();
		
		return categoryNameList;
	}

	@Override
	public List<ClubDTO> getClubDetailList(int categoryId, int clubId) {
		List<ClubDTO> clubDetailList = clubDAO.getClubDetailList(categoryId, clubId);
		return clubDetailList;
	}

	@Override
	public List<ClubDTO> getClubImg(int clubId) {
		List<ClubDTO> clubImg = clubDAO.getClubImg(clubId);
		
		return clubImg;
	}
	
	@Override
	public List<ClubDTO> readClubList(int displayPost, int postNum){
		List<ClubDTO> clubList = clubDAO.readClubList(displayPost,postNum);
		return clubList;
	}

	@Override
	public int createClubIntro(ClubDTO intro) {
		
		return clubDAO.createClubIntro(intro);
		
	}
	
	//club id & name을 데이터베이스 추가 최신 순으로 가져옴
	@Override
	public List<ClubDTO> getClubList() {
		
		List<ClubDTO> clubIntroList = clubDAO.getClubList();

		return clubIntroList;
	}

	@Override
	public int createClubSNS(ClubDTO sns) {
		
		return clubDAO.createClubSNS(sns);
	}

	@Override
	public List<ClubDTO> getAllClubIntroduction(String keyword) {
		List<ClubDTO> clubIntroList = clubDAO.getAllClubIntroduction(keyword);
		return clubIntroList;
	}

	@Override
	public int updateUserClub(Map<String, Object> userClub) {
		
		return clubDAO.updateUserClub(userClub);
		
	}
	
	@Override
	public int updateUserNull(Map<String, Object> userClub) {
		// TODO Auto-generated method stub
		return clubDAO.updateUserNull(userClub);
	}

	@Override
	public int getClubIdByName(String clubName) {
		
		return clubDAO.getClubIdByName(clubName);
	}

	@Override
	public int getClubIdByUserId(int id) {
		// TODO Auto-generated method stub
		return clubDAO.getClubIdByUserId(id);
	}
	
	

}
