package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.StudyGardenBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.StudygardenMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.IStudyGardenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 学习园地
 *
 * @author zhangjj
 * @create 2017-08-22 21:30
 **/
@Service("studyGardenService")
public class StudyGardenServiceImpl implements IStudyGardenService {
    @Resource(name = "studygardenMapper")
    private StudygardenMapper studygardenMapper;

    @Override
    public Long addStudyGarden(StudyGardenBean studyGardenBean) {
        return studygardenMapper.insert(studyGardenBean);
    }

    @Override
    @Pageable
    public void studyGardenList(Page<StudyGardenBean> page) {
        studygardenMapper.selectByPage(page);
    }

    @Override
    public int delStudyGarden(long id) {
        return studygardenMapper.deleteById(id);
    }
}
