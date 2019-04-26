package com.tgy.sbwebjsp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Component("file")
@Scope("prototype")
public class File {
    private int id;
    private String filename;
    private String filepath;
    private String filesize;
    private Date createtime;
    private int canshare;
    private int user_id;
    private String MD5;

    public File() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilesize() {
        return this.filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getCanshare() {
        return this.canshare;
    }

    public void setCanshare(int canshare) {
        this.canshare = canshare;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMD5() {
        return this.MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }
}
