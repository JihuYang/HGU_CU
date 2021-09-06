package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CategoryDTO;
import com.walab.hgu.DTO.ClubDTO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

@Repository
public class ClubDAOImpl implements ClubDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Club";
	
	@Override//동아리 홍보페이지 리스트 창 
	public List<ClubDTO> readClubIntroductionPreview(int categoryId, String keyword) {
		
		Map<String, Object> clubPreviewParam = new HashMap<String, Object>();
		clubPreviewParam.put("categoryId", categoryId);
		clubPreviewParam.put("keyword", keyword);
		
		return sqlSession.selectList(namespace+".readClubIntroductionPreview", clubPreviewParam);
	}
	
	@Override
	public List<ClubDTO> readClubList(int displayPost, int postNum){
		Map<String, Object> infoList = new HashMap<String, Object>();
		infoList.put("displayPost", displayPost);
		infoList.put("postNum", postNum);
		
		return sqlSession.selectList(namespace+".readClubList", infoList);
	}

	@Override
	public List<CategoryDTO> getCategoryNameList() {
		
		Map<String, Object> categoryNameList = new HashMap<String, Object>();
		
		return sqlSession.selectList(namespace+".getCategoryNameList", categoryNameList);
	}

	@Override
	public List<ClubDTO> getClubDetailList(int categoryId,int clubId) {
		
		Map<String, Object> clubDetailList = new HashMap<String, Object>();
		clubDetailList.put("categoryId", categoryId);
		clubDetailList.put("clubId", clubId);
		
		return sqlSession.selectList(namespace+".getClubDetailList", clubDetailList);
	}

	@Override
	public List<ClubDTO> getClubImg(int clubId) {
		Map<String, Object> clubImg = new HashMap<String, Object>();
		clubImg.put("clubId", clubId);
		//System.out.println(clubImg);
		return sqlSession.selectList(namespace+".getClubImg", clubImg);
	}

	@Override
	public int createClubIntro(ClubDTO intro) {
		
		sqlSession.insert(namespace+".createClubIntro", intro);
		
		return 0;
	}

	@Override
	public List<ClubDTO> getClubList() {
		Map<String, Object> clubList = new HashMap<String, Object>();
		return sqlSession.selectList(namespace+".getClubList", clubList);
	}

	@Override
	public int createClubSNS(ClubDTO sns) {
		sqlSession.insert(namespace+".createClubSNS", sns);
		return 0;
	}

	@Override
	public List<ClubDTO> getAllClubIntroduction(String keyword) {
		Map<String, Object> clubPreviewParam = new HashMap<String, Object>();
		clubPreviewParam.put("keyword", keyword);
		
		return sqlSession.selectList(namespace+".getAllClubIntroduction", clubPreviewParam);
	}
	
	@Override
	public int readRecentClub() {
		Map<String, Object> recentId = new HashMap<String, Object>();
		
		return sqlSession.selectOne(namespace+".readRecentClub", recentId);
	}
	
	@Override
	public int createClubIntroImage(FileDTO clubIntroImage) {
		sqlSession.insert(namespace+".createClubIntroImage", clubIntroImage);
		return 0;
	}

	@Override
	public int updateUserClub(Map<String, Object> userClub) {
		
		return sqlSession.update(namespace+".updateUserClub", userClub);
	}
	
	@Override
	public int updateUserNull(Map<String, Object> userClub) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".updateUserNull", userClub);
	}

	@Override
	public int getClubIdByName(String clubName) {
		Map<String, Object> clubParam = new HashMap<String, Object>();
		clubParam.put("clubName", clubName);
		return sqlSession.selectOne(namespace+".getClubIdByName", clubParam);
	}

	@Override
	public int getClubIdByUserId(int id) {
		Map<String, Object> clubParam = new HashMap<String, Object>();
		clubParam.put("userId", id);
		System.out.println(clubParam);
		return sqlSession.selectOne(namespace+".getClubIdByUserId", clubParam);
	}
	
	@Override
	public int updateClubIntro(ClubDTO clubIntro) {
		
		sqlSession.update(namespace+".updateClubIntro", clubIntro);

		return 0;
	}
	
	@Override
	public int updateClubSNS(ClubDTO clubSNS) {
		
		sqlSession.update(namespace+".updateClubSNS", clubSNS);

		return 0;
	}
	
	@Override
	public int updateClubImage(FileDTO clubImage) {
		
		sqlSession.update(namespace+".updateClubImage", clubImage);

		return 0;
	}
	
	@Override
	public int deleteClubIntroImage(int id) {
		
		sqlSession.delete(namespace+".deleteClubIntroImage", id);
		
		return 0;
	}
	
	@Override
	public int deleteClubIntroduction(int id) {
		
		sqlSession.delete(namespace+".deleteClubIntroduction", id);
		
		return 0;
	}
	
	@Override
	public int deleteClubSNS(int id) {
		
		sqlSession.delete(namespace+".deleteClubSNS", id);
		
		return 0;
	}
}
