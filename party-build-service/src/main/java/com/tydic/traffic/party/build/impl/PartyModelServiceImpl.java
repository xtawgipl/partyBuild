package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.PartyModelBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.PartymodelMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.IPartyModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 党费模范
 *
 * @author zhangjj
 * @create 2017-08-22 21:29
 **/
@Service("partyModelService")
public class PartyModelServiceImpl implements IPartyModelService {
    @Resource(name = "partymodelMapper")
    private PartymodelMapper partymodelMapper;

    @Override
    public Long addPartyModel(PartyModelBean partyModelBean) {
        return partymodelMapper.insert(partyModelBean);
    }

    @Override
    @Pageable
    public void partyModelList(Page<PartyModelBean> page) {
        partymodelMapper.selectByPage(page);
    }

    @Override
    public int delPartyModel(long id) {
        return partymodelMapper.deleteById(id);
    }
}