package com.cloud.porforio.service;

import com.cloud.porforio.domain.User;

public interface UserService {
	void register(User user);
	
	void registerAuth(String id);
	
	User findingId(String email, String tel, String name);
	
	String findingPassword(String email, String tel, String name, String id);
	
	boolean isUpdatePassword(String id, String password);
	
	String selectName(String id);
	
	String selectPassword(String id);
	
	User selectUserInfo(String id);
	
	boolean updateUserInfo(User user);
	
	boolean deleteUserInfo(String id);
	
	boolean deleteUserAuth(String id);
}
