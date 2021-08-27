package com.cloud.porforio.service;

import java.util.List;

import com.cloud.porforio.domain.User;

public interface AdminService {
	
	List<User> getUserList();
	
	User selectUserInfoDetail(String id);
	
	boolean updateUserInfo(User user);
	
	boolean deleteUserInfo(String id);
	
	String selectUserPassword(String id);
	
}
