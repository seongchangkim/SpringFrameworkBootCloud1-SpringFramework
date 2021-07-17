package com.cloud.porforio.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.mapper.UserMapper;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;

	@Override
	public void register(User user) {
		mapper.insert();
		
	}
		
	
}
