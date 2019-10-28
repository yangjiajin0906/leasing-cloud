package com.leasing.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.entity.AbstractBaseEntity;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.sys.dao.DFuncMenuRepo;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.query.DFuncMenuQuery;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import com.leasing.sys.entity.vo.SystemVO;
import com.leasing.sys.service.DFuncMenuService;
import com.leasing.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/getAttributeAry")
    public ResResult getAttributeAry(){
        String jq="select s from DFuncMenuVO s where s.pkFuncmenu = '824f6343a4334fa6a1d4'";
        DFuncMenuVO vo = dFuncMenuRepo.findOneByJPQL(DFuncMenuVO.class,jq,false);
        DFuncMenuVO newvo = (DFuncMenuVO)vo.clone();    //克隆方法
        DFuncMenuVO newvo2 = DozerUtils.convert(vo,DFuncMenuVO.class);  //dozer复制
        List<String> list1 = vo.differentColumn((AbstractBaseEntity)newvo,null);
        vo.setFuncCode("3gggg1");
        vo.setFuncName("dsal2高gggg千");
        vo.getPkSystem().setSystemCode("32llllk");
        newvo.getPkSystem().setSystemName("测试修改");
        System.out.println("复制后未修改任何值1:"+list1.toString());
        List<String> list2 = vo.differentColumn((AbstractBaseEntity)newvo,null);
        List<String> list3 = vo.differentColumn((AbstractBaseEntity)newvo2,null);
        System.out.println("复制后修改部分值2:"+list2.toString());
        System.out.println("复制后修改部分值3:"+list3.toString());
        return ResultUtils.successWithData(newvo);
    }

    /**
     * 获取所有菜单列表  前台可视化  直接返回VO list  (已使用)
     * @return
     */
    @RequestMapping(value = "/getMenuList")
    public ResResult getMenuList(@RequestBody String pagination){
       Map<String,Object> map = JSONObject.parseObject(pagination);
       Pagination page=new Pagination();
       page.setCurPage(Integer.parseInt(String.valueOf(map.get("pageIndex"))));
       page.setPageSize(Integer.parseInt(String.valueOf(map.get("pageSize"))));
//        List<DFuncMenuDO> result = dFuncMenuService.getAllMenu();
//        List<DFuncMenuVO> resultlist=new ArrayList<>();
//        for(DFuncMenuDO mdo:result){
//            DFuncMenuVO vo =new DFuncMenuVO();
//            BeanUtils.copyProperties(mdo,vo);
//            DFuncMenuDO parentdo=dFuncMenuService.findByPkFuncmenu(mdo.getPkParent());
//            if(parentdo!=null){
//                DFuncMenuVO parentvo=new DFuncMenuVO();
//                BeanUtils.copyProperties(parentdo,parentvo);
//                vo.setPkParent(parentvo);
//            }
//            resultlist.add(vo);
//        }
        List<DFuncMenuVO> result = dFuncMenuService.getMenuList();
//        for(DFuncMenuVO vo:result){
//            DFuncMenuDO parentdo=dFuncMenuService.findByPkFuncmenu(vo.getPkParent().getPkFuncmenu());
//            if(parentdo!=null){
//                DFuncMenuVO parentvo=new DFuncMenuVO();
//                BeanUtils.copyProperties(parentdo,parentvo);
//                vo.setPkParent(parentvo);
//            }
//        }
//        List<DFuncMenuVO> first_list= new ArrayList<DFuncMenuVO>();
//        List<DFuncMenuVO> second_list= new ArrayList<DFuncMenuVO>();
//        List<DFuncMenuVO> third_list= new ArrayList<DFuncMenuVO>();
//        for(DFuncMenuVO vo:result){
//            if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("first_menu")){
//                vo.setChildren(new ArrayList<DFuncMenuVO>());
//                first_list.add(vo);
//            }else if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("second_menu")){
//                vo.setChildren(new ArrayList<DFuncMenuVO>());
//                second_list.add(vo);
//            }else if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("third_menu")){
//                vo.setChildren(new ArrayList<DFuncMenuVO>());
//                third_list.add(vo);
//            }
//        }
//        for(DFuncMenuVO firstvo:first_list){
//            for(DFuncMenuVO secondvo:second_list){
//                if(secondvo.getPkParent().getPkFuncmenu().equals(firstvo.getPkFuncmenu())){
//                    firstvo.getChildren().add(secondvo);
//                    for(DFuncMenuVO thirdvo:third_list){
//                        if(thirdvo.getPkParent().getPkFuncmenu().equals(secondvo.getPkFuncmenu())){
//                            secondvo.getChildren().add(thirdvo);
//                        }
//                    }
//                }
//            }
//        }
        return ResultUtils.successWithData(result);
    }

    /**
     * 获取存储库所有菜单列表  返回DO list
     */
    @RequestMapping(value = "/getDMenuList")
    public ResResult getDMenuList (){
        PageQueryData listdo = dFuncMenuService.getDMenuList();
        return ResultUtils.successWithData(listdo);
    }

    //测试根据pk寻找do  根据pk寻找其他对象   根据pk寻找本对象的vo
    @RequestMapping(value = "/findbyPk")
    public ResResult findBypk(){
        DFuncMenuDO dos = dFuncMenuRepo.findOne("824f6343a4334fa6a1d4");
//        SystemDO sdos = dFuncMenuRepository.findOne("11111111111111111111",SystemDO.class);  //报错
//        DFuncMenuVO svo = dFuncMenuRepository.findOne("11111111111111111111",DFuncMenuVO.class);  //报错
        return ResultUtils.successWithData(dos);
    }

    //返回单个对象结果   可自定义类型
    @RequestMapping(value="/findByjpql")
    public ResResult findBypql(){
        String jq="select s from DFuncMenuVO s where s.pkFuncmenu = '824f6343a4334fa6a1d4'";
        DFuncMenuVO vo = dFuncMenuRepo.findOneByJPQL(DFuncMenuVO.class,jq,false);
        String jql ="select d from SystemVO d where d.pkSystem='11111111111111111111'";
        SystemVO dos = dFuncMenuRepo.findOneByJPQL(SystemVO.class,jql,false);
        String jqldo="select f from DFuncMenuDO f where f.pkFuncmenu = '824f6343a4334fa6a1d4'";
        DFuncMenuDO dos2 = dFuncMenuRepo.findOneByJPQL(DFuncMenuDO.class,jqldo,false);
        return ResultUtils.successWithData(dos);
    }

    //返回对象结果集合   可自定义类型
    @RequestMapping(value="/findByJPQLlist")
    public ResResult findBypqlList(){
        String jq="select s from DFuncMenuVO s";
        List<DFuncMenuVO> vo = dFuncMenuRepo.findByJPQL(DFuncMenuVO.class,jq,false);
        String jql ="select d from SystemVO d";
        List<SystemVO> dos = dFuncMenuRepo.findByJPQL(SystemVO.class,jql,false);
        String jqldo = "select f from DFuncMenuDO f";
        List<DFuncMenuDO> dos1 = dFuncMenuRepo.findByJPQL(DFuncMenuDO.class,jqldo,false);
        return ResultUtils.successWithData(dos);
    }


    //源生sql返回自定义类型
    @RequestMapping(value = "findByNativeone")
    public ResResult findByNative(){

//        String sql = "select s.*,m.system_code,m.system_name from sm_business_menu s left join sm_system m on s.pk_system=m.pk_system where s.pk_funcmenu = '824f6343a4334fa6a1d4'";
//        String sql2="select s.pk_system as pkSystem,s.system_code as systemCode,s.system_name as systemName from sm_system s where s.pk_system = '11111111111111111111'";
//        SystemVO svo = dFuncMenuRepository.findOneByNativeSql(SystemVO.class,sql2);   //报错
//        SystemDO sdo = dFuncMenuRepository.findOneByNativeSql(SystemDO.class,sql2);
        List list = dFuncMenuRepo.findByNativeSql("DFuncMenuVO.getDFuncmentest",true);
        return ResultUtils.successWithData(list);
    }


    @RequestMapping(value = "findBysortAndPage")
    public ResResult findBysortAndPage(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        DFuncMenuQuery query =new DFuncMenuQuery();
        query.setFuncName("系统管理");
        Sort sort = new Sort(Sort.Direction.DESC,"ts");
        PageQueryData list2 = dFuncMenuRepo.pageQuery(pagination,query,sort);
        return ResultUtils.successWithData(list2);
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
     * JPQL查询菜单VO
     * @return
     */
    @RequestMapping(value = "/findDFuncmenuVO")
    public ResResult findDFuncmenuVO(){
        DFuncMenuVO menu = dFuncMenuService.findOneVO("DFuncMenuVO.findFuncmenuVO");
        return ResultUtils.successWithData(menu);
    }

    /**
     * 修改菜单测试 全数据更新
     * @return
     */
    @Transactional
    @RequestMapping(value = "/updateDFuncMenu")
    public ResResult updateDFuncMenu(){
        DFuncMenuDO menu = dFuncMenuService.findOneDO("fca607a2c19b4efb9286");
        menu.setFuncName("fffff");
        menu.setFuncCode("kkkkk");
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
    public String deleteDFuncMenu(){
        DFuncMenuDO menu = dFuncMenuService.findOneDO("fca607a2c19b4efb9286");
        dFuncMenuService.delete(menu);
        return "测试删除";
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