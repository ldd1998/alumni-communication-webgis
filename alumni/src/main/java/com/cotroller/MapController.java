package com.cotroller;

import com.entity.UserInfo;
import com.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MapController {

    @Autowired
    UserInfoMapper userInfoMapper;

    @GetMapping("/map")
    public String alumniMap(){
        return "map/map";
    }

    @GetMapping("/map/density")
    public String mdensity(){
        return "map/map-density2";
    }

    @GetMapping("/map/distribution")
    public String distribution(){
        return "map/map-distribution";
    }

    @GetMapping("/map/histogram")
    public String histogram(){
        return "map/map-histogram";
    }

    @GetMapping("/map/destination")
    public String destination(){
        return "map/map-destination";
    }

    @GetMapping("/map/find")
    public String find(){
        return "map/map-find";
    }

    @GetMapping("/map/findStuOnPoint")
    public String findStuOnPoint(Model model){
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoByAddress("山东省菏泽市郓城县");
        model.addAttribute("userInfos",userInfoList);
        return "map/map-findStuOnPoint";
    }

    @GetMapping("/map/findStuOnName")
    public String findStuOnName(Model model,String stuName){
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoByName(stuName);
        model.addAttribute("userInfos",userInfoList);
        return "map/map-findStuOnPoint";
    }

}
