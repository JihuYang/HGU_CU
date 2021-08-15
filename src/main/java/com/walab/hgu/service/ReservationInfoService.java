package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.ReservationInfoDTO;

public interface ReservationInfoService {
	
	public List<ReservationInfoDTO> readReservationInfoPaging(int displayPost, int postNum,String keyword);
	public List<ReservationInfoDTO> readReservationInfo();
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo);
	public int createReservation(ReservationInfoDTO reservationInfo);
	public int countInfo(String keyword);

}
