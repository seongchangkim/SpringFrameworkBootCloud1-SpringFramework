package com.cloud.porforio.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cloud.porforio.domain.User;

@Mapper
public interface UserMapper {
	public void insert(User user);
}
