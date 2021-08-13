package com.walab.hgu.service;

import java.util.List;

import com.walab.hgu.DTO.UserDTO;

public interface UserService {
	
	public List<UserDTO> readUser(int displayPost, int postNum);

	public int countInfo();
	public int readUserIDByEmail(String email);
	public int readAdminByUserID(int userID);

}
