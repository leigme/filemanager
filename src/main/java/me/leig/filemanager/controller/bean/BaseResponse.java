package me.leig.filemanager.controller.bean;

/**
 * 响应基础对象
 *
 * @author leig
 * @version 20180301
 *
 */

public abstract class BaseResponse {
	
	// 错误标志
	private boolean errorFlag = false;
	
	// 错误编号
	private String errorCode = "";
	
	// 错误消息
	private String errorMsg = "";

	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
