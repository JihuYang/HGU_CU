package com.walab.hgu.DAO;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.UserDTO;

public interface UserDAO {
		
	public List<UserDTO> readUser(int displayPost, int postNum);

	public int countInfo();
	public int readUserIDByEmail(String email);
	public int readAdminByUserID(int userID);

	public int updateAuthority(Map<String, Object> authorityParam);
}
