package com.cloud.porforio.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
	//페이지 처리하기 위한 필요한 변수들(2021.08.03)
	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지당 몇개의 데이터
	
	//검색기능 관련 선언 2021.08.05
	private String type; // 검색조건
	private String keyword; // 검색문자열
	
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum <= 0) {
			this.pageNum = 1;
		}else {
			this.pageNum = pageNum;
		}
	}

	public void setAmount(int amount) {
		int cnt = this.amount;
		
		if(amount != cnt) {
			this.amount = cnt;
		}else {
			this.amount = amount;
		}
	}
	
	public int getAmount() {
		return this.amount;
	}

	public int getPageStart() {
		return (this.pageNum - 1) * amount;
	}
	
	//검색기능 관련 메소드 2021.08.05
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split(""); 
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
														   .queryParam("pageNum", this.pageNum)
														   .queryParam("amount", this.getAmount())
														   .queryParam("type", this.getType())
														   .queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}
