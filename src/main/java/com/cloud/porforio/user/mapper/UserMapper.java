package com.cloud.porforio.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.User;

@Mapper
public interface UserMapper {
	public void insert(User user);
	
	public void insertAuth(@Param("id") String id,@Param("auth") String auth);
	
	
	
	public String findingId(@Param("email") String email, @Param("tel") String tel, @Param("name") String name);
}
