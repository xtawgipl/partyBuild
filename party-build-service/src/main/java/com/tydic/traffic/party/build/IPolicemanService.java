package com.tydic.traffic.party.build;

import com.tydic.traffic.entity.PolicemanBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tydic on 2017/8/16.
 */
public interface IPolicemanService {
    PolicemanBean findByPrimaryKey(Long id);

    List<PolicemanBean> findByName(String name);
}
