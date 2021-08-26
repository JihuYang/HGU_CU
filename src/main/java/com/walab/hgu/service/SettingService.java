package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.ReservationInfoDTO;
import com.walab.hgu.DTO.SettingDTO;

public interface SettingService {
	
	public List<SettingDTO> readSetting(int displayPost, int postNum);
	
	public List<SettingDTO> readSetting();

	public int countInfo();

	public int updateSetting(Map<String, Object> settingList);

	public List<ReservationInfoDTO> getOfficeHour();

}
