package com.mapper;


import com.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    List<Question> getAllQuestion(@Param("page")Integer page, @Param("search")String search);
    /**
     * 添加问题
     * @param question
     * @return
     */
    int addQuestion(Question question);

    /**
     * 根据id获取问题列表
     * @param userId
     * @param page
     * @return
     */
    List<Question> getQuestionById(@Param("userId")Integer userId,@Param("page") Integer page,@Param("questionId")Integer questionId);

    /**
     * 修改问题文章
     * @param question
     * @return
     */
    int updateQuestion(Question question);
    /**
     * 增加阅读量
     * @param id
     * @return
     */
    int incView(@Param("id") Integer id);

    /**
     * 增加评论数
     * @param id
     * @return
     */
    int updateCommentCount(@Param("id") Integer id);
    /**
     * 查询相关问题
     * @param question
     * @return
     */
    List<Question> queryRelatedQuestion(Question question);

    List<Question> queryQuestionByClassNum(String classNum);
}
