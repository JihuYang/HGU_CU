package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.EventDTO;

@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "Event";
	
	
	@Override
	public List<EventDTO> readEvent() {
		
		Map<String, Object> eventParam = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readEvent", eventParam);
	}
	
	@Override
	public int createEvent(EventDTO event) {
		
		sqlSession.insert(namespace+".createEvent", event);
		
		return 0;
	}
}