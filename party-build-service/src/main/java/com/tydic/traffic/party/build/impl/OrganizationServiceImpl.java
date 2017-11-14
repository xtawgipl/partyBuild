package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.OrganizationBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.OrganizationMapper;
import com.tydic.traffic.party.build.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 部门
 *
 * @author zhangjj
 * @create 2017-08-22 21:25
 **/
@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService {
    @Resource(name = "organizationMapper")
    private OrganizationMapper organizationMapper;

    @Override
    public OrganizationBean findByPrimaryKey(Long orgId) {
        return organizationMapper.selectByPrimaryKey(orgId);
    }

    @Override
    public OrganizationBean findByBMBH(String bmbh) {
        return organizationMapper.findByBMBH(bmbh);
    }
}
