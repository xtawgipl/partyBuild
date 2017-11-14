package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PartyModelBean;
import com.tydic.traffic.entity.SpecialLearningBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpeciallearningMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") SpecialLearningBean record);

    SpecialLearningBean selectByPrimaryKey(Long id);

    List<SpecialLearningBean> selectByPage(Page<SpecialLearningBean> page, @Param("policemanId") Long policemanId);
}