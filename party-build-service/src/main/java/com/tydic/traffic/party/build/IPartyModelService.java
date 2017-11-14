package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.PartyModelBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IPartyModelService {
    Long addPartyModel(PartyModelBean partyModelBean);

    void partyModelList(Page<PartyModelBean> page);

    int delPartyModel(long id);
}
