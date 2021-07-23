package com.walab.hgu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.CommunityInfoDAO;
import com.walab.hgu.DTO.CommunityInfoDTO;

@Service
public class CommunityInfoServiceImpl implements CommunityInfoService{
	
	@Autowired
	CommunityInfoDAO communityInfoDAO;
	
	@Override
	public List<CommunityInfoDTO> readCommunityInfo(){
		
		List<CommunityInfoDTO> infoList = communityInfoDAO.readCommunityInfo();

		for (CommunityInfoDTO i : infoList) {
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
