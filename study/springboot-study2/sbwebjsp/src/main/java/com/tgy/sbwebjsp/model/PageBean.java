package com.tgy.sbwebjsp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Component("pageBean")
@Scope("prototype")
public class PageBean {
    private List list;
    private int totalrecord;
    private int pagesize;
    private int totalpage;
    private int currentpage;
    private int previouspage;
    private int nextpage;
    private int[] pagebar;

    public PageBean() {
    }

    public List getList() {
        return this.list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalrecord() {
        return this.totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalpage() {
        if (this.totalrecord == 0) {
            return 1;
        } else {
            if (this.totalrecord % this.pagesize == 0) {
                this.totalpage = this.totalrecord / this.pagesize;
            } else {
                this.totalpage = this.totalrecord / this.pagesize + 1;
            }

            return this.totalpage;
        }
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPreviouspage() {
        if (this.currentpage - 1 < 1) {
            this.previouspage = 1;
        } else {
            this.previouspage = this.currentpage - 1;
        }

        return this.previouspage;
    }

    public int getNextpage() {
        if (this.currentpage + 1 >= this.totalpage) {
            this.nextpage = this.totalpage;
        } else {
            this.nextpage = this.currentpage + 1;
        }

        return this.nextpage;
    }

    public int[] getPagebar() {
        int[] pagebar = null;
        int startpage;
        int endpage;
        //int[] pagebar;
        if (this.totalpage <= 10) {
            pagebar = new int[this.totalpage];
            startpage = 1;
            endpage = this.totalpage;
        } else {
            pagebar = new int[10];
            startpage = this.currentpage - 4;
            endpage = this.currentpage + 5;
            if (startpage < 1) {
                startpage = 1;
                endpage = 10;
            }

            if (endpage > this.totalpage) {
                endpage = this.totalpage;
                startpage = this.totalpage - 9;
            }
        }

        int index = 0;

        for(int i = startpage; i <= endpage; pagebar[index++] = i++) {
            ;
        }

        this.pagebar = pagebar;
        return this.pagebar;
    }
}
