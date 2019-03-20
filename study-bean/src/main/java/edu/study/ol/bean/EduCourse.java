package edu.study.ol.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EduCourse implements Serializable {
    @Id
    @Column
    private Integer courseId;
    @Column
    private String courseName;
    @Column
    private Integer isAvaliable;
    @Column
    private Integer subjectId;
    @Column
    private String subjectLink;
    @Column
    private Date addTime;
    @Column
    private BigDecimal sourcePrice;
    @Column
    private BigDecimal currentPrice;
    @Column
    private String title;
    @Column
    private Integer lessionNum;
    @Column
    private String logo;
    @Column
    private Date updateTime;
    @Column
    private Integer pageBuycount;
    @Column
    private Integer pageViewcount;
    @Column
    private Date endTime;
    @Column
    private Integer losetype;
    @Column
    private String loseTime;
    @Column
    private Integer sequence;
    @Column
    private BigDecimal courseGrossIncome;
    @Column
    private String context;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(Integer isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectLink() {
        return subjectLink;
    }

    public void setSubjectLink(String subjectLink) {
        this.subjectLink = subjectLink == null ? null : subjectLink.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getSourcePrice() {
        return sourcePrice;
    }

    public void setSourcePrice(BigDecimal sourcePrice) {
        this.sourcePrice = sourcePrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getLessionNum() {
        return lessionNum;
    }

    public void setLessionNum(Integer lessionNum) {
        this.lessionNum = lessionNum;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPageBuycount() {
        return pageBuycount;
    }

    public void setPageBuycount(Integer pageBuycount) {
        this.pageBuycount = pageBuycount;
    }

    public Integer getPageViewcount() {
        return pageViewcount;
    }

    public void setPageViewcount(Integer pageViewcount) {
        this.pageViewcount = pageViewcount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getLosetype() {
        return losetype;
    }

    public void setLosetype(Integer losetype) {
        this.losetype = losetype;
    }

    public String getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(String loseTime) {
        this.loseTime = loseTime == null ? null : loseTime.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getCourseGrossIncome() {
        return courseGrossIncome;
    }

    public void setCourseGrossIncome(BigDecimal courseGrossIncome) {
        this.courseGrossIncome = courseGrossIncome;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}