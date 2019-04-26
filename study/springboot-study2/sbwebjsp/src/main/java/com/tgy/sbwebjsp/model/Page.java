package com.tgy.sbwebjsp.model;

/**
 * @author tanggy
 * @date 2018/10/31
 */
public class Page {
    private int currentpage;
    private int pagesize;
    private int startindex;
    private String filepath;
    private String searchcontent;

    public Page() {
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPageSize() {
        return this.pagesize;
    }

    public void setPageSize(int pageSize) {
        this.pagesize = pageSize;
    }

    public int getStartindex() {
        this.startindex = (this.currentpage - 1) * this.pagesize;
        return this.startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getSearchcontent() {
        return this.searchcontent;
    }

    public void setSearchcontent(String searchcontent) {
        this.searchcontent = searchcontent;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
