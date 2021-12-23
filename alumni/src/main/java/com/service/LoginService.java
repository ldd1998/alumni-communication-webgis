package com.service;

import com.entity.Login;
import com.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    /**注册*/
    public Integer loginAdd(Login login){
        return loginMapper.loginAdd(login);
    }
    /**登录及判断用户是否存在*/
    public Login userLogin(Login login){
        return loginMapper.userLogin(login);
    }
    /**修改登录信息*/
    public Integer updateLogin(Login login){
        return loginMapper.updateLogin(login);
    }
}
