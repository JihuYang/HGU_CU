package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.DTO.FileDTO;

public interface CommunityMaterialService {

	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum);

	public CommunityMaterialDTO readCommunityMaterialDetail(int id);

	public int readRecentCommunityMaterial();

	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial);

	public int createCommunityMaterialFile(FileDTO communityMaterialFile);

	public int updateCommunityMaterial(CommunityMaterialDTO communityMaterial);

	public int updateCommunityMaterialFile(FileDTO communityMaterialFile);

	public int updateViewCount(int id);

	public int deleteCommunityMaterialFile(int id);

	public int deleteCommunityMaterial(int id);

	public int countInfo();

}
