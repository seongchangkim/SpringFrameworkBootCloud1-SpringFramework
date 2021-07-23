package com.cloud.porforio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.mapper.UserMapper;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserMapper mapper;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		User user = (User)mapper.selectUser(username);
		
		if(!matchPassword(password,user.getPassword())) {
			throw new BadCredentialsException(username);
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}
		return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	private boolean matchPassword(String loginPwd, String password) {
		return loginPwd.equals(password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
