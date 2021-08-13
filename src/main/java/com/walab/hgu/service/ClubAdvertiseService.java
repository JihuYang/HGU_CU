package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.FileDTO;

public interface ClubAdvertiseService{
	////동아리 홍보페이지 리스트 창 
	public List<ClubAdvertiseDTO> readClubAdvertisePreview(int displayPost, int postNum);

	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id);
	public ClubAdvertiseDTO readClubAdvertiseDetailId(int id);

	public List<ClubAdvertiseDTO> getClubAdImg(int id);
	
	public int readRecentClubAd();

	public int createClubAd(ClubAdvertiseDTO info);
	
	public int createClubAdImage(FileDTO clubAdImage);
	
	public int createClubAdFile(FileDTO clubAdFile);

	public int countInfo();
	
}
