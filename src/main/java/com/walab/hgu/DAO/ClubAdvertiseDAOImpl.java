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
	public List<ClubAdvertiseDTO> readClubAdvertisePreview() {
		
		Map<String, Object> clubAdvertiseParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readClubAdvertisePreview", clubAdvertiseParam);
	}


	@Override
	public List<ClubAdvertiseDTO> readClubAdvertiseDetail(int id) {
		
		Map<String, Object> clubAdvertiseDetail = new HashMap<String, Object>();
		clubAdvertiseDetail.put("id", id);
		
		return sqlSession.selectList(namespace+".readClubAdvertiseDetail", clubAdvertiseDetail);
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
	public int createClubAdFile(FileDTO clubAdFile) {
		
		sqlSession.insert(namespace+".createClubAdFile", clubAdFile);

		return 0;
	}
}
