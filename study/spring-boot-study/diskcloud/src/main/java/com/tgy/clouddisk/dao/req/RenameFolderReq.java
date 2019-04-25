package com.tgy.clouddisk.dao.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class RenameFolderReq {
    @NotNull
    @Size(min = 1, max = 100)
    private String folderName;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public String toString() {
        return "RenameFolderReqBody{" +
                "folderName='" + folderName + '\'' +
                '}';
    }
}
