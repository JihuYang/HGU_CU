package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.ReservationInfoDTO;

public interface ReservationInfoService {
	
	public List<ReservationInfoDTO> readReservationInfo();
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo);

}
