package com.walab.hgu.DAO;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.SettingDTO;

public interface SettingDAO {
		
	public List<SettingDTO> readSetting(int displayPost, int postNum);

	public int countInfo();

	public int updateSetting(Map<String, Object> settingList);

	public List<SettingDTO> readSetting();
}
