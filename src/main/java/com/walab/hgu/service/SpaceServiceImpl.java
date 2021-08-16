package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.SpaceDAO;
import com.walab.hgu.DTO.SpaceDTO;

@Service
public class SpaceServiceImpl implements SpaceService{
	
	@Autowired
	SpaceDAO spaceDAO;
	
	@Override
	public List<SpaceDTO> readSpace(){
		
		List<SpaceDTO> infoList = spaceDAO.readSpace();
		
		return infoList;
		
	}

	@Override
	public List<SpaceDTO> readSpaceByName(String spaceName) {
		
		List<SpaceDTO> infoList = spaceDAO.readSpaceByName(spaceName);
		
		return infoList;
	}

}
