package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.SpecialLearningBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface ISpecialLearningService {
    Long addSpecialLearning(SpecialLearningBean specialLearningBean);

    void specialLearningList(Page<SpecialLearningBean> page, Long policemanId);

    int delSpecialLearning(long id);
}
