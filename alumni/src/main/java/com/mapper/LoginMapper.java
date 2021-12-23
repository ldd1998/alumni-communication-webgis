package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.Login;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface LoginMapper extends BaseMapper<Login> {
    /**注册*/
    Integer loginAdd(Login login);
    /**登录及判断用户是否存在*/
    Login userLogin(Login login);
    /**修改登录信息*/
    Integer updateLogin(Login login);

    Login selectAllLogin();
}