package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.PartyKpiStatisBean;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/23.
 */
public interface IPartyKpiStatisService {
    void sum(String month);

    void top(String month);

    /**   
    * @param （各项指标在全支队排名） 工作时长：巡逻里程：查处违法 处理警情
    * @author zhangjj  
    * @Date 2017/8/24 11:55
    * @return 
    * @exception 
    */
    List<PartyKpiStatisBean> kpiTopSingle(Long policemanId, String month, Integer stationType);

    List<PartyKpiStatisBean> stationList(Long policemanId, String month);

    List<PartyKpiStatisBean> kpiTopSquadronList(Long policemanId, String month, Integer stationType);

    List<PartyKpiStatisBean> kpiTopCropsList(Long policemanId, String month, Integer stationType);

    List<PartyKpiStatisBean> kpiTopDivisionList(Long policemanId, String month, Integer stationType);
}
