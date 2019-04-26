package com.tgy.sbwebjsp.model;

import org.springframework.stereotype.Component;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Component("queryInfo")
public class QueryInfo {
    private int currentpage = 1;
    private int pagesize = 3;
    private int startindex;

    public QueryInfo() {
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage <= 0) {
            this.currentpage = 1;
        } else {
            this.currentpage = currentpage;
        }

    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        if (pagesize <= 0) {
            this.pagesize = 3;
        } else {
            this.pagesize = pagesize;
        }

    }

    public int getStartindex() {
        this.startindex = (this.currentpage - 1) * this.pagesize;
        return this.startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }
}
