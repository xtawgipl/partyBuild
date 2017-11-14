package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.TalkNotesBean;
import com.tydic.traffic.mapper.DailylearningMapper;
import com.tydic.traffic.mapper.TalknotesMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.ITalkNotesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 谈话记录
 *
 * @author zhangjj
 * @create 2017-08-22 21:31
 **/
@Service("talkNotesService")
public class TalkNotesServiceImpl implements ITalkNotesService {
    @Resource(name = "talknotesMapper")
    private TalknotesMapper talknotesMapper;

    @Override
    public Long addTalkNotes(TalkNotesBean talkNotesBean) {
        return talknotesMapper.insert(talkNotesBean);
    }

    @Override
    @Pageable
    public void talkNotesList(Page<TalkNotesBean> page, Long policemanId, Integer flag) {
        talknotesMapper.selectByPage(page, policemanId, flag);
    }

    @Override
    public int delTalkNotes(long id) {
        return talknotesMapper.deleteById(id);
    }
}
