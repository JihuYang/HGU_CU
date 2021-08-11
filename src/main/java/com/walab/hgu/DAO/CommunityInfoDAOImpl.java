package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;

@Repository
public class CommunityInfoDAOImpl implements CommunityInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "CommunityInfo";
	
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfo(int displayPost, int postNum) {
		
		Map<String, Object> infoList = new HashMap<String, Object>();
		infoList.put("displayPost", displayPost);
		infoList.put("postNum", postNum);
				
		return sqlSession.selectList(namespace+".readCommunityInfo", infoList);
	}
	
	@Override
	public CommunityInfoDTO readCommunityInfoDetail(int id) {
		
		Map<String, Object> infoDetailList = new HashMap<String, Object>();
		infoDetailList.put("id", id);
		System.out.println(infoDetailList);
				
		return sqlSession.selectOne(namespace+".readCommunityInfoDetail", infoDetailList);
	}	
	
	@Override
	public int readRecentCommunityInfo() {
		
		Map<String, Object> recentId = new HashMap<String, Object>();

		return sqlSession.selectOne(namespace+".readRecentCommunityInfo", recentId);

	}
	
	@Override
	public int createCommunityInfo(CommunityInfoDTO communityInfo) {
		
		sqlSession.insert(namespace+".creatCommunityInfo", communityInfo);
		
		return 0;
	}
	
	@Override
	public int createCommunityInfoFile(FileDTO communityInfoFile) {
		
		sqlSession.insert(namespace+".createCommunityInfoFile", communityInfoFile);

		return 0;
	}
	
	@Override
	public int updateCommunityInfo(CommunityInfoDTO communityInfo) {
		
		sqlSession.update(namespace+".updateCommunityInfo", communityInfo);

		return 0;
	}

	@Override
	public int updateViewCount(int id) {
		sqlSession.update(namespace+".updateViewCount", id);
		return 0;
	}

	@Override
	public int countInfo() {
		
		return sqlSession.selectOne(namespace+".countInfo");
	}


}