package com.entity;

import lombok.Data;

@Data
public class Comment {

    private int id;
    private String content;
    private int parentId; // 父类id
    private int type;  //父类类型
    private UserInfo user; // 用户
    private String createTime;
    private String updateTime;
    private long likeCount;
    private int questionId;   //问题id
    private int replyCount;  //评论回复数

}
