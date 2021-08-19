package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ReservationInfoDAO;
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
	public List<ReservationInfoDTO> readReservationInfoPaging(int displayPost, int postNum,String keyword) {
		
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readReservationInfoPaging(displayPost,postNum,keyword);
		
		return infoList;
	}
	
	@Override
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo) {

		return reservationInfoDAO.createAdminReservationInfo(reservationInfo);
		
	}
	
	@Override
	public int createReservation(ReservationInfoDTO reservationInfo) {

		return reservationInfoDAO.createReservation(reservationInfo);
		
	}
	
	@Override
	public int updateAdminReservationInfo(ReservationInfoDTO reservationInfo) {
		return reservationInfoDAO.updateAdminReservationInfo(reservationInfo);
	}

	@Override
	public int countInfo(String keyword) {
		// TODO Auto-generated method stub
		return reservationInfoDAO.countInfo(keyword);
	}

	@Override
	public List<ReservationInfoDTO> readReservationBySpaceName(String spaceName) {
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readReservationBySpaceName(spaceName);
		return infoList;
	}
	
	@Override
	public int deleteAdminReservation(int id){
		return reservationInfoDAO.deleteAdminReservation(id);
	}

}
