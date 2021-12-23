package com.service;

import com.entity.UserInfo;
import com.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *

 */
@Service
@Transactional
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**查询用户信息*/
    public UserInfo LookUserinfo(String userid) {
        return userInfoMapper.LookUserinfo(userid);
    }
    /**分页查询不同角色用户信息*/
    public List<UserInfo> queryAllUserInfo(Integer page,Integer count,Integer roleid,Integer userstatus){
        return userInfoMapper.queryAllUserInfo(page,count,roleid,userstatus);
    }
    /**查看不同角色用户总数*/
    public Integer queryAllUserCount(Integer roleid){
        return userInfoMapper.queryAllUserCount(roleid);
    }
    /**添加用户信息*/
    public Integer userReg(UserInfo userInfo){
        return userInfoMapper.userReg(userInfo);
    }
    /**修改用户信息*/
    public Integer UpdateUserInfo(UserInfo userInfo){
        return userInfoMapper.UpdateUserInfo(userInfo);
    }
    /**查询用户的昵称和头像**/
    public UserInfo queryPartInfo(String userid){
        return userInfoMapper.queryPartInfo(userid);
    }

    public List<UserInfo> queryLimitUserInfo(int page, int count) {
        return userInfoMapper.queryLimitUserInfo(page,count);
    }

    public List<UserInfo> queryUserInfoByName(String keyWords) {
        return userInfoMapper.queryUserInfoByName(keyWords);
    }

    public List<UserInfo> queryUserInfoByAddress(String keyWords) {
        return userInfoMapper.queryUserInfoByAddress(keyWords);
    }

    public List<UserInfo> queryUserInfoByClassNumber(String keyWords) {
        return userInfoMapper.queryUserInfoByClassNumber(keyWords);
    }

    public void deleteUserByUserid(String userid) {
        userInfoMapper.deleteUserByUserid(userid);
    }

    public UserInfo selectUserByUserid(String userid) {
        return userInfoMapper.selectUserByUserid(userid);
    }
    public void updateUserInfoById(UserInfo userInfo) {
        userInfoMapper.updateUserInfoById(userInfo);
    }

    public boolean addStu(UserInfo userInfo) {
      return userInfoMapper.addStu(userInfo);
    }

    public List<UserInfo> queryUserInfoByClassNumberLimit(String classNum,int page,int limit) {
        return userInfoMapper.queryUserInfoByClassNumberLimit(classNum,page,limit);
    }
}
