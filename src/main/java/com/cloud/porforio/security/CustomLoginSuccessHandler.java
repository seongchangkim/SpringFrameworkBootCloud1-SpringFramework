package com.cloud.porforio.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {


		List<String> rolesNames = new ArrayList<>();
		authentication.getAuthorities().forEach(authority -> {
													rolesNames.add(authority.getAuthority());
										});
		
		if(rolesNames.contains("ROLE_USER")) {
			response.sendRedirect("/cloud/");
			return;
		}
		
		if(rolesNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/cloud/admin/");
			return;
		}
	}

}
