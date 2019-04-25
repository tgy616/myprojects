package com.tgy.clouddisk.dao.req;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class NoteInsertReq {
    private Integer userId;

    private String title;

    private String content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
