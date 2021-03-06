package com.walab.hgu.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

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
	public List<ReservationInfoDTO> readReservationInfoById(int userId){
		
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readReservationInfoById(userId);
		
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
	public List<ReservationInfoDTO> readReservationBySpaceNameById(String spaceName, int userId) {
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readReservationBySpaceNameById(spaceName, userId);
		return infoList;
	}
	
	@Override
	public List<ReservationInfoDTO> readSumReservation(int userId, Date reservationDate) {
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readSumReservation(userId, reservationDate);
		return infoList;
	}
	
	@Override
	public List<ReservationInfoDTO> readWeekSumReservation(int userId) {
		List<ReservationInfoDTO> infoList = reservationInfoDAO.readWeekSumReservation(userId);
		System.out.println("service: " + userId);
		return infoList;
	}

	@Override
	public int readTimeDifference(Time startTime, Time endTime) {
		int infoList = reservationInfoDAO.readTimeDifference(startTime, endTime);
		return infoList;
	
	}
	@Override
	public int deleteAdminReservation(int id){
		return reservationInfoDAO.deleteAdminReservation(id);
	}
	
	@Override
	public int deleteMyReservation(int id){
		return reservationInfoDAO.deleteMyReservation(id);
	}

	@Override //??????????????? ???????????? 
	public void updateStartHour(Map<String, Object> officeHourStart) {
		// TODO Auto-generated method stub
		reservationInfoDAO.updateStartHour(officeHourStart);
	}
	@Override
	public void updateEndHour(Map<String, Object> officeHourEnd) {
		// TODO Auto-generated method stub
		reservationInfoDAO.updateEndHour(officeHourEnd);
	}

}
