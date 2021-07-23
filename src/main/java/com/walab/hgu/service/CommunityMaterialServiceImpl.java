package com.walab.hgu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityMaterialDAO;
import com.walab.hgu.DTO.CommunityMaterialDTO;

@Service
public class CommunityMaterialServiceImpl implements CommunityMaterialService{
	
	@Autowired
	CommunityMaterialDAO communityMaterialDAO;
	
	@Override
	public List<CommunityMaterialDTO> readCommunityMaterial(){
		
		List<CommunityMaterialDTO> infoList = communityMaterialDAO.readCommunityMaterial();

		for (CommunityMaterialDTO i : infoList) {
			i.getRegdate();
			Date date = (Date)i.getRegdate();
			System.out.println(date);
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("AFTER: " + newDtFormat.format(date));
		}


		//SimpleDateFormat infoList.getRegdate() = new SimpleDateFormat("yyyy-MM-dd");
		
		return infoList;
		
	}

}
