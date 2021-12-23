package com.service;


import com.entity.Question;
import com.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;


    public List<Question> getAllQuestion(Integer page, String search) {
        //转成数据库查询的格式
        if (search != null && search != ""){
            search = search.replace(' ','|');
        }

        if (page != 9999){
            page = (page -1 )*10;
        }

        return questionMapper.getAllQuestion(page,search);
    }

    /**
     * 发布问题
     * @param question
     * @return
     */

    public int addQuestionOrUpdate(Question question) {
        int count = 0;
        if (question.getId() != 0){
            count = questionMapper.updateQuestion(question);
        }else{
            count = questionMapper.addQuestion(question);
        }

        return count;
    }
    /**
     * 根据id获取问题列表
     * @param userId
     * @param page
     * @return
     */
    public List<Question> getQuestionById(Integer userId, Integer page,Integer questionId) {
        if (page != 0){
            page = (page -1 )*10;
        }

        return questionMapper.getQuestionById(userId,page,questionId);
    }

    /**
     * 增加阅读量
     * @param id
     * @return
     */

    public int incView(Integer id) {

        return questionMapper.incView(id);
    }

    /**
     * 增加评论数
     * @param id
     * @return
     */

    public int updateCommentCount(Integer id) {
        return questionMapper.updateCommentCount(id);
    }

    /**
     * 查询相关问题
     * @param question
     * @return
     */
    public List<Question> queryRelatedQuestion(Question question) {
        //标签替换成mysql 需要的正则表达式的格式
        String tag = question.getTag();
        tag = tag.replace(',','|');
        question.setTag(tag);

        return questionMapper.queryRelatedQuestion(question);
    }


}
