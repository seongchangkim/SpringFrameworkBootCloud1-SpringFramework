package com.cloud.porforio.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBcryptPasswordEncoder extends BCryptPasswordEncoder{

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		boolean result = super.matches(rawPassword, encodedPassword);
		return result;
	}
	
}
