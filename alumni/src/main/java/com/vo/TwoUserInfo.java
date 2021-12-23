package com.vo;

import com.entity.UserInfo;

public class TwoUserInfo {
    private UserInfo userInfo1;
    private UserInfo userInfo2;

    public TwoUserInfo(UserInfo userInfo1, UserInfo userInfo2) {
        this.userInfo1 = userInfo1;
        this.userInfo2 = userInfo2;
    }

    public UserInfo getUserInfo1() {
        return userInfo1;
    }

    public void setUserInfo1(UserInfo userInfo1) {
        this.userInfo1 = userInfo1;
    }

    public UserInfo getUserInfo2() {
        return userInfo2;
    }

    public void setUserInfo2(UserInfo userInfo2) {
        this.userInfo2 = userInfo2;
    }
}
