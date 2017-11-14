package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PartyCultureBean;
import com.tydic.traffic.entity.PartyFeeBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartyfeeMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") PartyFeeBean record);

    PartyFeeBean selectByPrimaryKey(Long id);

    List<PartyFeeBean> selectByPage(Page<PartyFeeBean> page, @Param("policemanId") Long policemanId);
}