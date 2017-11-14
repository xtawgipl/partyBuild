package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PartyKPIBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartyKpiMapper {

    int insert(@Param("partyKPI") PartyKPIBean partyKPI);

    /**   
    * @param policemanId 警员id
     *       stationType 岗位类别(1铁骑、2夜巡 、3整治、4事故、5内勤)
     *       startDate 统计开始日期 yyyy-MM-dd
     *       endDate 统计结束日志 yyyy-MM-dd
    * @author zhangjj
    * @Date 2017/8/23 16:44
    * @return
    * @exception 
    */
    Long statis(@Param("policemanId") Long policemanId, @Param("stationType") Integer stationType,
                @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<PartyKPIBean> listPoliceman(@Param("month") String month);

    List<PartyKPIBean> listStation(@Param("policemanId") Long policemanId, @Param("month") String month);

    PartyKPIBean sum(@Param("policemanId") Long policemanId, @Param("month") String month, @Param("stationType") Integer stationType);
}