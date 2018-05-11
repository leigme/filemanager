package me.leig.filemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.leig.filemanager.controller.bean.RequestFile;
import me.leig.filemanager.controller.bean.ResponseFile;
import me.leig.filemanager.controller.bean.ResponseFiles;
import me.leig.filemanager.service.FileService;

/**
 * 
 *
 * @author leig
 * @version 20180301
 *
 */
@RestController
@RequestMapping(value = "/v1/f/")
public class FileController {

	@Autowired
	private FileService fileService;
	
	/**
	 * 添加文件
	 * 
	 * @param requestFile
	 * @return
	 */
	@RequestMapping(value = {"/add"}, method = {RequestMethod.POST})
	public ResponseFile addFile(@RequestBody RequestFile requestFile) {
		return new ResponseFile();
	}
	
	/**
	 * 添加文件集合
	 * 
	 * @param requestFiles
	 * @return
	 */
	@RequestMapping(value = {"/adds"}, method = {RequestMethod.POST})
	public ResponseFiles addFiles(@RequestBody List<RequestFile> requestFiles) {
		return new ResponseFiles();
	}
	
	/**
	 * 查询文件对象
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {"/find/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseFile fileFile(@RequestParam(value = "id", required = true)int id) {
		
		return new ResponseFile();
	}

	/**
	 * 查询文件集合
	 * 
	 * @param requestFile
	 * @return
	 */
	@RequestMapping(value = {"/finds"}, method = {RequestMethod.POST})
	public ResponseFiles findFiles(@RequestBody RequestFile requestFile) {
	
		ResponseFiles rFiles = fileService.findFiles(requestFile);
		
		return rFiles;
	}
	
	/**
	 * 更新文件对象
	 * 
	 * @param requestFile
	 * @return
	 */
	@RequestMapping(value = {"/update"}, method = {RequestMethod.POST})
	public ResponseFile updateFile(@RequestBody RequestFile requestFile) {
		return new ResponseFile();
	}
	
	/**
	 * 更新文件集合
	 * 
	 * @param responseFiles
	 * @return
	 */
	@RequestMapping(value = {"/updates"}, method = {RequestMethod.POST})
	public ResponseFiles updateFiles(@RequestBody ResponseFiles responseFiles) {
		return new ResponseFiles();
	}
	
	/**
	 * 删除文件对象
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {"/del/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseFile deleteFile(@RequestParam(value = "id", required = true)int id) {
		return new ResponseFile();
	}
	
	/**
	 * 删除文件集合
	 * 
	 * @param responseFiles
	 * @return
	 */
	@RequestMapping(value = {"/dels"}, method = {RequestMethod.POST})
	public ResponseFiles deleteFiles(@RequestBody ResponseFiles responseFiles) {
		
		return new ResponseFiles();
	}
}
