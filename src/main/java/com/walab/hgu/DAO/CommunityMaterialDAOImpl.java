package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityMaterialDTO;

@Repository
public class CommunityMaterialDAOImpl implements CommunityMaterialDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "CommunityMaterial";
	
	
	@Override
	public List<CommunityMaterialDTO> readCommunityMaterial() {
		
		Map<String, Object> communityMaterialParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readCommunityMaterial", communityMaterialParam);
	}
	
	
}