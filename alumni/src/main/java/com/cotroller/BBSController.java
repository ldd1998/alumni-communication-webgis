package com.cotroller;

import com.entity.Comment;
import com.entity.PageDTO;
import com.entity.Question;
import com.entity.UserInfo;
import com.service.CommentService;
import com.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BBSController {
    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @GetMapping("/BBS")
    public String BBSIndex(Model model, PageDTO page, String search){
        List<Question> questions;
        List<Question> questionAllList = questionService.getAllQuestion(9999,search);
        if (page.getPage() == 0){
            //获取分页第一页文章
            questions = questionService.getAllQuestion(1,search);

            page.setQuestions(questionAllList);

            page.count();  //计算出有多少页
            page.quesListSize();
            page.showOrhide();
        }else{

            questions = questionService.getAllQuestion(page.getPage(),search);

            page.setQuestions(questionAllList);

            page.setQuestions(questionAllList);
            page.count();  //计算出有多少页
            page.quesListSize();
            page.showOrhide();
        }
        //System.out.println(commentServiceInte.queryReplyCountById(0,1));
        //循环获取各问题的评论数
//        for (Question question:questions) {
//            int count = commentServiceInte.queryReplyCountById(0,question.getId(),0);
//            question.setCommentCount(count);
//        }

        //把分页文章存入请求作用域
        model.addAttribute("QUESTION_LIST",questions);
        model.addAttribute("PAGE_LIST",page.getPages());
        //把搜索的存进请求作用域
        if (search != null && search != ""){
            model.addAttribute("SEARCH",search);
        }

        return "BBS/BBS";
    }

    /**
     * 跳转至 发布问题页面
     * @return
     */
    @RequestMapping("/BBS/publish")
    public String doPublish(Model model){
        model.addAttribute("QUESTION",null);
        return "BBS/publish";
    }

    /**
     * 发布问题 提交
     * @param question
     * @return
     */
    @RequestMapping("/addQuestion")
    public String addQuestion(Question question, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("USER");
        question.setUser(user);
        int count = questionService.addQuestionOrUpdate(question);

        //成功跳转至问题界面
        if (count > 0){
            return "redirect:/question/"+question.getId();

        }else{
            return "BBS/publish";
        }
    }

    /**
     * 编辑问题文章
     * @param id
     * @return
     */
    @GetMapping("publish/{id}")
    public String updateQuestion(@PathVariable("id") Integer id, Model model, HttpSession session){

        List<Question> questionList = questionService.getQuestionById(0,0,id);

        //从session获取用户对象
        UserInfo uesr = (UserInfo) session.getAttribute("USER");
        //session保存的用户id 必须和 文章关联的用户id 一致
        if (uesr.getId() != questionList.get(0).getUser().getId()){
            return "";
        }

        model.addAttribute("QUESTION",questionList.get(0));

        return "BBS/publish";
    }
    /**
     * 跳转至问题详情页面
     * @return
     */
    @RequestMapping("question")
    public String doQuestion(){

        return "redirect:/question/1";
    }

    /**
     * 获取问题详情 以及获取评论
     * @param id
     * @return
     */
    @RequestMapping("question/{id}")
    public String getQuestion(@PathVariable("id")Integer id, Model model){
        //增加阅读量
        questionService.incView(id);
        //获取文章详情
        List<Question> questions = questionService.getQuestionById(0,0,id);

        //获取评论
        List<Comment> comments = commentService.queryCommentByQuestionId(id,0,0);

        //获取相关问题
        List<Question> relatedQuestions = questionService.queryRelatedQuestion(questions.get(0));

        //把格式换回来
        String tag = questions.get(0).getTag();
        tag = tag.replace('|',',');
        questions.get(0).setTag(tag);

        model.addAttribute("RELATEDQUESTIONS",relatedQuestions);
        model.addAttribute("QUESTION",questions.get(0));
        model.addAttribute("COMMENTS",comments);

        for (Comment comment:comments) {
            System.out.println(comment.getLikeCount());
        }
        return "BBS/question";
    }

    /**
     * 判断session中的用户是否存在
     * @return
     */
    @RequestMapping(value = "getSessionUser",method = RequestMethod.POST)
    @ResponseBody
    public String getSessionUser(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("USER");

        if (user != null){

            return ""+1;
        }else{
            return ""+0;
        }
    }

    /**
     * 点赞评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "likeComm",method = RequestMethod.POST)
    @ResponseBody
    public String likeComment(Integer commentId,Integer likeOrOff,Integer likeCount,HttpSession session){

        UserInfo user = (UserInfo) session.getAttribute("USER");
        int count = 0;
        if (user != null){
            count = commentService.like(commentId,likeOrOff,likeCount);
        }

        return count+"";
    }

    /**
     * 创建评论
     * @param comment
     * @return
     */
    @RequestMapping("createComment")
    @ResponseBody
    public String createComment(Integer questionId,Comment comment, HttpSession session){
        UserInfo user = (UserInfo)session.getAttribute("USER");
        comment.setUser(user);
        int count = commentService.createComment(comment,questionId);

        return count+"";
    }

    /**
     * 获取二级评论
     * @return
     */
    @PostMapping("getSecondComment")
    @ResponseBody
    public List<Comment> querySecondComment(Integer parentId){
        //获取二级评论  type = 1 代表二级
        List<Comment> comments = commentService.queryCommentByQuestionId(parentId,0,1);

        return comments;
    }
}
