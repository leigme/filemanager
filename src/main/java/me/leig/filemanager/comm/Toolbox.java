package me.leig.filemanager.comm;

/**
 * 
 *
 * @author leig
 * @version 20180301
 *
 */

public class Toolbox {
	
	/**
	 * 通过当前页获取检索开始数
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	public static int pageToStart(int page, int limit) {
		int start = (page - 1) * limit;
		return start > 0 ? start : 0;
	}
	
	public static int pageForTotal(int total, int limit) {
		return (total + limit - 1) / limit;
	}
	
}
