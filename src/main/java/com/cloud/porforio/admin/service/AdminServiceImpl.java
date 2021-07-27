package com.cloud.porforio.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.porforio.admin.mapper.AdminMapper;
import com.cloud.porforio.domain.User;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper mapper;
	
	@Override
	public List<User> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public User selectUserInfoDetail(String id) {
		return mapper.selectUserInfoDetail(id);
	}

	@Override
	public boolean updateUserInfo(User user) {
		return mapper.updateUserInfo(user) == 1;
	}

	@Override
	public boolean deleteUserInfo(String id) {
		return mapper.deleteUserInfo(id) == 1;
	}

	@Override
	public String selectUserPassword(String id) {
		return mapper.selectUserPassword(id);
	}
}
