package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.OrganizationBean;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IOrganizationService {
    OrganizationBean findByPrimaryKey(Long orgId);

    OrganizationBean findByBMBH(String bmbh);
}
