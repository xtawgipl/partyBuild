package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.mapper.PolicemanMapper;
import com.tydic.traffic.party.build.IPolicemanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 警员service
 *
 * @auther create by zhangjj
 * @create 2017/8/16-14:26
 */
@Service("policemanService")
public class PolicemanServiceImpl implements IPolicemanService {

    @Resource(name="policemanMapper")
    private PolicemanMapper policemanMapper;

    @Override
    public PolicemanBean findByPrimaryKey(Long id) {

        return policemanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PolicemanBean> findByName(String name) {
        return policemanMapper.findByName(name);
    }
}
