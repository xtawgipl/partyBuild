package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.TalkNotesBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface ITalkNotesService {
    Long addTalkNotes(TalkNotesBean talkNotesBean);

    void talkNotesList(Page<TalkNotesBean> page, Long policemanId, Integer flag);

    int delTalkNotes(long id);
}
