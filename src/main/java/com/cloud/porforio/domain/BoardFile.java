package com.cloud.porforio.domain;

import lombok.Data;

@Data
public class BoardFile {

	private int idx;
	private int bno;
	private String originalFileName;
	private String storedFilePath;
	private long filesize;
	
}
