package com.cloud.porforio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuth {
	private String auth;
	private String id;
	private int idx;
}
