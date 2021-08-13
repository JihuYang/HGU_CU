package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.SettingDTO;

public interface SettingService {
	
	public List<SettingDTO> readSetting(int displayPost, int postNum);

	public int countInfo();

}
