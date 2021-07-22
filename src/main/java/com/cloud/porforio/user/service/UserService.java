package com.cloud.porforio.user.service;

import com.cloud.porforio.domain.User;

public interface UserService {
	void register(User user);
	
	void registerAuth(String id);
	
	User findingId(String email, String tel, String name);
	
	String findingPassword(String email, String tel, String name);
	
	boolean isUpdatePassword(String id, String password);
	
	String selectName(String id);
}
