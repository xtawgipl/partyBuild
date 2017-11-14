package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.SpecialLearningBean;
import com.tydic.traffic.entity.StudyGardenBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudygardenMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") StudyGardenBean record);

    StudyGardenBean selectByPrimaryKey(Long id);

    List<StudyGardenBean> selectByPage(Page<StudyGardenBean> page);
}