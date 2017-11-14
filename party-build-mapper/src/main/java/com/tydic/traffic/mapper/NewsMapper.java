package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.DailyLearningBean;
import com.tydic.traffic.entity.NewBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") NewBean record);

    NewBean selectByPrimaryKey(Long id);

    List<NewBean> selectByPage(Page<NewBean> page);
}