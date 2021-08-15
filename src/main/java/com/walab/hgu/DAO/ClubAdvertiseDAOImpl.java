package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.ClubAdvertiseDTO;
import com.walab.hgu.DTO.FileDTO;

@Repository
public class ClubAdvertiseDAOImpl implements ClubAdvertiseDAO{

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "ClubAdvertise";
	
	
	@Override//동아리 홍보페이지 리스트 창 
	public List<ClubAdvertiseDTO> readClubAdvertisePreview(int displayPost, int postNum, String searchType, String keyword) {
		
		Map<String, Object> clubAdvertiseParam = new HashMap<String, Object>();
		clubAdvertiseParam.put("displayPost", displayPost);
		clubAdvertiseParam.put("postNum", postNum);
		clubAdvertiseParam.put("searchType", searchType);
		clubAdvertiseParam.put("keyword", keyword);
				
		return sqlSession.selectList(namespace+".readClubAdvertisePreview", clubAdvertiseParam);
	}


	@Override
	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id) {
		
		Map<String, Object> clubAdvertiseDetail = new HashMap<String, Object>();
		clubAdvertiseDetail.put("id", id);
		
		return sqlSession.selectList(namespace+".readClubAdvertiseDetail", clubAdvertiseDetail);
	}
	
	@Override
	public ClubAdvertiseDTO readClubAdvertiseDetailId(int id) {
		
		Map<String, Object> infoDetailList = new HashMap<String, Object>();
		infoDetailList.put("id", id);
		System.out.println(infoDetailList);
				
		return sqlSession.selectOne(namespace+".readClubAdvertiseDetailId", infoDetailList);
	}


	@Override
	public List<ClubAdvertiseDTO> getClubAdImg(int id) {
		
		Map<String, Object> clubAdImgList = new HashMap<String, Object>();
		clubAdImgList.put("id", id);
		
		return sqlSession.selectList(namespace+".getClubAdImg", clubAdImgList);
	}
	
	@Override
	public int readRecentClubAd() {
		
		Map<String, Object> recentId = new HashMap<String, Object>();

		return sqlSession.selectOne(namespace+".readRecentClubAd", recentId);

	}


	@Override
	public int createClubAd(ClubAdvertiseDTO info) {
		
		 sqlSession.insert(namespace+".createClubAd", info);
		
		return 0;
	}
	
	@Override
	public int createClubAdImage(FileDTO clubAdImage) {
		sqlSession.insert(namespace+".createClubAdImage", clubAdImage);
		return 0;
	}
	
	@Override
	public int createClubAdFile(FileDTO clubAdFile) {
		sqlSession.insert(namespace+".createClubAdFile", clubAdFile);
		return 0;
	}
	
	@Override
	public int deleteClubAdvertiseFile(int id) {
		
		sqlSession.delete(namespace+".deleteClubAdvertiseFile", id);
		
		return 0;
	}
	
	@Override
	public int deleteClubAdvertiseImage(int id) {
		
		sqlSession.delete(namespace+".deleteClubAdvertiseImage", id);
		
		return 0;
	}
	
	@Override
	public int deleteClubAdvertise(int id) {
		
		sqlSession.delete(namespace+".deleteClubAdvertise", id);
		
		return 0;
	}


	@Override
	public int countInfo(String searchType, String keyword) {
		
		Map<String, Object> count = new HashMap<String, Object>();
		count.put("searchType", searchType);
		count.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace+".countInfo",count);
	}
}
