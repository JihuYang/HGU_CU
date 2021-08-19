package com.walab.hgu.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.hgu.DTO.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "User";
	
	
	@Override
	public List<UserDTO> readUser(int displayPost, int postNum) {
		
		Map<String, Object> userList = new HashMap<String, Object>();
		userList.put("displayPost", displayPost);
		userList.put("postNum", postNum);
		
		System.out.println(userList);
				
		return sqlSession.selectList(namespace+".readUser", userList);
	}
	
	@Override
	public List<UserDTO> readAllUsers() {
		
		Map<String, Object> userList = new HashMap<String, Object>();
		
		System.out.println(userList);
				
		return sqlSession.selectList(namespace+".readAllUsers", userList);
	}


	@Override
	public int countInfo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countInfo");
	}
	
	@Override
	public int readUserIDByEmail(String email) {
		Map<String, Object> userListParam = new HashMap<String, Object>();
		userListParam.put("email", email);
		int id = 0;
		try {
			id = sqlSession.selectOne(namespace+".readUserIDByEmail", userListParam);
		}catch (NullPointerException e){
			System.out.println(e);
			id = 0;
		}
		return id;
	}


	@Override
	public int readAdminByUserID(int userID) {
		Map<String, Object> userParam = new HashMap<String, Object>();
		userParam.put("userID", userID);
		return sqlSession.selectOne(namespace+".readIsAdminByUserID", userParam);
	}


	@Override
	public int updateAuthority(Map<String, Object> authorityParam) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".updateAuthority", authorityParam);
	}
	
}