package com.service;


import com.entity.Comment;
import com.mapper.CommentMapper;
import com.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    //@Autowired
//    private NotifictionMapper notifictionMapper;   //通知数据库映射接口
    /**
     * 添加评论
     * @param comment
     * @return
     */

    @Transactional   //添加事务
    public int createComment(Comment comment, Integer questionId) {
        //增加评论
        int count = commentMapper.createComment(comment);
        //增加评论成功才 通知
//        if (count > 0){
//            Notifiction notifiction = new Notifiction();
//
//            //通知人
//            notifiction.setNotifier(comment.getUser());
//            // 0 代表消息未读
//            notifiction.setStatus(0);
//            //评论
//            if (comment.getType() == 0){
//                //查出问题接收人
//                List<Question> questions = questionMapper.getQuestionById(0,0,questionId);
//
//                notifiction.setReceiver(questions.get(0).getUser());
//                notifiction.setOuter(questions.get(0));
//                notifiction.setType(0);     // 0 代表评论
//
//                //增加评论数
//                questionMapper.updateCommentCount(questionId);
//            //回复
//            }else{
//                //接收人评论
//                Comment reply = commentMapper.queryReplyByCommentId(comment.getParentId());
//                //获取回复接收人
//                notifiction.setReceiver(reply.getUser());
//                notifiction.setOuter(reply);
//                notifiction.setType(1);  // 1 代表回复
//
//            }
//            //创建通知
//            notifictionMapper.addNotifiction(notifiction);


//        }


        return count;
    }

    /**
     * 获取评论
     * @param questionId
     * @return
     */

    public List<Comment> queryCommentByQuestionId(Integer questionId,Integer page,Integer type) {
        List<Comment> comments = commentMapper.queryCommentByQuestionId(questionId,page,type);
        //把 评论回复数 赋值给评论对象
        for (Comment comment:comments) {
            int count = commentMapper.queryReplyCountById(comment.getId(),questionId,1);
            System.out.println(count);
            comment.setReplyCount(count);
        }

        return comments;
    }

    /**
     * 获取评论回复数
     * @param questionId
     * @return
     */

    public Integer queryReplyCountById(Integer commentId,Integer questionId,Integer type) {

        return commentMapper.queryReplyCountById(commentId,questionId,type);
    }
    /**
     * 点赞评论
     * @param commentId
     * @return
     */

    public Integer like(Integer commentId,Integer likeOrOff,Integer likeCount) {
        //点赞数等于0 不可减少
        if (likeOrOff == 0 && likeCount == 0){
            return 0;
        }else{

            return commentMapper.like(commentId,likeOrOff);
        }
    }


}
