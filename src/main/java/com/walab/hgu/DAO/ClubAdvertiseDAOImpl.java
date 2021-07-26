package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.ClubAdvertiseDTO;

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
}
