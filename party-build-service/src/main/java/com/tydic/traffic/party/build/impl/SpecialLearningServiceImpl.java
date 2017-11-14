package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.SpecialLearningBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.SpeciallearningMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.ISpecialLearningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 专项学习
 *
 * @author zhangjj
 * @create 2017-08-22 21:30
 **/
@Service("specialLearningService")
public class SpecialLearningServiceImpl implements ISpecialLearningService {
    @Resource(name = "speciallearningMapper")
    private SpeciallearningMapper speciallearningMapper;

    @Override
    public Long addSpecialLearning(SpecialLearningBean specialLearningBean) {
        return speciallearningMapper.insert(specialLearningBean);
    }

    @Override
    @Pageable
    public void specialLearningList(Page<SpecialLearningBean> page, Long policemanId) {
        speciallearningMapper.selectByPage(page, policemanId);
    }

    @Override
    public int delSpecialLearning(long id) {
        return speciallearningMapper.deleteById(id);
    }
}
