package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PolicemanMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") PolicemanBean record);

    PolicemanBean selectByPrimaryKey(Long id);

    List<PolicemanBean> selectByPage(Page<PolicemanBean> page);

    List<PolicemanBean> findByName(@Param("name") String name);

    PolicemanBean selectByPoliceNumber(@Param("policeNumber") String policeNumber);
}