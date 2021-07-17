package com.cloud.porforio.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;

	@Override
	public void register(User user) {
		mapper.insert(user);
	}
		
	
}
