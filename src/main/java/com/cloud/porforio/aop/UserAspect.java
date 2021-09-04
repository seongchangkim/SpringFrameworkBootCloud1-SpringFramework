package com.cloud.porforio.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cloud.porforio.annotation.UserAnno;

@Component
@Aspect
public class UserAspect {

	@Around("@annotation(com.cloud.porforio.annotation.UserAnno) && @annotation(target)")
	public String getUserId(UserAnno target) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id="";
		if(principal != null){
			id = auth.getName();
		}
		return id;
	}

}
