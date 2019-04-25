package com.tgy.clouddisk.dao.req;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class ShredReq {
    private List<Integer> files;
    private List<Integer> folders;

    public List<Integer> getFiles() {
        return files;
    }

    public void setFiles(List<Integer> files) {
        this.files = files;
    }

    public List<Integer> getFolders() {
        return folders;
    }

    public void setFolders(List<Integer> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "ShredReqBody{" +
                "files=" + files +
                ", folders=" + folders +
                '}';
    }
}
