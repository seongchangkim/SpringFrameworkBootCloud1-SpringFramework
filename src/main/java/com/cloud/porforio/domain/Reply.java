package com.cloud.porforio.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Reply {
	private int rno;
	private int bno;
	private String reply;
	private String id;
	private String name;
	private LocalDateTime replydate;
	private LocalDateTime updatedate;
}
