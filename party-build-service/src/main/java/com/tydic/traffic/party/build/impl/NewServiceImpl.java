package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.DailyLearningBean;
import com.tydic.traffic.entity.NewBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.NewsMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.INewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 时政要闻service
 *
 * @author zhangjj
 * @create 2017-08-22 21:24
 **/
@Service("newService")
public class NewServiceImpl implements INewService {

    @Resource(name = "newsMapper")
    private NewsMapper newsMapper;

    @Override
    public Long addNew(NewBean newBean) {
        return newsMapper.insert(newBean);
    }

    @Override
    @Pageable
    public void newList(Page<NewBean> page) {
        newsMapper.selectByPage(page);
    }

    @Override
    public int delNew(long id) {
        return newsMapper.deleteById(id);
    }
}
