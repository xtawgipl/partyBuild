package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.PartyKPIBean;
import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.mapper.PartyKpiMapper;
import com.tydic.traffic.mapper.PolicemanMapper;
import com.tydic.traffic.office.ExcelParser;
import com.tydic.traffic.party.build.IPartyKpiService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 绩效考核数据service
 *
 * @author zhangjj
 * @create 2017-08-23 17:15
 **/
@Service("partyKpiService")
public class PartyKpiServiceImpl implements IPartyKpiService {

    private Logger logger = LoggerFactory.getLogger(PartyKpiServiceImpl.class);

    @Resource(name="policemanMapper")
    private PolicemanMapper policemanMapper;

    @Resource(name="partyKpiMapper")
    private PartyKpiMapper partyKpiMapper;

    @Override
    public void uploadKPIData(FileInputStream fileInputStream, Integer stationType, Integer excelType) throws IOException {
        Map<String, Integer> params = new HashMap<>();
        if(stationType == 1){//铁骑
            params.put("date", 0);//日期
            params.put("name", 6);//姓名
            params.put("policeNumber", 7);//民警警号
            params.put("mileage", 8);//里程
            params.put("lawAmount", 11);//纠违总数
            params.put("alarmAmount", 13);//接处警
            params.put("workingTime", 31);//工作时长
        }else if(stationType == 2){//夜巡
            params.put("date", 0);//日期
            params.put("name", 5);//姓名
            params.put("policeNumber", 6);//民警警号
            params.put("mileage", 7);//里程
            params.put("lawAmount", 17);//纠违总数
            params.put("alarmAmount", 18);//接处警
            params.put("workingTime", 28);//工作时长
        }

        List<Map<String, String>> list = ExcelParser.parser(fileInputStream, excelType, params, 0);
        PartyKPIBean partyKPIBean = null;
        for(Map<String, String> map : list){
            String date = map.get("date");//日期
            String name = map.get("name");//姓名
            String policeNumber = map.get("policeNumber");//民警警号
            String mileage = map.get("mileage");//里程
            String lawAmount = map.get("lawAmount");//纠违总数
            String alarmAmount = map.get("alarmAmount");//接处警
            String workingTime = map.get("workingTime");//工作时长
            mileage = StringUtils.isEmpty(mileage) ? "0" : mileage;
            lawAmount = StringUtils.isEmpty(lawAmount) ? "0" : lawAmount;
            alarmAmount = StringUtils.isEmpty(alarmAmount) ? "0" : alarmAmount;
            workingTime = StringUtils.isEmpty(workingTime) ? "0" : workingTime;

            if(StringUtils.isEmpty(name) || StringUtils.isEmpty(policeNumber)){
                continue;
            }

            partyKPIBean = new PartyKPIBean();
            partyKPIBean.setAlarmAmount(Double.valueOf(alarmAmount).intValue());
            partyKPIBean.setDate(DateFormatUtils.format(HSSFDateUtil.getJavaDate(Double.valueOf(date)), "yyyy-MM-dd"));
            partyKPIBean.setLawAmount(Double.valueOf(lawAmount).intValue());
            partyKPIBean.setMileage(Double.valueOf(mileage).floatValue());
            PolicemanBean policemanBean = policemanMapper.selectByPoliceNumber(policeNumber);
            if(policemanBean == null){
                logger.warn("警员 " + name + "(" + policeNumber + ") 不存在!");
                continue;
            }
            partyKPIBean.setPolicemanId(policemanMapper.selectByPoliceNumber(policeNumber).getId());
            partyKPIBean.setStationType(stationType);
            partyKPIBean.setWorkingTime(Double.valueOf(workingTime).floatValue());
            partyKpiMapper.insert(partyKPIBean);
        }
    }

}