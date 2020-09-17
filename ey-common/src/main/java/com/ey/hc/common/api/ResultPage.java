package com.ey.hc.common.api;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页数据封装
 *
 * @param <T>
 */
public class ResultPage<T> {


    private Long total; //总记录数

    private Integer pages;//总页数

    private Integer pageNum; // 第几页

    private Integer pageSize; //每页条数

    private List<T> data; //数据结果集


    /**
     * 将PageHelper分页后的list转为分页信息
     * @param list
     * @param <T>
     * @return
     */
    public static <T> ResultPage<T> restPage(List<T> list) {
        ResultPage resultPage = new ResultPage();
        PageInfo pageInfo = new PageInfo();
        resultPage.setTotal(pageInfo.getTotal());
        resultPage.setPages(pageInfo.getPages());
        resultPage.setPageNum(pageInfo.getPageNum());
        resultPage.setPageSize(pageInfo.getPageSize());
        resultPage.setData(pageInfo.getList());
        return resultPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
