package edu.study.ol.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class QueryPageParam implements Serializable {
    private Integer pageno;
    private Integer pagesize;
    private String queryText;
    private Boolean isAvalible;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    private Date createTime;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    private Date lastSystemTime;

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Boolean getAvalible() {
        return isAvalible;
    }

    public void setAvalible(Boolean avalible) {
        isAvalible = avalible;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastSystemTime() {
        return lastSystemTime;
    }

    public void setLastSystemTime(Date lastSystemTime) {
        this.lastSystemTime = lastSystemTime;
    }
}
