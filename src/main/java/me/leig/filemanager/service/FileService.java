package me.leig.filemanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.leig.filemanager.comm.Constant;
import me.leig.filemanager.comm.Toolbox;
import me.leig.filemanager.controller.bean.RequestFile;
import me.leig.filemanager.controller.bean.ResponseFile;
import me.leig.filemanager.controller.bean.ResponseFiles;
import me.leig.filemanager.dao.mapper.FileMapper;
import me.leig.filemanager.dao.model.File;

/**
 * 文件操作服务
 *
 * @author leig
 * @version 20180301
 *
 */
@Service
public class FileService {
	
	@Autowired
	private FileMapper fileMapper;
	
	/**
	 * 通过文件对象获取文件集合
	 * 
	 * @param rFile
	 */
	public ResponseFiles findFiles(RequestFile rFile) {
		// 准备返回对象
		ResponseFiles responseFiles = new ResponseFiles();
		
		File file = rFile.getData();

		// 初始化参数
		if (null == file) {
			file = new File();
		}
		
		file.setDeleteflag(Constant.status_normal);
		file.setStart(Toolbox.pageToStart(rFile.getPage(), rFile.getLimit()));
		file.setLimit(rFile.getLimit());
		
		// 查询记录数
		int total = fileMapper.recordCount(file);
		
		if (0 >= total) {
			responseFiles.setErrorFlag(true);
			responseFiles.setErrorCode("fileMapper.recordCount() failed");
			responseFiles.setErrorMsg("查询总记录数为空");
			return responseFiles;
		}
		
		List<File> files = fileMapper.findFiles(rFile.getData());
		
		responseFiles.setRecordCount(total);
		responseFiles.setPageCount(Toolbox.pageForTotal(total, rFile.getLimit()));
		
		responseFiles.setFiles(files);

		return responseFiles;
	}
	
	/**
	 * 添加文件
	 * 
	 * @param rFile
	 * @return
	 */
	public ResponseFile addFile(RequestFile rFile) {
		// 准备返回参数
		ResponseFile responseFile = new ResponseFile();
		
		File file = rFile.getData();

		// 参数验证
		if (null == file) {
			responseFile.setErrorFlag(true);
			responseFile.setErrorCode("FileService.addFile() failed");
			responseFile.setErrorMsg("添加对象不能为空");
			return responseFile;
		}
		
		if (0 < file.getId() || null == file.getTempurl() || "".equals(file.getTempurl())) {
			responseFile.setErrorFlag(true);
			responseFile.setErrorCode("FileService.addFile() failed");
			responseFile.setErrorMsg("参数错误");
			return responseFile;
		}
		
		if (null == file.getCreatetime()) {
			file.setCreatetime(new Date());	
		}
		file.setUpdatetime(new Date());
		file.setUploadtime(new Date());
		file.setDeleteflag(Constant.status_normal);
		
		int result = fileMapper.addFile(file);
		
		if (0 >= result) {
			responseFile.setErrorFlag(true);
			responseFile.setErrorCode("FileService.addFile() failed");
			responseFile.setErrorMsg("添加失败");
		}
		
		responseFile.setData(file);
		
		return responseFile;
	}
	
	/**
	 * 批量添加文件
	 * 
	 * @param requestFiles
	 * @return
	 */
	@Transactional
	public ResponseFiles addFiles(List<RequestFile> requestFiles) {
		// 准备返回参数
		ResponseFiles responseFiles = new ResponseFiles();
		
		// 参数验证
		if (null == requestFiles || 0 == requestFiles.size()) {
			responseFiles.setErrorFlag(true);
			responseFiles.setErrorCode("FileService.addFiles() failed");
			responseFiles.setErrorMsg("参数不能为空");
			return responseFiles;
		}
		
		List<File> files = new ArrayList<>();
		
		for (RequestFile rFile: requestFiles) {
			ResponseFile responseFile = addFile(rFile);
			if(responseFile.isErrorFlag()) {
				throw new RuntimeException();
			}
			files.add(responseFile.getData());
		}
		
		responseFiles.setFiles(files);
		
		return responseFiles;
	}
	
	/**
	 * 更新文件
	 * 
	 * @param rFile
	 * @return
	 */
	public ResponseFile updateFile(RequestFile rFile) {
		// 准备返回参数
		ResponseFile responseFile = new ResponseFile();
		
		// 参数验证
		File file = rFile.getData();
		
		if (null == file || 0 >= file.getId()) {
			responseFile.setErrorFlag(true);
			responseFile.setErrorCode("FileService.updateFile() failed");
			responseFile.setErrorMsg("更新对象不能为空");
			return responseFile;
		}
		
		if (null == file.getUpdatetime()) {
			file.setUpdatetime(new Date());
		}
		
		int result = fileMapper.updateFile(file);
		
		if (0 >= result) {
			responseFile.setErrorFlag(true);
			responseFile.setErrorCode("FileService.updateFile() failed");
			responseFile.setErrorMsg("更新失败");
			return responseFile;
		}
		
		return responseFile;
	}
	
	/**
	 * 批量更新
	 * 
	 * @param rFiles
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	public ResponseFiles updateFiles(List<RequestFile> rFiles) {
		// 准备返回参数
		ResponseFiles responseFiles = new ResponseFiles();
		
		// 参数验证
		if (null == rFiles || 0 == rFiles.size()) {
			responseFiles.setErrorFlag(true);
			responseFiles.setErrorCode("FileService.updateFile() failed");
			responseFiles.setErrorMsg("更新对象不能为空");
			return responseFiles;
		}
		
		List<File> files = new ArrayList<>();
		
		for (RequestFile rFile: rFiles) {
			ResponseFile responseFile = updateFile(rFile);
			if (responseFile.isErrorFlag()) {
				throw new RuntimeException();
			}
			files.add(responseFile.getData());
		}
		
		responseFiles.setFiles(files);
		
		return responseFiles;
	}
}