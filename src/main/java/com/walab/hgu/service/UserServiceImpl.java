package com.walab.hgu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.UserDAO;
import com.walab.hgu.DTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public List<UserDTO> readUser(int displayPost, int postNum) {
		
		List<UserDTO> userList = userDAO.readUser(displayPost,postNum);

		return userList;
		
	}
	
	public List<UserDTO> readAllUsers(){
		
		List<UserDTO> userList = userDAO.readAllUsers();
		
		return userList;
	}

	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return userDAO.countInfo();
	}
	
	@Override
	public int readUserIDByEmail(String email) {
		
		int userID = userDAO.readUserIDByEmail(email);
		
		return userID;
	}
	
	@Override
	public int readAdminByUserID(int userID) {
		return userDAO.readAdminByUserID(userID);
	}

	@Override
	public int updateAuthority(Map<String, Object> authorityParam) {
		// TODO Auto-generated method stub
		return userDAO.updateAuthority(authorityParam);
	}
	
	

}