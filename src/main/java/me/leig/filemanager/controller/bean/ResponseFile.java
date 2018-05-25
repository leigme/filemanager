package me.leig.filemanager.controller.bean;

import me.leig.filemanager.dao.model.File;

/**
 * 响应文件对象
 *
 * @author leig
 * @version 20180301
 *
 */

public class ResponseFile extends BaseResponse {
	
	// 文件对象
	private File data;

	public File getData() {
		return data;
	}

	public void setData(File data) {
		this.data = data;
	}
}
