package me.leig.filemanager.dao.model;

/**
 * 模型基类
 *
 * @author leig
 * @version 20180301
 *
 */

public abstract class BaseModel {
	
	private int start;
	
	private int limit;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
