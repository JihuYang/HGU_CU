package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;

@Repository
public class CommunityInfoDAOImpl implements CommunityInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "CommunityInfo";
	
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfo() {
		
		Map<String, Object> infoList = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readCommunityInfo", infoList);
	}
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfoDetail(int id) {
		
		Map<String, Object> infoDetailList = new HashMap<String, Object>();
		infoDetailList.put("id", id);
		System.out.println(infoDetailList);
				
		return sqlSession.selectList(namespace+".readCommunityInfoDetail", infoDetailList);
	}	
	
	@Override
	public int createCommunityInfo(CommunityInfoDTO communityInfo) {
		
		sqlSession.insert(namespace+".creatCommunityInfo", communityInfo);
		
		return 0;
	}
}