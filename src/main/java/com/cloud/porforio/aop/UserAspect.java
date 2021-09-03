package com.cloud.porforio.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cloud.porforio.service.FileUpDownLoadService;

@Component
@Aspect
public class UserAspect {
	
	@Autowired
	private FileUpDownLoadService service;
	
	@Before("execution(* com..cloud..porforio.FileUpDownLoadController.upload(..))" 
			+ "execution(* com..cloud..porforio.FileUpDownLoadController.deleteYNUpdateFile(..))"
			+ "execution(* com..cloud..porforio.FileUpDownLoadController.restore(..))")
	public void checkAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
				
		String id = "";
		if(principal != null) {
			id = auth.getName();
		}
				
		String userAuth = service.selectUserAuth(id);
		String path = "";
				
		if(userAuth.equals("ROLE_USER")) {
			path = "/user/";
		}else {
			path = "/admin/";
		}
	}
	
	@Before("execution(* com..cloud..porforio.FileUpDownLoadController.upload(..))" 
			+ "execution(* com..cloud..porforio.FileUpDownLoadController.deleteYNUpdateFile(..))"
			+ "execution(* com..cloud..porforio.FileUpDownLoadController.restore(..))")
	public void getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id="";
		if(principal != null){
			id = auth.getName();
		}
	}

}
