package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.UserInfoBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.UserInfoMapper;
import com.tydic.traffic.party.build.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息
 *
 * @author zhangjj
 * @create 2017-08-22 21:32
 **/
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource(name = "userInfoMapper")
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUserInfo(UserInfoBean userInfoBean) {
        userInfoMapper.insert(userInfoBean);
    }

    @Override
    public List<UserInfoBean> findUserInfoByName(String name) {
        return userInfoMapper.findUserInfoByName(name);
    }

    @Override
    public void update(UserInfoBean userInfo) {
        userInfoMapper.update(userInfo);
    }
}
