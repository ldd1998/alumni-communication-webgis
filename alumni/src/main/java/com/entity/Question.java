package com.entity;

/**
 * 问题实体类
 */
public class Question {
    private int id;
    private String title;
    private String description; //内容 详情
    private String createTime;
    private String updateTime;
    private UserInfo user; //用户
    private int commentCount; //评论数
    private int viewCount; //浏览数
    private int likeCount; //点赞数
    private String tag;  //标签

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    private String classNum;  //标签



    public Question() {
    }

    public Question(int id, String title, String description, String createTime, String updateTime, UserInfo user, int commentCount, int viewCount, int likeCount, String tag) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.user = user;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.tag = tag;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


}
