package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.DailyLearningBean;
import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailylearningMapper {

    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") DailyLearningBean record);

    DailyLearningBean selectByPrimaryKey(Long id);

    List<DailyLearningBean> selectByPage(Page<DailyLearningBean> page, @Param("policemanId") Long policemanId);

}