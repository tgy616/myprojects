package com.tgy.clouddisk.dao.req;

import javax.validation.constraints.Size;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class RenameFileReq {
    @Size(min = 1, max = 100)
    private String fileName;
    @Size(min = 1, max = 100)
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "RenameFileReqBody{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
