package com.cloud.porforio.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
	
	private String id;
	private String password;
	private String email;
	private String name;
	private String tel;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	public User(String id, String email, String name, String tel) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.tel = tel;
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
	
}
