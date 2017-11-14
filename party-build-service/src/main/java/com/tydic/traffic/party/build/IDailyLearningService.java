package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.DailyLearningBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IDailyLearningService {

    Long addDailyLearning(DailyLearningBean dailyLearningBean);

    void dailyLearningList(Page<DailyLearningBean> page, Long policemanId);

    int delDailyLearning(long id);
}
