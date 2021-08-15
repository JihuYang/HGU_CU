package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.ReservationInfoDTO;

public interface ReservationInfoDAO {
		
	public List<ReservationInfoDTO> readReservationInfoPaging(int displayPost, int postNum,String keyword);
	public List<ReservationInfoDTO> readReservationInfo();
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo);
	public int createReservation(ReservationInfoDTO reservationInfo);
	public int countInfo(String keyword);
	
}
