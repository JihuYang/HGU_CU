package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.ClubAdvertiseDTO;

public interface ClubAdvertiseService{
	////동아리 홍보페이지 리스트 창 
	public List<ClubAdvertiseDTO> readClubAdvertisePreview();
	
}
