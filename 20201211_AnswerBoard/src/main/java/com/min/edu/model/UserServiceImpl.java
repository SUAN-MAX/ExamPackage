package com.min.edu.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.UserDto;

@Service
public class UserServiceImpl implements IUserService {
	
	private final Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserDao dao;
	@Override
	public boolean signUpMember(UserDto dto) {
		logger.info("signUpMember 실행");
		return dao.signUpMember(dto);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("idDuplicateCheck 실행");
		return dao.idDuplicateCheck(id);
	}

	@Override
	public UserDto loginMember(Map<String, Object> map) {
		logger.info("loginMember 실행");
		return dao.loginMember(map);
	}

}
