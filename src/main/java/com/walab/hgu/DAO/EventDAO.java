package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.EventDTO;

public interface EventDAO {
		
	public List<EventDTO> readEvent();
}
