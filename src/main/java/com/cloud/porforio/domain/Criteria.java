package com.cloud.porforio.domain;

public class Criteria {
	//페이지 처리하기 위한 필요한 변수들(2021.08.03)
	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지당 몇개의 데이터
	
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
}
