package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.ClubAdvertiseDAO;
import com.walab.hgu.DTO.ClubAdvertiseDTO;

@Service
public class ClubAdvertiseServiceImpl implements ClubAdvertiseService{
	
	@Autowired
	ClubAdvertiseDAO clubAdvertiseDAO ;

	@Override
	public List<ClubAdvertiseDTO> readClubAdvertisePreview() {
		

		List<ClubAdvertiseDTO> adList = clubAdvertiseDAO.readClubAdvertisePreview();
		
		return adList;
	}

}
