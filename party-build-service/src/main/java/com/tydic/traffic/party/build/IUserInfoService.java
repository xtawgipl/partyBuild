package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.UserInfoBean;

import java.util.List;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IUserInfoService {
    void addUserInfo(UserInfoBean userInfoBean);

    List<UserInfoBean> findUserInfoByName(String name);

    void update(UserInfoBean userInfo);
}
