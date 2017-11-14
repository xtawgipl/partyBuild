package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.OrganizationBean;
import com.tydic.traffic.entity.PartyKPIBean;
import com.tydic.traffic.entity.PartyKpiStatisBean;
import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.mapper.OrganizationMapper;
import com.tydic.traffic.mapper.PartyKpiMapper;
import com.tydic.traffic.mapper.PartyKpiStatisMapper;
import com.tydic.traffic.mapper.PolicemanMapper;
import com.tydic.traffic.party.build.IPartyKpiStatisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * kpi统计
 *
 * @author zhangjj
 * @create 2017-08-23 23:22
 **/
@Service("partyKpiStatisService")
public class PartyKpiStatisServiceImpl implements IPartyKpiStatisService {
    private Logger logger = LoggerFactory.getLogger(PartyKpiStatisServiceImpl.class);

    @Resource(name="partyKpiStatisMapper")
    private PartyKpiStatisMapper partyKpiStatisMapper;

    @Resource(name="partyKpiMapper")
    private PartyKpiMapper partyKpiMapper;

    @Resource(name="policemanMapper")
    private PolicemanMapper policemanMapper;

    @Resource(name="organizationMapper")
    private OrganizationMapper organizationMapper;

    @Override
    public void sum(String month){
        List<PartyKPIBean> policemanList = partyKpiMapper.listPoliceman(month);
        for(PartyKPIBean police : policemanList){
            List<PartyKPIBean> stationList = partyKpiMapper.listStation(police.getPolicemanId(), month);
            for(PartyKPIBean station : stationList){
                PartyKPIBean partyKPIBean = partyKpiMapper.sum(police.getPolicemanId(), month, station.getStationType());
                PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisMapper.select(police.getPolicemanId(), month);
                if(partyKpiStatisBean == null){
                    partyKpiStatisBean = new PartyKpiStatisBean();
                    partyKpiStatisBean.setPolicemanId(police.getPolicemanId());
                    partyKpiStatisBean.setStationType(station.getStationType());
                    partyKpiStatisBean.setMonth(month);
                    partyKpiStatisBean.setAlarmAmountSum(partyKPIBean.getAlarmAmount());
                    partyKpiStatisBean.setLawAmountSum(partyKPIBean.getLawAmount());
                    partyKpiStatisBean.setMileageSum(partyKPIBean.getMileage());
                    partyKpiStatisBean.setWorkingTimeSum(partyKPIBean.getWorkingTime());
                    partyKpiStatisMapper.insert(partyKpiStatisBean);
                }else{
                    partyKpiStatisBean.setAlarmAmountSum(partyKPIBean.getAlarmAmount());
                    partyKpiStatisBean.setLawAmountSum(partyKPIBean.getLawAmount());
                    partyKpiStatisBean.setMileageSum(partyKPIBean.getMileage());
                    partyKpiStatisBean.setWorkingTimeSum(partyKPIBean.getWorkingTime());
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
            }
        }
    }

    @Override
    public void top(String month) {
        List<String> orgNoList = new ArrayList<>();//统计过的部门
        List<PartyKPIBean> policemanList = partyKpiMapper.listPoliceman(month);
        for(PartyKPIBean police : policemanList){
            List<PartyKPIBean> stationList = partyKpiMapper.listStation(police.getPolicemanId(), month);
            for(PartyKPIBean station : stationList){
                PolicemanBean policemanBean = policemanMapper.selectByPrimaryKey(police.getPolicemanId());
                OrganizationBean organizationBean = policemanBean.getOrganizationBean();
                if(orgNoList.contains(organizationBean.getBmbh())){
                    continue;
                }
                List<String> bmbhs = new ArrayList<>();
                List<PartyKpiStatisBean> partyKpiStatisList = null;
                if(organizationBean.getSsjb().equals("3")){//中队
                    if(!orgNoList.contains(organizationBean.getBmbh())){
                        bmbhs.add(organizationBean.getBmbh());
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, bmbhs, station.getStationType());
                        sort(partyKpiStatisList, 3);//中队中 排序 排名
                        orgNoList.add(organizationBean.getBmbh());
                    }


                    if(!orgNoList.contains(organizationBean.getSjbm())){
                        List<OrganizationBean> orgList = organizationMapper.listOrg(organizationBean.getSjbm());//获取中队及大队
                        bmbhs.clear();
                        for(OrganizationBean org : orgList){
                            bmbhs.add(org.getBmbh());
                        }
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, bmbhs, station.getStationType());
                        sort(partyKpiStatisList, 2);//大队中及以下中队所有人  排序 排名
                        orgNoList.add(organizationBean.getSjbm());
                    }

                    if(!orgNoList.contains("division_bmbh")){
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, null, station.getStationType());
                        sort(partyKpiStatisList, 1);//整个支队中  排序 排名
                        orgNoList.add("division_bmbh");//division_bmbh 支队代号
                    }

                } else if(organizationBean.getSsjb().equals("2")) {//大队
                    if(!orgNoList.contains(organizationBean.getBmbh())){
                        List<OrganizationBean> orgList = organizationMapper.listOrg(organizationBean.getBmbh());//获取中队及大队
                        for(OrganizationBean org : orgList){
                            bmbhs.add(org.getBmbh());
                        }
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, bmbhs, station.getStationType());
                        sort(partyKpiStatisList, 2);//大队中及以下中队所有人  排序 排名
                        orgNoList.add(organizationBean.getBmbh());
                    }

                    if(!orgNoList.contains("division_bmbh")){
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, null, station.getStationType());
                        sort(partyKpiStatisList, 1);//整个支队中  排序 排名
                        orgNoList.add("division_bmbh");//division_bmbh 支队代号
                    }
                }else if(organizationBean.getSsjb().equals("1")) {//支队
                    if(!orgNoList.contains("division_bmbh")){
                        partyKpiStatisList = partyKpiStatisMapper.selectByMonthBmbhs(month, null, station.getStationType());
                        sort(partyKpiStatisList, 1);//整个支队中  排序 排名
                        orgNoList.add("division_bmbh");//division_bmbh 支队代号
                    }
                }
            }
        }
    }

    @Override
    public List<PartyKpiStatisBean> kpiTopSingle(Long policemanId, String month, Integer stationType) {

        return partyKpiStatisMapper.kpiTopSingle(policemanId, month, stationType);
    }

    @Override
    public List<PartyKpiStatisBean> stationList(Long policemanId, String month) {
        return partyKpiStatisMapper.stationList(policemanId, month);
    }

    @Override
    public List<PartyKpiStatisBean> kpiTopSquadronList(Long policemanId, String month, Integer stationType) {
        return partyKpiStatisMapper.kpiTopSquadronList(policemanId, month, stationType);
    }

    @Override
    public List<PartyKpiStatisBean> kpiTopCropsList(Long policemanId, String month, Integer stationType) {
        return partyKpiStatisMapper.kpiTopCropsList(policemanId, month, stationType);
    }

    @Override
    public List<PartyKpiStatisBean> kpiTopDivisionList(Long policemanId, String month, Integer stationType) {
        return partyKpiStatisMapper.kpiTopDivisionList(policemanId, month, stationType);
    }


    /**
     * 无重复排序 ，不然不准
    * @param type  3中队，2大队，1支队,0总指标
    * @author zhangjj  
    * @Date 2017/8/24 9:50
    * @return 
    * @exception 
    */
    private void sort(List<PartyKpiStatisBean> partyKpiStatisList, final Integer type){
        if(partyKpiStatisList == null || partyKpiStatisList.isEmpty()){
            logger.warn("partyKpiStatisList is null!");
            return ;
        }
        int len = partyKpiStatisList.size();
        //---------工作时长 排序
        Collections.sort(partyKpiStatisList, new Comparator<PartyKpiStatisBean>() {
            @Override
            public int compare(PartyKpiStatisBean o1, PartyKpiStatisBean o2) {

                return o2.getWorkingTimeSum().compareTo(o1.getWorkingTimeSum());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        switch (type){
            case 1:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setWorkingTimeDivisionTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 2:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setWorkingTimeCropsTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 3:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setWorkingTimeSquadronTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
        }


        //---------里程 排序
        Collections.sort(partyKpiStatisList, new Comparator<PartyKpiStatisBean>() {
            @Override
            public int compare(PartyKpiStatisBean o1, PartyKpiStatisBean o2) {

                return o2.getMileageSum().compareTo(o1.getMileageSum());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        switch (type){
            case 1:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setMileageDivisionTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 2:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setMileageCropsTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 3:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setMileageSquadronTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
        }


        //---------纠违 排序
        Collections.sort(partyKpiStatisList, new Comparator<PartyKpiStatisBean>() {
            @Override
            public int compare(PartyKpiStatisBean o1, PartyKpiStatisBean o2) {

                return o2.getLawAmountSum().compareTo(o1.getLawAmountSum());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        switch (type){
            case 1:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setLawAmountDivisionTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 2:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setLawAmountCropsTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 3:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setLawAmountSquadronTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
        }

        //---------接处警 排序
        Collections.sort(partyKpiStatisList, new Comparator<PartyKpiStatisBean>() {
            @Override
            public int compare(PartyKpiStatisBean o1, PartyKpiStatisBean o2) {

                return o2.getAlarmAmountSum().compareTo(o1.getAlarmAmountSum());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        switch (type){
            case 1:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setAlarmAmountDivisionTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 2:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setAlarmAmountCropsTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 3:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setAlarmAmountSquadronTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
        }


        //---------总指标排序 排序
        Collections.sort(partyKpiStatisList, new Comparator<PartyKpiStatisBean>() {
            @Override
            public int compare(PartyKpiStatisBean o1, PartyKpiStatisBean o2) {
                int totalO1 = 0;
                int totalO2 = 0;
                switch (type){
                    case 1:
                        totalO1 = o1.getWorkingTimeDivisionTop() + o1.getMileageDivisionTop()
                                + o1.getLawAmountDivisionTop() + o1.getAlarmAmountDivisionTop();
                        totalO2 = o2.getWorkingTimeDivisionTop() + o2.getMileageDivisionTop()
                                + o2.getLawAmountDivisionTop() + o2.getAlarmAmountDivisionTop();
                        break;
                    case 2:
                        totalO1 = o1.getWorkingTimeCropsTop() + o1.getMileageCropsTop()
                                + o1.getLawAmountCropsTop() + o1.getAlarmAmountCropsTop();
                        totalO2 = o2.getWorkingTimeCropsTop() + o2.getMileageCropsTop()
                                + o2.getLawAmountCropsTop() + o2.getAlarmAmountCropsTop();
                        break;
                    case 3:
                        totalO1 = o1.getWorkingTimeSquadronTop() + o1.getMileageSquadronTop()
                                + o1.getLawAmountSquadronTop() + o1.getAlarmAmountSquadronTop();
                        totalO2 = o2.getWorkingTimeSquadronTop() + o2.getMileageSquadronTop()
                                + o2.getLawAmountSquadronTop() + o2.getAlarmAmountSquadronTop();
                        break;
                }
                return totalO2 > totalO1 ? 1 : -1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        switch (type){
            case 1:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setTotalDivisionTop((i + 1));
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 2:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setTotalCropsTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
            case 3:
                for(int i = 0; i < len; ++i){
                    PartyKpiStatisBean partyKpiStatisBean = partyKpiStatisList.get(i);
                    partyKpiStatisBean.setTotalSquadronTop(i + 1);
                    partyKpiStatisMapper.update(partyKpiStatisBean);
                }
                break;
        }
    }


}
