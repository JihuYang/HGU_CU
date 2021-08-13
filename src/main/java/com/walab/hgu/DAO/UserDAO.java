package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.UserDTO;

public interface UserDAO {
		
	public List<UserDTO> readUser();
	public int readUserIDByEmail(String email);
	public int readAdminByUserID(int userID);
}
