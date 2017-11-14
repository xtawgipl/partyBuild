package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.StudyGardenBean;
import com.tydic.traffic.entity.TalkNotesBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TalknotesMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") TalkNotesBean record);

    TalkNotesBean selectByPrimaryKey(Long id);

    List<TalkNotesBean> selectByPage(Page<TalkNotesBean> page, @Param("policemanId") Long policemanId, @Param("flag") Integer flag);
}