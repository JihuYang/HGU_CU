package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.DTO.FileDTO;

public interface CommunityMaterialService {

	public int readRecentCommunityMaterial();

	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum, String searchType,
			String keyword);

	public CommunityMaterialDTO readCommunityMaterialDetail(int id);

	public List<FileDTO> readCommunityMaterialFileDetail(int communityMaterialId);

	public FileDTO readCommunityMaterialFileOneDetail(int id);

	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial);

	public int createCommunityMaterialFile(FileDTO communityMaterialFile);

	public int updateCommunityMaterial(CommunityMaterialDTO communityMaterial);

	public int updateCommunityMaterialFile(FileDTO communityMaterialFile);

	public int updateViewCount(int id);

	public int deleteCommunityMaterialFile(int id);

	public int deleteCommunityMaterial(int id);

	public int countInfo(String searchType, String keyword);

}
