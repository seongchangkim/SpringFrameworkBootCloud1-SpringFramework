package com.cloud.porforio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/security-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BCryptPasswordEncoderEqualsTest {
	
	@Test
	public void bCryptPasswordEncoderEqualsTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass1 = encoder.encode("password");
		String pass2 = encoder.encode("password");
		//assertEquals(pass1,pass2);
		log.info(pass1 == pass2);
	}
}
