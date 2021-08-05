package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.FileDTO;
import com.walab.hgu.DTO.PagingDTO;

@Repository
public class CommunityInfoDAOImpl implements CommunityInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "CommunityInfo";
	
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfo(PagingDTO pagination) {
		
		//Map<String, Object> infoList = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readCommunityInfo", pagination);
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
	public int creatCommunityInfoFile(FileDTO communityInfoFile) {
		
		sqlSession.insert(namespace+".creatCommunityInfoFile", communityInfoFile);

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