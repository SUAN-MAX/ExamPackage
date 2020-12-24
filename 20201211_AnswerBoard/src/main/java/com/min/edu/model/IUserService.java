package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.UserDto;

public interface IUserService {
	public boolean signUpMember(UserDto dto);
	
	public boolean idDuplicateCheck(String id);
	
	public UserDto loginMember(Map<String, Object> map);
}
