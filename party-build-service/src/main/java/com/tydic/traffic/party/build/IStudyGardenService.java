package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.StudyGardenBean;
import com.tydic.traffic.page.Page;

/**
 * Created by lenovo on 2017/8/22.
 */
public interface IStudyGardenService {
    Long addStudyGarden(StudyGardenBean studyGardenBean);

    void studyGardenList(Page<StudyGardenBean> page);

    int delStudyGarden(long id);
}
