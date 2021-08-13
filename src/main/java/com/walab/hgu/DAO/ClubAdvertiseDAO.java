package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.FileDTO;

public interface ClubAdvertiseDAO {
	
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
