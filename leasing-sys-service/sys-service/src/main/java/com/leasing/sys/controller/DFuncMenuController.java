package com.leasing.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.repository.sys.DFuncMenuRepo;
import com.leasing.common.service.sys.DFuncMenuService;
import com.leasing.common.service.sys.SystemService;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.tools.DozerUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class DFuncMenuController {
    @Autowired
    DFuncMenuService dFuncMenuService;

    @Autowired
    SystemService systemService;

    @Autowired
    DFuncMenuRepo dFuncMenuRepo;

    /**
     * xml文件配置测试
     */
    @RequestMapping(value = "/testXml")
    public ResResult testXml(){
//        Pagination pagination = new Pagination();
//        pagination.setCurPage(1);
//        pagination.setPageSize(50);
//        DFuncMenuQuery queryvo =new DFuncMenuQuery();
        List<Map<String,Object>> list = dFuncMenuRepo.findByNativeName("DFuncMenuVO.getDFuncmentest");
        return ResultUtils.successWithData(list);
    }


    /**
     * 获取所有菜单列表  前台可视化  直接返回VO list  (已使用)
     * @return
     */
    @RequestMapping(value = "/getMenuList")
    //@RequestBody String pagination
    public ResResult getMenuList(@RequestBody String data){
        JSONObject json = JSONObject.parseObject(data);
        String systemPk = "";
        if(json!=null && json.get("currentSystem") != null && !StringUtils.isEmpty(json.get("currentSystem").toString())){
            systemPk = json.get("currentSystem").toString();
        }
        List<DFuncMenuVO> result = dFuncMenuService.getMenuList(systemPk);
        return ResultUtils.successWithData(result);
    }


    //测试根据pk寻找do  根据pk寻找其他对象   根据pk寻找本对象的vo
    @RequestMapping(value = "/findbyPk")
    public ResResult findBypk(){
        DFuncMenuDO dos = dFuncMenuRepo.findOne("824f6343a4334fa6a1d4");
//        SystemDO sdos = dFuncMenuRepository.findOne("11111111111111111111",SystemDO.class);  //报错
//        DFuncMenuVO svo = dFuncMenuRepository.findOne("11111111111111111111",DFuncMenuVO.class);  //报错
        return ResultUtils.successWithData(dos);
    }


    /**
     * 新增菜单
     * @return
     */
    @RequestMapping(value ="/addDFuncMenu")
    public ResResult addDFuncMenu(@RequestBody DFuncMenuVO vo){
        String str = UUID.randomUUID().toString().replace("-","");
        vo.setPkFuncmenu(str.substring(0,20));
        DFuncMenuDO dos = DozerUtils.convert(vo,DFuncMenuDO.class);
        //加入当前登录人的 用户Pk 机构pk 部门pk  更新操作时间  操作日期后保存  目前未加入
//        DFuncMenuDO func = new DFuncMenuDO();
//        func.setPkFuncmenu(str.substring(0,20));
//        func.setPkSystem("11111111111111111111");
//        func.setPkParent("11111111111111111111");
//        func.setCollected(Short.parseShort("0"));
//        func.setFuncCode("90H1201");
//        func.setFuncName("参数设置");
//        func.setIcon("grey iconfont icon-appicon");
//        func.setIfPower(Short.parseShort("1"));
//        func.setMenuPath(null);
//        func.setIfEnabled(Short.parseShort("0"));
//        func.setMenuProperty("third_menu");
//        func.setIfFirstEnabled(Short.parseShort("0"));
        dFuncMenuService.addorupdate(dos);
        return ResultUtils.successWithData(vo);
    }


    /**
     * 修改菜单测试 全数据更新  传入vo转化为do直接更新
     * @return
     */
    @Transactional
    @RequestMapping(value = "/updateDFuncMenu")
    public ResResult updateDFuncMenu(@RequestBody DFuncMenuVO vo){
        DFuncMenuDO menu = DozerUtils.convert(vo,DFuncMenuDO.class);
        dFuncMenuService.addorupdate(menu);
        return ResultUtils.successWithData(menu);
    }

    /**
     * 修改菜单测试 单字段更新
     * @return
     */
    @Transactional
    @RequestMapping(value = "/updateDFuncMenuBillstatus")
    public ResResult updateDFuncMenuBillstatus(){
        DFuncMenuDO menu = dFuncMenuService.findOneDO("fca607a2c19b4efb9286");
        menu.setBillstatus(Short.parseShort("9"));
        dFuncMenuService.update(menu);
        return ResultUtils.successWithData(menu);
    }

    /**
     * 依据Pk删除数据
     * @return
     */
    @Transactional
    @RequestMapping(value = "/deleteDFuncMenu")
    public ResResult deleteDFuncMenu(@RequestBody DFuncMenuVO vo){
        DFuncMenuDO menu = DozerUtils.convert(vo,DFuncMenuDO.class);
        dFuncMenuService.delete(menu);
        return ResultUtils.successWithData(menu);
    }


    /**
     * 批量添加菜单子表字段    入参为输添加的数组
     * @return
     */
//    @RequestMapping(value = "/batchColumnSave")
//    public String batchColumnSave(@RequestParam(value = "str", required = false) String param){
//        //此处需要添加实现方法!!!!!!
////        JSONObject jsonObject = JSON.parseObject(param);
////         System.out.println(param);
//
////        Map<String,Object> map= new HashMap<String,Object>();
////        map= jsonObject.getInnerMap();
//        //循环获取map中的数据
////        String column_name = map.get("column_name");
////        String column_code = map.get("column_code");
////        String column_type = map.get("column_type");
////        MenuColumnVO vo =new MenuColumnVO();
////        vo.setPk("1312");
////        vo.setColumnCode(column_code);
////        vo.setColumnName(column_name);
////        vo.setColumnType(column_type);
//
//
//        return "批量新增子表字段测试";
//    }

}