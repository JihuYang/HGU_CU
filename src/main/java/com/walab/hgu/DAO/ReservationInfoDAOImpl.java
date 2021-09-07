package com.walab.hgu.DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.ReservationInfoDTO;

@Repository
public class ReservationInfoDAOImpl implements ReservationInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "ReservationInfo";
	
	
	@Override
	public List<ReservationInfoDTO> readReservationInfoPaging(int displayPost, int postNum,String keyword) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("displayPost", displayPost);
		reservationInfoParam.put("postNum", postNum);
		reservationInfoParam.put("keyword", keyword);
				
		return sqlSession.selectList(namespace+".readReservationInfoPaging", reservationInfoParam);
	}

	@Override
	public List<ReservationInfoDTO> readReservationInfo() {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		
		return sqlSession.selectList(namespace+".readReservationInfo", reservationInfoParam);
	}
	
	@Override
	public List<ReservationInfoDTO> readReservationInfoById(int userId) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("userId", userId);
		System.out.println("userId in dao: " + userId);
		
		return sqlSession.selectList(namespace+".readReservationInfoById", reservationInfoParam);
	}
	
	@Override
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo) {
		
		sqlSession.insert(namespace+".createAdminReservationInfo", reservationInfo);
		
		return 0;
	}
	
	@Override
	public int createReservation(ReservationInfoDTO reservationInfo) {
		
		return sqlSession.insert(namespace+".createReservation", reservationInfo);
	}

	@Override
	public int countInfo(String keyword) {
		
		Map<String, Object> count = new HashMap<String, Object>();
		count.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace+".countInfo",count);
	}

	@Override
	public List<ReservationInfoDTO> readReservationBySpaceName(String spaceName) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("spaceName", spaceName);
		
		return sqlSession.selectList(namespace+".readReservationBySpaceName", reservationInfoParam);
	}
	
	@Override
	public List<ReservationInfoDTO> readReservationBySpaceNameById(String spaceName, int userId) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("spaceName", spaceName);
		reservationInfoParam.put("userId", userId);

		return sqlSession.selectList(namespace+".readReservationBySpaceNameById", reservationInfoParam);
	}
	
	@Override
	public List<ReservationInfoDTO> readSumReservation(int userId, Date reservationDate) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("userId", userId);
		reservationInfoParam.put("reservationDate", reservationDate);

		return sqlSession.selectList(namespace+".readSumReservation", reservationInfoParam);
	}
	
	@Override
	public List<ReservationInfoDTO> readWeekSumReservation(int userId) {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("userId", userId);
		System.out.println("dao userid: " + userId);

		return sqlSession.selectList(namespace+".readWeekSumReservation", reservationInfoParam);
	}
	
	@Override
	public int readTimeDifference(Time startTime, Time endTime){
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
		reservationInfoParam.put("startTime", startTime);
		reservationInfoParam.put("endTime", endTime);

		return sqlSession.selectOne(namespace+".readTimeDifference", reservationInfoParam);		
	}

	@Override
	public int updateAdminReservationInfo(ReservationInfoDTO reservationInfo) {
		return sqlSession.update(namespace+".updateAdminReservationInfo", reservationInfo);
	}
	
	@Override
	public int deleteAdminReservation(int id) {
		
		sqlSession.delete(namespace+".deleteAdminReservation", id);
		
		return 0;
	}
	
	@Override
	public int deleteMyReservation(int id) {
		
		sqlSession.delete(namespace+".deleteAdminReservation", id);
		
		return 0;
	}

	//오피스아워 업데이트 
	@Override
	public void updateStartHour(Map<String, Object> officeHourStart) {
		
		sqlSession.update(namespace+".updateStartHour", officeHourStart);
	}
	@Override
	public void updateEndHour(Map<String, Object> officeHourEnd) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateEndHour", officeHourEnd);
	}
	
	
}