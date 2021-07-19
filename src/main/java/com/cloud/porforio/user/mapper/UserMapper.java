package com.cloud.porforio.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.porforio.domain.User;

@Mapper
public interface UserMapper {
	public void insert(User user);
	
	public void insertAuth(@Param("id") String id,@Param("auth") String auth);
	
	public User getUserInfo(@RequestParam("id") String id, @RequestParam("password") String password);
}
