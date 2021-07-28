package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ClubDAO;
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
	public List<ClubDTO> getCategoryNameList() {
		

		List<ClubDTO> categoryNameList = clubDAO.getCategoryNameList();
		
		return categoryNameList;
	}

	@Override
	public List<ClubDTO> getClubDetailList(int categoryId, int clubId) {
		List<ClubDTO> clubDetailList = clubDAO.getClubDetailList(categoryId, clubId);
		return clubDetailList;
	}
	
	

}
