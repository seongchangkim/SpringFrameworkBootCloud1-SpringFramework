package com.cloud.porforio.user.service;

import com.cloud.porforio.domain.User;

public interface UserService {
	void register(User user);
	
	void registerAuth(String id);
	
	User getUserInfo(String id, String password);
}
