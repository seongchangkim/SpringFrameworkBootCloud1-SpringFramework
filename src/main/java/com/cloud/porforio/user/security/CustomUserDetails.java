package com.cloud.porforio.user.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.cloud.porforio.domain.User;

public class CustomUserDetails extends User{
	
	public CustomUserDetails(User user, Collection<? extends GrantedAuthority> auth) {
		super(user.getId(),user.getRole());
	}
}
