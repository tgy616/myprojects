package com.tgy.clouddisk.dao.req;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class MoveReq {
    private List<Integer> files;
    private List<Integer> folders;
    private int dest;

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

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "MoveReq{" +
                "files=" + files +
                ", folders=" + folders +
                ", dest=" + dest +
                '}';
    }
}
