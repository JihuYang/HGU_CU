package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.SettingDTO;

@Repository
public class SettingDAOImpl implements SettingDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Setting";
	
	
	@Override
	public List<SettingDTO> readSetting() {
		
		Map<String, Object> settingParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readSetting", settingParam);
	}
	
	
}