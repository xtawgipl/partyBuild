package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.PartyKpiStatisBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PartyKpiStatisMapper {

    int insert(@Param("record") PartyKpiStatisBean record);

    PartyKpiStatisBean select(@Param("policemanId") Long policemanId, @Param("month") String month);

    int update(@Param("record") PartyKpiStatisBean record);

    List<PartyKpiStatisBean> selectByMonthBmbhs(@Param("month") String month, @Param("bmbhs") List<String> bmbhs, @Param("stationType") Integer stationType);

    List<PartyKpiStatisBean> kpiTopSingle(@Param("policemanId") Long policemanId, @Param("month") String month, @Param("stationType") Integer stationType);

    List<PartyKpiStatisBean> stationList(@Param("policemanId") Long policemanId, @Param("month") String month);

    List<PartyKpiStatisBean> kpiTopSquadronList(@Param("policemanId") Long policemanId, @Param("month") String month, @Param("stationType") Integer stationType);

    List<PartyKpiStatisBean> kpiTopCropsList(@Param("policemanId") Long policemanId, @Param("month") String month, @Param("stationType") Integer stationType);

    List<PartyKpiStatisBean> kpiTopDivisionList(@Param("policemanId") Long policemanId, @Param("month") String month, @Param("stationType") Integer stationType);
}