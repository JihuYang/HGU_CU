package com.walab.hgu.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.ClubDTO;

@Repository
public class ClubDAOImpl implements ClubDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Club";
	
	@Override//동아리 홍보페이지 리스트 창 
	public List<ClubDTO> readClubIntroductionPreview(int categoryId) {
		
		Map<String, Object> clubPreviewParam = new HashMap<String, Object>();
		clubPreviewParam.put("categoryId", categoryId);
		
		return sqlSession.selectList(namespace+".readClubIntroductionPreview", clubPreviewParam);
	}

	@Override
	public List<ClubDTO> getCategoryNameList() {
		
		Map<String, Object> categoryNameList = new HashMap<String, Object>();
		
		return sqlSession.selectList(namespace+".getCategoryNameList", categoryNameList);
	}
}
