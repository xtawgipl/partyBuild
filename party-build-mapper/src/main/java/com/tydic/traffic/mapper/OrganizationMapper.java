package com.tydic.traffic.mapper;

import com.tydic.traffic.entity.NewBean;
import com.tydic.traffic.entity.OrganizationBean;
import com.tydic.traffic.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper {
    int deleteById(@Param("id") Long id);

    Long insert(@Param("record") OrganizationBean record);

    OrganizationBean selectByPrimaryKey(Long id);

    List<OrganizationBean> selectByPage(Page<OrganizationBean> page);

    OrganizationBean findByBMBH(@Param("bmbh") String bmbh);

    /**   
    * @param bmbh 大队编号
    * @author zhangjj  
    * @Date 2017/8/24 10:26
    * @return 
    * @exception 
    */
    List<OrganizationBean> listOrg(String bmbh);
}