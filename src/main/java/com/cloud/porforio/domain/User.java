package com.cloud.porforio.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	
	private String id;
	private String password;
	private String email;
	private String name;
	private String tel;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private String deletedYN;
	private String role;
}
