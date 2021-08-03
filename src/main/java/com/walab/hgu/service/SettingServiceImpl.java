package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.SettingDAO;
import com.walab.hgu.DTO.SettingDTO;

@Service
public class SettingServiceImpl implements SettingService{
	
	@Autowired
	SettingDAO settingDAO;
	
	@Override
	public List<SettingDTO> readSetting(){
	
		List<SettingDTO> infoList = settingDAO.readSetting();
		
		return infoList;
		
	}

}
