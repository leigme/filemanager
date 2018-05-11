package me.leig.filemanager.controller.bean;

import me.leig.filemanager.comm.Constant;

/**
 * 基础请求对象
 *
 * @author leig
 * @version 20180301
 *
 */

public abstract class BaseRequest {
	
	// 当前页
	private int page;
	
	// 请求记录数
	private int limit = Constant.limit;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
