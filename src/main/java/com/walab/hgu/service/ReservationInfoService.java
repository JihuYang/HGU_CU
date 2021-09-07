package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.ReservationInfoDTO;

public interface ReservationInfoService {
	
	public List<ReservationInfoDTO> readReservationInfoPaging(int displayPost, int postNum,String keyword);
	public List<ReservationInfoDTO> readReservationInfo();
	public List<ReservationInfoDTO> readReservationInfoById(int userId);
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo);
	public int createReservation(ReservationInfoDTO reservationInfo);
	public int countInfo(String keyword);
	public List<ReservationInfoDTO> readReservationBySpaceName(String spaceName);
	public List<ReservationInfoDTO> readReservationBySpaceNameById(String spaceName, int userId);
	public List<ReservationInfoDTO> readSumReservation(int userId);
	public int updateAdminReservationInfo(ReservationInfoDTO reservationInfo);
	public int deleteAdminReservation(int id);
	
	//officeHour 업데이트
	public void updateStartHour(Map<String, Object> officeHourStart);
	public void updateEndHour(Map<String, Object> officeHourEnd);

}
