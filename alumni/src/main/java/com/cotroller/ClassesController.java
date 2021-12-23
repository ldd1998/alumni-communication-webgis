package com.cotroller;

import com.entity.Classes;
import com.entity.Question;
import com.entity.UserInfo;
import com.mapper.ClassesMapper;
import com.mapper.QuestionMapper;
import com.mapper.UserInfoMapper;
import com.service.QuestionService;
import com.service.UserInfoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.util.StatusCode;
import com.vo.ResultVo;
import com.vo.TwoUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class ClassesController {

    @Autowired
    ClassesMapper classesMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    QuestionMapper questionMapper;



    @GetMapping("/classes")
    public String classes(Model model,int page,int limit){

        List<Classes> classesList = classesMapper.queryClassesByPage((page-1)*limit,limit);
        model.addAttribute("classList",classesList);
        model.addAttribute("page",page);
        model.addAttribute("limit",limit);
        return "classes/classes";
    }
    @GetMapping("/classes/queryClassesByClassNum")
    public String classes(Model model,String classNum){

        List<Classes> classesList = classesMapper.queryClassesByClassNum(classNum);
        model.addAttribute("classList",classesList);
//        model.addAttribute("page",page);
//        model.addAttribute("limit",limit);
        return "classes/classes";
    }

    @GetMapping("classes/classDetail")
    public String classDetail(int classId,Model model,String classNum,int page,int limit){


        /**班级动态**/
        Classes classes = classesMapper.queryClassByClassId(classId);
        model.addAttribute("classes",classes);
        List<Question> questionList = questionMapper.queryQuestionByClassNum(classes.getClassNum());
        model.addAttribute("questionList",questionList);

        /**通讯录**/
        List<UserInfo> userInfos0 = userInfoService.queryUserInfoByClassNumberLimit(classNum,(page-1)*limit,limit);
        //List<UserInfo> userInfos1 = userInfoService.queryUserInfoByClassNumberLimit(classNum,(page-1)*limit+limit/2,limit/2);
        List<TwoUserInfo> twoUserInfos = new ArrayList<>();

        if(userInfos0.size()%2!=0){
            userInfos0.remove(userInfos0.size()-1);
        }

        for(int i = 0;i < userInfos0.size();i+=2){
            TwoUserInfo twoUserInfo = new TwoUserInfo(userInfos0.get(i),userInfos0.get(i+1));
            twoUserInfos.add(twoUserInfo);
        }
        if(page>1){
            model.addAttribute("tab3","1");
        }

        model.addAttribute("twoUserInfos",twoUserInfos);
        model.addAttribute("classId",classId);
        model.addAttribute("classNum",classNum);
        model.addAttribute("page",page);
        return "classes/class-detail";
    }



    @ResponseBody
    @GetMapping("/class/addFriends")
    public void addFriends(Model model, HttpSession session,String fuserid){
        String userid = (String) session.getAttribute("userid");
        classesMapper.addFriends(userid,fuserid);
    }



}
