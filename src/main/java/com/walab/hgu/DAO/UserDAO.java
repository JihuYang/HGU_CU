package com.walab.hgu.DAO;

import java.util.List;
import java.util.Map;

import com.walab.hgu.DTO.CommunityInfoDTO;
import com.walab.hgu.DTO.UserDTO;

public interface UserDAO {

	public int createUserInfo(UserDTO userInfo);

	public List<UserDTO> readUser(int displayPost, int postNum);

	public List<UserDTO> readAllUsers();

	public int countInfo();

	public int readUserIDByEmail(String email);

	public int readAdminByUserID(int userID);

	public int updateAuthority(Map<String, Object> authorityParam);
}
