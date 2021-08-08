package com.cloud.porforio.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FileDTO {
	
	private int fno;
	private String id;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
	private LocalDateTime regDate;
}
