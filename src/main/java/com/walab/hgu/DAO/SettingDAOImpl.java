package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SettingDTO;

@Repository
public class SettingDAOImpl implements SettingDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Setting";
	
	
	@Override
	public List<SettingDTO> readSetting(int displayPost, int postNum) {
		
		Map<String, Object> settingParam = new HashMap<String, Object>();
		settingParam.put("displayPost", displayPost);
		settingParam.put("postNum", postNum);
				
		return sqlSession.selectList(namespace+".readSettingWithParam", settingParam);
	}


	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countInfo");
	}


	@Override
	public int updateSetting(Map<String, Object> settingList) {
		System.out.println(settingList);
		return sqlSession.update(namespace+".updateSetting", settingList);
	}


	@Override
	public List<SettingDTO> readSetting() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".readSetting");
	}


	@Override
	public List<ReservationInfoDTO> getOfficeHour() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getOfficeHour");
	}
	
}