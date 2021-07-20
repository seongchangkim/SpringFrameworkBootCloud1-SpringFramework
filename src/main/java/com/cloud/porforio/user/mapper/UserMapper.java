package com.cloud.porforio.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.User;

@Mapper
public interface UserMapper {
	public void insert(User user);
	
	public void insertAuth(@Param("id") String id,@Param("auth") String auth);
	
	public User findingId(@Param("email") String email, @Param("tel") String tel, @Param("name") String name);

	public String findingPassword(@Param("email") String email, @Param("tel") String tel, @Param("name") String name, @Param("id") String inputId);
	
	public boolean isUpdatePassword(@Param("password") String password, @Param("id") String id);

	public String selectUserName(@Param("id") String id, @Param("password") String password);
}
