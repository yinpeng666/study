package edu.study.ol.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EduUser implements Serializable {
    @Id
    @Column
    private Integer userId;
    @Column
    private String mobile;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String userName;
    @Column
    private String showName;
    @Column
    private Boolean sex;
    @Column
    private Byte age;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    private Date createTime;
    @Column
    private Boolean isAvalible;
    @Column
    private String picImg;
    @Column
    private String bannerUrl;
    @Column
    private Integer msgNum;
    @Column
    private Integer sysMsgNum;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    private Date lastSystemTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }
    /*DateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
    Date date = null;
        try {
        date = simpleDateFormat.parse(createTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }*/

    public Boolean getIsAvalible() {
        return isAvalible;
    }

    public void setIsAvalible(Boolean isAvalible) {
        this.isAvalible = isAvalible;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public Integer getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(Integer msgNum) {
        this.msgNum = msgNum;
    }

    public Integer getSysMsgNum() {
        return sysMsgNum;
    }

    public void setSysMsgNum(Integer sysMsgNum) {
        this.sysMsgNum = sysMsgNum;
    }

    public Date getLastSystemTime() {
        return lastSystemTime;
    }

    public void setLastSystemTime(Date lastSystemTime) {

        this.lastSystemTime = lastSystemTime;
    }

    @Override
    public String toString() {
        return "EduUser{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", showName='" + showName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", createTime=" + createTime +
                ", isAvalible=" + isAvalible +
                ", picImg='" + picImg + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", msgNum=" + msgNum +
                ", sysMsgNum=" + sysMsgNum +
                ", lastSystemTime=" + lastSystemTime +
                '}';
    }
}