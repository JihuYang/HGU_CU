package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.SpaceDTO;

public interface SpaceService {
	
	public List<SpaceDTO> readSpace();

	public List<SpaceDTO> readSpaceByName(String spaceName);

}
