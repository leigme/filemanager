package me.leig.filemanager.dao.mapper;

import java.util.List;

import me.leig.filemanager.dao.model.File;
import me.leig.filemanager.dao.model.FileWithBLOBs;

public interface FileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileWithBLOBs record);

    int insertSelective(FileWithBLOBs record);

    FileWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FileWithBLOBs record);

    int updateByPrimaryKey(File record);
    
    
    /**
     * 查询总记录数
     * 
     * @param record
     * @return
     */
    int recordCount(File record);
    
    /**
     * 查询文件集合
     * 
     * @param record
     * @return
     */
    List<File> findFiles(File record);
    
    /**
     * 通过编号查询文件
     * 
     * @param id
     * @return
     */
    File findFile(int id);
    
    /**
     * 添加文件
     * 
     * @param record
     * @return
     */
    int addFile(File record);
    
    /**
     * 更新文件
     * 
     * @param record
     * @return
     */
    int updateFile(File record);
}