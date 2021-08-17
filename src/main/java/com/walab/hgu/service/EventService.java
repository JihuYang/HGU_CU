package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.EventDTO;

public interface EventService {
	
	public List<EventDTO> readEvent();
	//public EventDTO readEvent(int id);
	public int createEvent(EventDTO evnet);
	public int deleteEvent(int id);

}
