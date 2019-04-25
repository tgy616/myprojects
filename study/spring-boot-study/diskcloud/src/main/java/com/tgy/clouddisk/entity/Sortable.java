package com.tgy.clouddisk.entity;

import java.util.Date;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class Sortable {
    protected Date modifyTime;
    protected String fileFolderName;

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getFileFolderName() {
        return fileFolderName;
    }

    public void setFileFolderName(String fileFolderName) {
        this.fileFolderName = fileFolderName;
    }
}
