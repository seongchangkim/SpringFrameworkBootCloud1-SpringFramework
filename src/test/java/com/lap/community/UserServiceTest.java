package com.lap.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.porforio.user.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Service
@Log4j
public class UserServiceTest {

	@Autowired
	private UserMapper mapper;
	
	@Test
	public void updatePasswordTest() {
		String password = "java";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String securityPw = encoder.encode(password);
		int updatePassword = mapper.isUpdatePassword("darktemplate", securityPw);
		log.info(updatePassword);
	}
}
