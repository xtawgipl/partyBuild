package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.PartyCultureBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IPartyCultureService {
    Long addPartyCulture(PartyCultureBean partyCultureBean);

    void partyCultureList(Page<PartyCultureBean> page);

    int delPartyCulture(long id);
}
