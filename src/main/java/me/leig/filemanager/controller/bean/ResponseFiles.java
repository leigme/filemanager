package me.leig.filemanager.controller.bean;

import java.util.List;

import me.leig.filemanager.dao.model.File;

/**
 * 响应文件集合对象
 *
 * @author leig
 * @version 20180301
 *
 */

public class ResponseFiles extends BaseResponse {
	
	private List<File> files;
	
	private int recordCount;
	
	private int pageCount;

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}