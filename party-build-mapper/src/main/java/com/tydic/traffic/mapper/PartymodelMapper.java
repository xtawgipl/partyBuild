package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PartyFeeBean;
import com.tydic.traffic.entity.PartyModelBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartymodelMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") PartyModelBean record);

    PartyModelBean selectByPrimaryKey(Long id);

    List<PartyModelBean> selectByPage(Page<PartyModelBean> page);
}