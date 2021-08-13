package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.EventDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.EventDTO;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	EventDAO eventDAO;
	
	@Override
	public List<EventDTO> readEvent(){
		
		List<EventDTO> infoList = eventDAO.readEvent();
		
		return infoList;
		
	}
	
	@Override
	public int createEvent(EventDTO event) {

		return eventDAO.createEvent(event);

	}

}
