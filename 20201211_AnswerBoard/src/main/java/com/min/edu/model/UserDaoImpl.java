package com.min.edu.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.UserDto;

@Repository
public class UserDaoImpl implements IUserDao {

	private String NS = "com.min.edu.model.member.mapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public boolean signUpMember(UserDto dto) {
		int cnt = session.insert(NS+"signUpMember", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int cnt = session.selectOne(NS+"idDuplicateCheck", id);
		return (cnt>0)?true:false;
	}

	@Override
	public UserDto loginMember(Map<String, Object> map) {
		return session.selectOne(NS+"loginMember", map);
	}

}
