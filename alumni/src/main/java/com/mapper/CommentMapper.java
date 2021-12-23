package com.mapper;


import com.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    int createComment(Comment comment);

    /**
     * 根据问题 id获取评论
     * @param questionId
     * @return
     */
    List<Comment> queryCommentByQuestionId(@Param("questionId")Integer questionId,
                                           @Param("page")Integer page,
                                           @Param("type") Integer type);

    /**
     * 获取评论的回复数
     * @param commentId
     * @return
     */
    Integer queryReplyCountById(@Param("commentId")Integer commentId,@Param("questionId")Integer questionId,@Param("type")Integer type);

    /**
     * 点赞评论
     * @param commentId
     * @return
     */
    Integer like(@Param("id")Integer commentId,@Param("likeOrOff")Integer likeOrOff);

    /**
     * 根据回复id 查询 回复评论
     * @param commentId
     * @return
     */
    Comment queryReplyByCommentId(@Param("id") Integer commentId);
}
