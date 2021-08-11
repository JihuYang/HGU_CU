package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.CommunityMaterialDTO;

@Repository
public class CommunityMaterialDAOImpl implements CommunityMaterialDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "CommunityMaterial";
	
	
	@Override
	public List<CommunityMaterialDTO> readCommunityMaterial(int displayPost, int postNum) {
		
		Map<String, Object> communityMaterialParam = new HashMap<String, Object>();
		communityMaterialParam.put("displayPost", displayPost);
		communityMaterialParam.put("postNum", postNum);
				
		return sqlSession.selectList(namespace+".readCommunityMaterial", communityMaterialParam);
	}


	@Override
	public List<CommunityMaterialDTO> readCommunityMaterialDetail(int id) {
		
		Map<String, Object> materialDetailList = new HashMap<String, Object>();
		materialDetailList.put("id", id);
		
		return sqlSession.selectList(namespace+".readCommunityMaterialDetail", materialDetailList);
	}
	
	@Override
	public int createCommunityMaterial(CommunityMaterialDTO communityMaterial) {
		
		sqlSession.insert(namespace+".creatCommunityMaterial", communityMaterial);
		
		return 0;
	}


	@Override
	public int updateViewCount(int id) {
		sqlSession.update(namespace+".updateViewCount", id);
		return 0;
	}


	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countInfo");
	}	
	
}