package edu.study.ol.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSubject implements Serializable,Comparable<SysSubject>{
    @Id
    @Column
    private Integer subjectId;
    @Column
    private String subjectName;
    @Column
    private Boolean status;
    @Column
    private Date createTime;
    @Column
    private Integer parentId;
    @Column
    private Integer sort;
    @Transient
    private List<SysSubject> childList = new ArrayList<>();

    public List<SysSubject> getChildList() {
        return childList;
    }

    public void setChildList(List<SysSubject> childList) {
        this.childList = childList;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(SysSubject o) {
        int i = this.getSort() - o.getSort();//先按照分数排序
        if (i > 0){
            i = 1;
        }else if (i < 0){
            i = -1;
        }
        return i;


    }
}