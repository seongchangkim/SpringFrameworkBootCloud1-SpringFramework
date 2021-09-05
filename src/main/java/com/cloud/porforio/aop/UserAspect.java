package com.cloud.porforio.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cloud.porforio.annotation.UserAnno;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class UserAspect {
	
	@Around("@annotation(com.cloud.porforio.aop.UserAnno) && @annotation(user)")
	public String getUserId(JoinPoint joinPoint, UserAnno user) {
		String id = null;
		Object[] obj = joinPoint.getArgs();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		if(principal != null) {
			id = auth.getName();
		}
		
		return id;
	}

}
