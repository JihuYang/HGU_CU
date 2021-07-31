package com.walab.hgu.service;

import java.util.List;

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
	public List<ClubDTO> readClubIntroductionPreview(int categoryId) {
		
		List<ClubDTO> clubIntroList = clubDAO.readClubIntroductionPreview(categoryId);
		
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
	public List<ClubDTO> readClubList(){
		List<ClubDTO> clubList = clubDAO.readClubList();
		return clubList;
	}
	
	

}
