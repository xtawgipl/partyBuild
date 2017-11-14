package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.OrganizationBean;
import com.tydic.traffic.entity.PartyCultureBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartycultureMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") PartyCultureBean record);

    PartyCultureBean selectByPrimaryKey(Long id);

    List<PartyCultureBean> selectByPage(Page<PartyCultureBean> page);
}