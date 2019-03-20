package edu.study.ol.bean;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Accessors(chain = true)
@Getter
@Setter
public class SysFunction implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer functionId;

    @Column
    private Integer parentId;

    @Column
    private String functionName;

    @Column
    private String functionUrl;

    @Column
    private Boolean functionType;

    @Column
    private Date createTime;

    @Column
    private Integer sort;

    @Column
    private String imageUrl;

    @Transient
    private List<SysFunction> childrenList = new ArrayList<>();

    /*public List<SysFunction> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<SysFunction> childrenList) {
        this.childrenList = childrenList;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public Boolean getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Boolean functionType) {
        this.functionType = functionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }*/
}