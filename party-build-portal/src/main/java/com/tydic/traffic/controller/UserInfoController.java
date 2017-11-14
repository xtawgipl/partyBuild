package com.tydic.traffic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tydic.traffic.base.ResultBean;
import com.tydic.traffic.constant.Constant;
import com.tydic.traffic.entity.OrganizationBean;
import com.tydic.traffic.entity.PolicemanBean;
import com.tydic.traffic.entity.TalkNotesBean;
import com.tydic.traffic.entity.UserInfoBean;
import com.tydic.traffic.office.ExcelParser;
import com.tydic.traffic.party.build.IDailyLearningService;
import com.tydic.traffic.party.build.IOrganizationService;
import com.tydic.traffic.party.build.IPolicemanService;
import com.tydic.traffic.party.build.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息controller
 *
 * @author zhangjj
 * @create 2017-08-21 17:28
 **/
@Controller
@RequestMapping("user")
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Resource
    private Constant constant;

    @Resource(name="userInfoService")
    private IUserInfoService userInfoService;

    @Resource(name="organizationService")
    private IOrganizationService organizationService;

    @Resource(name="policemanService")
    private IPolicemanService policemanService;

    /**
     * @description 用户信息  页面
     * @param
     * @author zhangjj
     * @Date 2017/8/18 17:30
     * @return
     * @exception
     */
    @GetMapping("/userInfoListView")
    public String userInfoListView(ModelAndView model) {

        return "userInfoListView";
    }


    /**
     * @description 用户权限信息 列表
     * @param pageSize 每页多少条数据
     *       pageIndex 请求第几页
     * @author zhangjj
     * @Date 2017/8/19 9:33
     * @return
     * @exception
     */
    @PostMapping("/userInfoList")
    @ResponseBody
    public String userInfoList(Long orgId, Integer pageNo, Integer pageSize) {
        logger.info("pageNo = " + pageNo + " ; pageSize = " + pageSize);
        JSONObject data = new JSONObject();
        data.put("total", 108);
        JSONArray rows = new JSONArray();
        for(int i = 0; i < 10; ++i){
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setId(Long.valueOf(i + 1));
            userInfoBean.setOrgRank("交警支队>宝安大队>一中队");
            userInfoBean.setDepartmentPositions("大队长");
            userInfoBean.setRole(1);
            PolicemanBean policemanBean = new PolicemanBean();
            policemanBean.setXm("姓名 " + i);
            userInfoBean.setPolicemanBean(policemanBean);
            rows.add(userInfoBean);
        }
        data.put("rows", rows);
        logger.info("" + data.toJSONString());
        return data.toJSONString();
    }

    @GetMapping("/updateUserPartyInfo")
    @ResponseBody
    public String updateUserPartyInfo() throws IOException {
        List<String> zwList = new ArrayList<>();//职务
        zwList.add("21");//副科长

        Map<String, Integer> params = new HashMap<>();
        params.put("partyBranch", 0);//所在支部
        params.put("name", 1);//姓名
        params.put("cNo", 10);//身份证
        params.put("telephone", 11);//电话
        params.put("partyTime", 12);//入党时间
        params.put("orgRank", 16);//所属部门层级
        List<Map<String, String>> list = ExcelParser.parser("D:\\project\\partyBuild\\party-build-portal\\src\\main\\resources\\data\\交警支队党员名册.xls", params, -1);
        for(Map<String, String> map : list){

            UserInfoBean userInfoBean = new UserInfoBean();

            String partyBranch = map.get("partyBranch");//所在支部
            String name = map.get("name");//姓名
//            String cNo = map.get("cNo");//身份证
            String telephone = map.get("telephone");//电话
            String partyTime = map.get("partyTime");//入党时间
            String orgRank =  map.get("orgRank");//所属部门层级

            List<PolicemanBean> policemanList = policemanService.findByName(name);
            PolicemanBean policemanBean = null;
            if(policemanList == null || policemanList.isEmpty()){
                logger.warn("policemanList is empty , name = " + name + " not exist!");
                continue;
            }else if(policemanList.size() == 1){
                policemanBean = policemanList.get(0);
            }else {
                for(PolicemanBean p : policemanList){
                    if((!StringUtils.isEmpty(p.getSjhm()) && !StringUtils.isEmpty(telephone)
                            && telephone.equals(p.getSjhm())) || orgRank.contains(p.getOrganizationBean().getBmmc())){
                        policemanBean = p;
                        break;
                    }
                }
            }
            if(policemanBean != null){
                userInfoBean.setPolicemanId(policemanBean.getId());
                userInfoBean.setOrgRank(getOrgRank(policemanBean.getSsbm()));
                userInfoBean.setDepartmentPositions(policemanBean.getXrzw());
                userInfoBean.setPartyBranch(partyBranch);
                userInfoBean.setPartyTime(partyTime);

                if(zwList.contains(userInfoBean.getDepartmentPositions())){
                    userInfoBean.setRole(1);//有权限看部门内其他人的信息
                }
                userInfoBean.setPassword("123456");

                userInfoService.addUserInfo(userInfoBean);
            }else{
                logger.warn("name = " + name + " not exist!");
                continue;
            }

        }

        return ResultBean.success().toJsonString();
    }

    @GetMapping("/updateUserPartyInfo1")
    @ResponseBody
    public String updateUserPartyInfo1() throws IOException {
        Map<String, Integer> params = new HashMap<>();
        params.put("name", 1);//姓名
        params.put("partyDuty", 9);//党内职务
        params.put("partyTime", 8);//入党时间
        List<String> dutyXlsList = new ArrayList<>();
        dutyXlsList.add("宝安大队党总支.xls");
        dutyXlsList.add("车管处党总支.xls");
        dutyXlsList.add("大鹏大队党总支.xls");
        dutyXlsList.add("东部高速大队党总支.xls");
        dutyXlsList.add("福田大队党总支.xls");
        dutyXlsList.add("光明大队党总支.xls");
        dutyXlsList.add("机动训练大队党总支.xls");
        dutyXlsList.add("交通处党总支.xls");
        dutyXlsList.add("科技处党总支.xls");
        dutyXlsList.add("老干部党支部.xls");
        dutyXlsList.add("龙岗大队党总支.xls");
        dutyXlsList.add("龙华大队党总支.xls");
        dutyXlsList.add("罗湖大队党总支.xls");
        dutyXlsList.add("南山大队党总支.xls");
        dutyXlsList.add("坪山大队党总支.xls");
        dutyXlsList.add("西部高速大队党总支.xls");
        dutyXlsList.add("盐田大队党总支.xls");
        dutyXlsList.add("侦查大队党总支.xls");
        dutyXlsList.add("支队党委班子.xls");
        dutyXlsList.add("指挥处党总支班子.xls");
        dutyXlsList.add("综合处党总支.xls");
        for(String xlsName : dutyXlsList){
            List<Map<String, String>> list = ExcelParser.parser("D:\\project\\partyBuild\\party-build-portal\\src\\main\\resources\\data\\" + xlsName, params, -1);
            for(Map<String, String> map : list){

                UserInfoBean userInfoBean = null;

                String name = map.get("name");//姓名
                String partyDuty = map.get("partyDuty");//党内职务
                String partyTime = map.get("partyTime");//入党时间

                List<UserInfoBean> userInfoList = userInfoService.findUserInfoByName(name);
                if(userInfoList != null && !userInfoList.isEmpty()){
                    if(userInfoList.size() == 1){
                        userInfoBean = userInfoList.get(0);
                    }else{
                        for(UserInfoBean u : userInfoList){
                            if(partyTime.equals(u.getPartyTime())){
                                userInfoBean = u;
                                break;
                            }
                        }
                    }
                    if(userInfoBean != null){
                        userInfoBean.setPartyDuty(partyDuty);
                        userInfoService.update(userInfoBean);
                    }else{
                        logger.warn(name + " --------- > userInfo not exist!");
                    }
                }else{
                    logger.warn(name + " -- > userInfo not exist!");
                }


            }
        }


        return ResultBean.success().toJsonString();
    }





    private String getOrgRank(Long orgId){
        OrganizationBean organizationBean = organizationService.findByPrimaryKey(orgId);
        OrganizationBean organizationBean1 = null;
        OrganizationBean organizationBean2 = null;
        if("1".equals(organizationBean.getSsjb())){
            return organizationBean.getBmmc();
        }else if("2".equals(organizationBean.getSsjb())){
            organizationBean1 = organizationService.findByBMBH(organizationBean.getSjbm());
            return organizationBean1.getBmmc() + ">" + organizationBean.getBmmc();
        }else if("3".equals(organizationBean.getSsjb())){
            organizationBean1 = organizationService.findByBMBH(organizationBean.getSjbm());
            organizationBean2 = organizationService.findByBMBH(organizationBean1.getSjbm());
            return organizationBean2.getBmmc() + ">" + organizationBean1.getBmmc() + ">" + organizationBean.getBmmc();
        }else{
            return "";
        }
    }


    /**
     * @description 升级该党员权限为部门管理员
     * @param
     * @author zhangjj
     * @Date 2017/8/19 9:33
     * @return
     * @exception
     */
    @PostMapping("/upgrade")
    @ResponseBody
    public String upgrade(Long id) {
        logger.info("id = " + id);
        return ResultBean.success().toJsonString();
    }


    /**
     * @description 将该部门管理员降级为普通成员
     * @param
     * @author zhangjj
     * @Date 2017/8/19 9:33
     * @return
     * @exception
     */
    @PostMapping("/downgrade")
    @ResponseBody
    public String downgrade(Long id) {
        logger.info("id = " + id);
        return ResultBean.success().toJsonString();
    }

}
