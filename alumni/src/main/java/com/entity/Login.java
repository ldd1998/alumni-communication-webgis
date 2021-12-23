package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Data//注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)//链式写法,这个注解是来至于lombok里面的 只需要在实体类加上就可以开启链式编程了
public class Login {
    //private static final long serialVersionUID = 1L;

    /**
     * 登录id
     */
    private String id;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 角色id 1普通用户 2管理员 3超级管理员
     */
    private Integer roleid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobilephone;
    /**
     * 1正常 0封号
     */
    private Integer userstatus;
    /**
     * 验证码
     * */
    private String vercode;
}
