package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.UserInfoBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {

    int update(@Param("userInfo") UserInfoBean userInfo);

    UserInfoBean selectByPrimaryKey(Long id);

    List<UserInfoBean> selectByPage(Page<UserInfoBean> page);

    void insert(@Param("userInfo") UserInfoBean userInfoBean);

    List<UserInfoBean> findUserInfoByName(@Param("name") String name);
}