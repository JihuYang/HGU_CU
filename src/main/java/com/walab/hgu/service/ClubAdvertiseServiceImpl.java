package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ClubAdvertiseDAO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.FileDTO;

@Service
public class ClubAdvertiseServiceImpl implements ClubAdvertiseService{
	
	@Autowired
	ClubAdvertiseDAO clubAdvertiseDAO ;

	@Override
	public List<ClubAdvertiseDTO> readClubAdvertisePreview(int displayPost, int postNum) {
		

		List<ClubAdvertiseDTO> adList = clubAdvertiseDAO.readClubAdvertisePreview(displayPost, postNum);
		
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
	public int readRecentClubAd() {

		int recentId = clubAdvertiseDAO.readRecentClubAd();

		return recentId;

	}

	@Override
	public int createClubAd(ClubAdvertiseDTO info) {
		
		return clubAdvertiseDAO.createClubAd(info);
		
	}
	
	@Override
	public int createClubAdImage(FileDTO clubAdImage) {

		return clubAdvertiseDAO.createClubAdImage(clubAdImage);
		
	}
	
	@Override
	public int createClubAdFile(FileDTO clubAdFile) {

		return clubAdvertiseDAO.createClubAdFile(clubAdFile);
		
	}

	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return clubAdvertiseDAO.countInfo();
	}

}
