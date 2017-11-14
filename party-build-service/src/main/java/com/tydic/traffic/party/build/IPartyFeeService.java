package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.PartyFeeBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IPartyFeeService {
    Long addPartyFee(PartyFeeBean partyFeeBean);

    void partyFeeList(Page<PartyFeeBean> page, Long policemanId);

    int delPartyFee(long id);
}
