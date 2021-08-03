package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ReservationInfoDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService{
	
	@Autowired
	ReservationInfoDAO reservationInfoDAO;
	
	@Override
	public List<ReservationInfoDTO> readReservationInfo(){
		
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readReservationInfo();
		
		return infoList;
		
	}
	
	@Override
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo) {

		return reservationInfoDAO.createAdminReservationInfo(reservationInfo);
		
	}

}
