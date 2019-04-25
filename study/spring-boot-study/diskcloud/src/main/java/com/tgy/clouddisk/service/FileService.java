package com.tgy.clouddisk.service;

import com.tgy.clouddisk.entity.UserFile;

import java.io.File;

/**
 * 文件上传、下载相关
 * @author tanggy
 * @date 2018/11/1
 */
public interface FileService {
    /**
     * 服务端保存所有文件的根路径
     */
    String FILE_BASE = "D:" + File.separator + "images" + File.separator;
    /**
     * 所有上传文件URL的根
     */
    String URL_ROOT = "http://localhost:8080/";

    default String getFullFilename(UserFile userFile) {
        return userFile.getFileName() + "." + userFile.getFileType();
    }
}
