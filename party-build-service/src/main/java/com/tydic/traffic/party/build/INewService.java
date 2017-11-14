package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.NewBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface INewService {
    Long addNew(NewBean newBean);

    void newList(Page<NewBean> page);

    int delNew(long id);
}
