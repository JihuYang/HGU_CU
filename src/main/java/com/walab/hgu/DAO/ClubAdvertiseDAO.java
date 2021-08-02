package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.ClubAdvertiseDTO;

public interface ClubAdvertiseDAO {
	
	public List<ClubAdvertiseDTO> readClubAdvertisePreview();

	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id);

	public List<ClubAdvertiseDTO> getClubAdImg(int id);

	public int createClubAd(ClubAdvertiseDTO info);
}
