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
	public List<UserDTO> readUser() {
		
		Map<String, Object> userList = new HashMap<String, Object>();
				
		return sqlSession.selectList(namespace+".readUser", userList);
	}
	
}