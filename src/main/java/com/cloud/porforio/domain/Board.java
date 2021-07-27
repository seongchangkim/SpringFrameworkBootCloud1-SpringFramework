package com.cloud.porforio.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {

	private int bno;
	private String id;
	private String name;
	private String title;
	private String content;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private String deleteYN;
	private int readCount;
	private int replyCount;
}
