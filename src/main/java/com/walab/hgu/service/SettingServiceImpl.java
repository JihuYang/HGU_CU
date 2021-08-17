package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.SettingDAO;
import com.walab.hgu.DTO.SettingDTO;

@Service
public class SettingServiceImpl implements SettingService{
	
	@Autowired
	SettingDAO settingDAO;
	
	@Override
	public List<SettingDTO> readSetting(int displayPost, int postNum){
	
		List<SettingDTO> infoList = settingDAO.readSetting(displayPost,postNum);
		
		return infoList;
		
	}

	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return settingDAO.countInfo() ;
	}

	@Override
	public int updateSetting(Map<String, Object> settingList) {
		// TODO Auto-generated method stub
		return settingDAO.updateSetting(settingList);
	}

}
