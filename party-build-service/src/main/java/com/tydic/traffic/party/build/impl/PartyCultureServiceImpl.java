package com.tydic.traffic.party.build.impl;

import com.tydic.traffic.entity.PartyCultureBean;
import com.tydic.traffic.mapper.PartycultureMapper;
import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.annotion.Pageable;
import com.tydic.traffic.party.build.IPartyCultureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangjj
 * @create 2017-08-22 21:26
 **/
@Service("partyCultureService")
public class PartyCultureServiceImpl implements IPartyCultureService {
    @Resource(name = "partycultureMapper")
    private PartycultureMapper partycultureMapper;

    @Override
    public Long addPartyCulture(PartyCultureBean partyCultureBean) {
        return partycultureMapper.insert(partyCultureBean);
    }

    @Override
    @Pageable
    public void partyCultureList(Page<PartyCultureBean> page) {
        partycultureMapper.selectByPage(page);
    }

    @Override
    public int delPartyCulture(long id) {
        return partycultureMapper.deleteById(id);
    }
}
