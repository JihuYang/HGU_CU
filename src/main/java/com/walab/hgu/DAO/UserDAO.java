package com.walab.hgu.DAO;

import java.util.List;

import com.walab.hgu.DTO.UserDTO;

public interface UserDAO {
		
	public List<UserDTO> readUser(int displayPost, int postNum);

	public int countInfo();
	
}
