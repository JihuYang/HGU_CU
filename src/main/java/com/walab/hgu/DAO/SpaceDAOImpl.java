package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.SpaceDTO;

@Repository
public class SpaceDAOImpl implements SpaceDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Space";
	
	
	@Override
	public List<SpaceDTO> readSpace() {
		
		Map<String, Object> spaceParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readSpace", spaceParam);
	}
	
	
}