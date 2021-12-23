package com.mapper;

import com.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface UserInfoMapper {
    /**查询用户信息*/
    UserInfo LookUserinfo(String userid);
    /**分页查询不同角色用户信息*/
    List<UserInfo> queryAllUserInfo(@Param("page") Integer page, @Param("count") Integer count, @Param("roleid") Integer roleid, @Param("userstatus") Integer userstatus);
    /**查看不同角色用户总数*/
    Integer queryAllUserCount(Integer roleid);
    /**添加用户信息*/
    Integer userReg(UserInfo userInfo);
    /**修改用户信息*/
    Integer UpdateUserInfo(UserInfo userInfo);
    /**查询用户的昵称和头像**/
    UserInfo queryPartInfo(String userid);
    /**分页查询用户信息**/
    List<UserInfo> queryLimitUserInfo(@Param("page") int page,@Param("count") int count);
    /**根据姓名查信息**/
    List<UserInfo> queryUserInfoByName(String keyWords);
    /**根据住址查信息**/
    List<UserInfo> queryUserInfoByAddress(String keyWords);
    /**根据学号查信息**/
    List<UserInfo> queryUserInfoByClassNumber(String keyWords);
    /**根据userid删除用户**/
    void deleteUserByUserid(String userid);
    /**根据userid查询用户**/
    UserInfo selectUserByUserid(String userid);
    /**根据userid更改用户**/
    void updateUserInfoById(UserInfo userInfo);
    /**后台插入用户
     * @return**/
    boolean addStu(UserInfo userInfo);
    /**根据班级查询用户并分页**/
    List<UserInfo> queryUserInfoByClassNumberLimit(String classNum, int page, int limit);
}
