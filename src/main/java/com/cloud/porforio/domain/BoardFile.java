package com.cloud.porforio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardFile {

	private int idx;
	private int bno;
	private String originalFileName;
	private String storedFileName;
	private String filesize;
}
