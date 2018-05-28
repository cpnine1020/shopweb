package com.xiangxiaole.www.model;

import java.io.Serializable;
import java.util.Date;

import com.xiangxiaole.util.tool.Formatter;

public class News implements Serializable {
    private Integer id;

    private Date updateTime;

    private Integer parentId;

    private String type1;

    private String type2;

    private String sourceSite;

    private String title;

    private String url;

    private String author;

    private Date publishTime;

    private Integer readNum;

    private Integer commentNum;

    private Date lastCommmentTime;

    private String newsStatus;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpdateTime() {
    	return Formatter.DateToStr(updateTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getSourceSite() {
        return sourceSite;
    }

    public void setSourceSite(String sourceSite) {
        this.sourceSite = sourceSite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
    	return Formatter.DateToStr(publishTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getLastCommmentTime() {
    	return Formatter.DateToStr(lastCommmentTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setLastCommmentTime(Date lastCommmentTime) {
        this.lastCommmentTime = lastCommmentTime;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}