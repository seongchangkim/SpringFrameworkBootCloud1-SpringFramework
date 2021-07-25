package com.cloud.porforio.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// PasswordEncoder를 구현하여 나만의 패스워드 인코딩하는 클래스
// BCryptPassword 클래스로 설정하면 비밀번호 수정이나 다른 인증하는 기능을 구현할 수 없음
// 그래서 만들었음(salt값이 랜덤을 생성하기 때문에 안됨)
public class CustomPasswordEncoder implements PasswordEncoder{

	// encode란 추상메서드를 BCrypt.hashpw라는 메소드를 사용하면 salt값을 
	// 랜덤으로 생성 못하게 한다.(단, 회원가입은 제외)
	@Override
	public String encode(CharSequence rawPassword) {
		return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
	}
}
