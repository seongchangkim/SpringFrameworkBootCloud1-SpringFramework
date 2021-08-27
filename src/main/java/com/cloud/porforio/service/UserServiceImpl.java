package com.cloud.porforio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;

	@Override
	public void register(User user) {
		// 회원 비밀번호를 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 비밀번호 암호화하여 다시 user객체에 저장
		String securePw = encoder.encode(user.getPassword());
		user.setPassword(securePw); // DB에서 넘겨주기 위해 암호화된 비밀번호를 user 객체에 저장
		mapper.insert(user);
	}

	@Override
	public void registerAuth(String id) {
		String auth = "";
		if(id.startsWith("admin")) {
			auth = "ROLE_ADMIN";
		}else {
			auth = "ROLE_USER";
		}
		
		mapper.insertAuth(id,auth);
		
	}

	@Override
	public User findingId(String email, String tel, String name) {
		return mapper.findingId(email,tel,name);
	}

	@Override
	public String findingPassword(String email, String tel, String name, String id) {
		return mapper.findingPassword(email,tel,name, id);
	}

	@Override
	public boolean isUpdatePassword(String id, String password) {
		return mapper.isUpdatePassword(id, password) == 1;
	}

	@Override
	public String selectName(String id) {
		return mapper.selectName(id);
	}

	@Override
	public String selectPassword(String id) {
		return mapper.selectPassword(id);
	}

	@Override
	public User selectUserInfo(String id) {
		return mapper.selectUserInfo(id);
	}

	@Override
	public boolean updateUserInfo(User user) {
		return mapper.updateUserInfo(user) == 1;
	}

	@Override
	public boolean deleteUserInfo(String id) {
		return mapper.deleteUserInfo(id) == 1;
	}

	@Override
	public boolean deleteUserAuth(String id) {
		return mapper.deleteUserAuth(id) == 1;
	}
	
	
}
