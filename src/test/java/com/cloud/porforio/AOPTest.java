package com.cloud.porforio;

import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
public class AOPTest {

	@Test
	@Around("execution(* com..cloud..porforio..controller..*Controller.*(..)")
	public void AOPTest1() {
		log.info("Controller!!!");
	}

}
