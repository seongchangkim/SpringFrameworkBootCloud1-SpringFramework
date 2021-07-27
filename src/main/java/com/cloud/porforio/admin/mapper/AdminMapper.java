package com.cloud.porforio.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.User;

public interface AdminMapper {
	
	public List<User> getUserList();
	
	public User selectUserInfoDetail(@Param("id") String id);
	
	public int updateUserInfo(User user);
	
	public int deleteUserInfo(@Param("id") String id);

	public String selectUserPassword(@Param("id") String id);
}
