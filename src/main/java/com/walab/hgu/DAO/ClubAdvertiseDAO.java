package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.FileDTO;

public interface ClubAdvertiseDAO {

	public List<ClubAdvertiseDTO> readClubAdvertisePreview(int displayPost, int postNum, String searchType,
			String keyword);

	public FileDTO readClubAdvertisePreviewImage(int id);

	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id);

	public List<FileDTO> readClubAdvertiseDetailFile(int id);

	public List<ClubAdvertiseDTO> getClubAdImg(int id);

	public int readRecentClubAd();

	public int createClubAd(ClubAdvertiseDTO info);

	public int createClubAdImage(FileDTO clubAdImage);

	public int createClubAdFile(FileDTO clubAdFile);

	public int countInfo(String searchType, String keyword);

	public int deleteClubAdvertiseFile(int id);

	public int deleteClubAdvertiseImage(int id);

	public int deleteClubAdvertise(int id);
}
