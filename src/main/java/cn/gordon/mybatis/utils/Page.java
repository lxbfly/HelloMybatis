/**
 * Page.java   2014年11月23日 上午10:13:00 by Xuebing 
 *
 * Copyright (c) 2000 - 2014 gordon.Li. All rights reserved.
 * 
 */
package cn.gordon.mybatis.utils;

import java.util.List;

public class Page<T> {

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalPage;

    private Integer totalRecord;

    private List<T> data;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        if (this.totalRecord % this.pageSize == 0) {
            totalPage = this.totalRecord / this.pageSize;
        } else {
            totalPage = this.totalRecord / this.pageSize + 1;
        }
        return totalPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
