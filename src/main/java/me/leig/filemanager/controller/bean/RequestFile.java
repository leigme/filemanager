package me.leig.filemanager.controller.bean;

import me.leig.filemanager.dao.model.File;

/**
 * 请求参数
 *
 * @author leig
 * @version 20180301
 *
 */

public class RequestFile extends BaseRequest {

	// 文件对象
	private File data;
	
	public File getData() {
		return data;
	}

	public void setData(File data) {
		this.data = data;
	}
}