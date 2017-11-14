package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.PartyFeeBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.PartyfeeMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.IPartyFeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 党费缴纳
 *
 * @author zhangjj
 * @create 2017-08-22 21:28
 **/
@Service("partyFeeService")
public class PartyFeeServiceImpl implements IPartyFeeService {
    @Resource(name = "partyfeeMapper")
    private PartyfeeMapper partyfeeMapper;

    @Override
    public Long addPartyFee(PartyFeeBean partyFeeBean) {
        return partyfeeMapper.insert(partyFeeBean);
    }

    @Override
    @Pageable
    public void partyFeeList(Page<PartyFeeBean> page, Long policemanId) {
        partyfeeMapper.selectByPage(page, policemanId);
    }

    @Override
    public int delPartyFee(long id) {
        return partyfeeMapper.deleteById(id);
    }
}
