package com.guojianghao.entity.page;

import com.alibaba.fastjson.JSON;

public class Page {
	
	private int page;
	private int rows;
	
	public Page() {}
	
	public Page(int page,int rows) {
		this.page = (page - 1)*rows;
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
