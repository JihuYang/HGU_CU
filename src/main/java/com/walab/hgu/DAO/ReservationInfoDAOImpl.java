package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.ReservationInfoDTO;

@Repository
public class ReservationInfoDAOImpl implements ReservationInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "ReservationInfo";
	
	
	@Override
	public List<ReservationInfoDTO> readReservationInfo() {
		
		Map<String, Object> reservationInfoParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readReservationInfo", reservationInfoParam);
	}
	
	@Override
	public int createAdminReservationInfo(ReservationInfoDTO reservationInfo) {
		
		sqlSession.insert(namespace+".createAdminReservationInfo", reservationInfo);
		
		return 0;
	}
	
	@Override
	public int createReservation(ReservationInfoDTO reservationInfo) {
		
		sqlSession.insert(namespace+".createReservation", reservationInfo);
		
		return 0;
	}
	
	
}