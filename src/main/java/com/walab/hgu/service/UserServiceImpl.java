package com.walab.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walab.hgu.DAO.UserDAO;
import com.walab.hgu.DTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public List<UserDTO> readUser() {
		
		List<UserDTO> userList = userDAO.readUser();

		return userList;
		
	}
	

}