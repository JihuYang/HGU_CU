package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ClubAdvertiseDAO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;

@Service
public class ClubAdvertiseServiceImpl implements ClubAdvertiseService{
	
	@Autowired
	ClubAdvertiseDAO clubAdvertiseDAO ;

	@Override
	public List<ClubAdvertiseDTO> readClubAdvertisePreview() {
		

		List<ClubAdvertiseDTO> adList = clubAdvertiseDAO.readClubAdvertisePreview();
		
		return adList;
	}

	@Override
	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id) {
		List<ClubAdvertiseDTO> infoDetailList = clubAdvertiseDAO.readClubAdvertiseDetail(id);
		return infoDetailList;
	}

	@Override
	public List<ClubAdvertiseDTO> getClubAdImg(int id) {
		List<ClubAdvertiseDTO> clubAdImgList = clubAdvertiseDAO.getClubAdImg(id);
		return clubAdImgList;
	}

	@Override
	public int createClubAd(ClubAdvertiseDTO info) {
		
		return clubAdvertiseDAO.createClubAd(info);
		
	}

}
