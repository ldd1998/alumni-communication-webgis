package com.cotroller.admin;


import com.entity.UserInfo;
import com.service.TbStuService;
import com.service.UserInfoService;
import com.util.StatusCode;
import com.vo.ResultVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 */
@Controller
public class TbStuController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    TbStuService stuService;

    @Autowired
    UserInfoService userInfoService;

//    @Autowired
//    ITbUserRoleService userRoleService;


    /**
     * 管理校友列表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/admin/studentList")
    public String getAllStu(Model m, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit){
//        QueryWrapper<QueryObj> wrapper = new QueryWrapper<>();
//        wrapper.setEntity(queryObj);
//        IPage<UserInfo> stu = stuService.getAllStu(page,limit,wrapper);
//        UserInfo userInfo = userInfoService.queryPartInfo("1582184795951594874");

        List<UserInfo> stu = userInfoService.queryLimitUserInfo((page-1) * limit,limit);
        //int count = userInfoService.queryAllUserCount(1);
        //System.out.println(count);
        //List<UserInfo> stu = userInfoService.queryAllUserInfo(page,limit,1,1);
        m.addAttribute("stuPage",stu);
        m.addAttribute("page",page);

        //m.addAttribute("count",100);
        return "admin/student/studentList";
    }



    /**
     * 条件查询校友
     * @return
     */
    @RequestMapping("/admin/getStudentByType")
    public String getStudentByType(Model m, String queryType, String keyword){

        m.addAttribute("queryType",queryType);
        m.addAttribute("keyword",keyword);

        if(queryType.equals("1")){
            List<UserInfo> stu = userInfoService.queryUserInfoByName(keyword);
            m.addAttribute("stuPage",stu);
            return "admin/student/studentList";
        }else if(queryType.equals("3")){
            List<UserInfo> stu = userInfoService.queryUserInfoByAddress(keyword);
            m.addAttribute("stuPage",stu);
            return "admin/student/studentList";

        }else if(queryType.equals("2")){
            List<UserInfo> stu = userInfoService.queryUserInfoByClassNumber(keyword);
            m.addAttribute("stuPage",stu);
            return "admin/student/studentList";

        }else {
            return "admin/student/studentList";
        }

    }


    /**
     * 通过userid查询校友
     * @param userid
     * @return
     */
    @RequestMapping("/admin/selectUserByUserid")
    public String selectUserByUserid(String userid,Model model){
        UserInfo stu = userInfoService.selectUserByUserid(userid);
        model.addAttribute("stu",stu);
        return "admin/student/updateStudent";
    }


    /**
     * 通过userid删除
     * @param userid
     * @return
     */
    @RequestMapping("/admin/deleteUserByUserid")
    public String deleteUserByUserid(String userid){
        userInfoService.deleteUserByUserid(userid);
        return"redirect:/admin/studentList";
    }

    /**
     * 通过userid修改所有信息
     * @param
     * @return
     */
    @RequestMapping("/admin/updateUserInfoById")
    @ResponseBody
    public ResultVo updateUserInfoById(@RequestBody UserInfo userInfo){
        userInfoService.updateUserInfoById(userInfo);
        //return"redirect:/admin/studentList";
        return new ResultVo(true, StatusCode.OK, "修改成功");
    }



    /**
     * 添加校友信息
     * @param
     * @return
     */
    @RequestMapping("/admin/addStu")
    @ResponseBody
    public ResultVo addStu(@RequestBody UserInfo userInfo){
        boolean f = userInfoService.addStu(userInfo);
        if(f){
            return new ResultVo(true, StatusCode.OK, "添加成功");
        }else {
            return new ResultVo(false, StatusCode.ERROR, "添加失败");
        }
    }

    /**
     * 添加校友信息的模板
     * @param
     * @return
     */
    @RequestMapping("/admin/addStuTemplate")
    public String addStuTemplate(){
       return "admin/student/addStuTemplate";
    }

    /**
     * 保存校友信息
     * @param m
     * @param tbStu
     * @return
     */
    @RequestMapping("/SaveStu")
    public String SaveStu(Model m, UserInfo tbStu, MultipartFile file){
        logger.info("文件上传");
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        try {
            if (!"".equals(filename.trim())) {
                File newFile = new File(filename);
                FileOutputStream os = new FileOutputStream(newFile);
                os.write(file.getBytes());
                os.close();
                file.transferTo(newFile);
                // 上传到OSS//暂时不做
                //String uploadUrl = AliyunOSSUtil.upLoad(newFile);
                newFile.delete();
                //tbStu.setStuImg(uploadUrl);
            }
            else {
                //tbStu.setStuImg("https://lgyfile.oss-cn-beijing.aliyuncs.com/xiaoyou/2020-01-29/20191230164912.jpg");
            }
            stuService.save(tbStu);
//            String userId = tbStu.getUserid();
//            TbUserRole userRole = new TbUserRole();
//            userRole.setUserId(userId);
//            if(userId==1){
//                userRole.setRoleId(1);
//            }else {
//                userRole.setRoleId(2);
//            }
//            userRoleService.save(userRole);//保存用户权限暂时不写
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/stu/getAllStu";
    }

    /**
     * 多选删除
     * @param userIds
     * @return
     */
    @RequestMapping("/delStu")
    public String delStu(@RequestParam("userId")List<String> userIds){
        stuService.removeByIds(userIds);
        return "redirect:/stu/getAllStu";
    }

    /**
     * 根据Id删除
     * @param userId
     * @return
     */
    @RequestMapping("/delStuById")
    public String delStuById(String userId){
        List<String> arrList = new ArrayList<>();
        arrList.add(userId);
        stuService.removeByIds(arrList);
        return "redirect:/stu/getAllStu";
    }



}
