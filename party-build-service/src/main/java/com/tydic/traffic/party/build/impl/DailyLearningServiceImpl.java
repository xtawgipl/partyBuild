package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.DailyLearningBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.IDailyLearningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日常学习service
 *
 * @author zhangjj
 * @create 2017-08-22 16:50
 **/
@Service("dailyLearningService")
public class DailyLearningServiceImpl implements IDailyLearningService {

    @Resource(name = "dailylearningMapper")
    private DailylearningMapper dailylearningMapper;

    @Override
    public Long addDailyLearning(DailyLearningBean dailyLearningBean) {
        return dailylearningMapper.insert(dailyLearningBean);
    }

    @Override
    @Pageable
    public void dailyLearningList(Page<DailyLearningBean> page, Long policemanId) {
        dailylearningMapper.selectByPage(page, policemanId);
    }

    @Override
    public int delDailyLearning(long id) {
        return dailylearningMapper.deleteById(id);
    }
}
