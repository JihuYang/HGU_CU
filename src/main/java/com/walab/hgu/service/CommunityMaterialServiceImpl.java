package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityMaterialDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.CommunityMaterialDTO;
import com.walab.hgu.DTO.FileDTO;

@Service
public class CommunityMaterialServiceImpl implements CommunityMaterialService {

	@Autowired
	CommunityMaterialDAO communityMaterialDAO;

	@Override
	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum, String searchType,
			String keyword) {

		List<CommunityMaterialDTO> infoList = communityMaterialDAO.readCommunityMaterial(displayPost, postNum,
				searchType, keyword);

		return infoList;

	}

	@Override
	public CommunityMaterialDTO readCommunityMaterialDetail(int id) {

		CommunityMaterialDTO materialDetail = communityMaterialDAO.readCommunityMaterialDetail(id);

		return materialDetail;
	}

	@Override
	public List<FileDTO> readCommunityMaterialFileDetail(int communityMaterialId) {

		List<FileDTO> materialFileDetailList = communityMaterialDAO.readCommunityMaterialFileDetail(communityMaterialId);

		return materialFileDetailList;

	}

	@Override
	public FileDTO readCommunityMaterialFileOneDetail(int id) {

		FileDTO materialFileOneDetailList = communityMaterialDAO.readCommunityMaterialFileOneDetail(id);

		return materialFileOneDetailList;

	}

	@Override
	public int readRecentCommunityMaterial() {

		int recentId = communityMaterialDAO.readRecentCommunityMaterial();

		return recentId;

	}

	@Override
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial) {

		return communityMaterialDAO.createCommunityMaterial(communityMaterial);

	}

	@Override
	public int createCommunityMaterialFile(FileDTO communityMaterialFile) {

		return communityMaterialDAO.createCommunityMaterialFile(communityMaterialFile);

	}

	@Override
	public int updateCommunityMaterial(CommunityMaterialDTO communityMaterial) {

		return communityMaterialDAO.updateCommunityMaterial(communityMaterial);
	}

	@Override
	public int updateCommunityMaterialFile(FileDTO communityMaterialFile) {

		return communityMaterialDAO.updateCommunityMaterialFile(communityMaterialFile);
	}

	@Override
	public int deleteCommunityMaterialFile(int id) {

		return communityMaterialDAO.deleteCommunityMaterialFile(id);
	}

	@Override
	public int deleteCommunityMaterial(int id) {

		return communityMaterialDAO.deleteCommunityMaterial(id);
	}

	@Override
	public int updateViewCount(int id) {
		// TODO Auto-generated method stub
		return communityMaterialDAO.updateViewCount(id);
	}

	@Override
	public int countInfo(String searchType, String keyword) {
		// TODO Auto-generated method stub
		return communityMaterialDAO.countInfo(searchType, keyword);
	}

}
