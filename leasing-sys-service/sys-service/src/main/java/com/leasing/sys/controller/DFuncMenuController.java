package com.leasing.sys.controller;

import com.leasing.common.utils.DozerBeanMapperConfigure;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.dto.DFuncMenuDTO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.ResultUtils;
import com.leasing.sys.service.DFuncMenuService;
import com.leasing.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

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

//    @Resource
//    UserService userService;

    /**
     * 获取所有菜单列表 分级处理
     * @return
     */
//    @RequestMapping(value = "/getDFuncMenu")
//    public ResResult getDFuncMenu(@RequestParam(value = "param", required = false) String param){
//        System.out.println("进入查询方法");
////        List<DFuncMenuDO> result = dFuncMenuService.getAllMenu();
////        List<DFuncMenuVO> resultlist=new ArrayList<>();
////        for(DFuncMenuDO mdo:result){
////            DFuncMenuVO vo =new DFuncMenuVO();
////            BeanUtils.copyProperties(mdo,vo);
////            DFuncMenuDO parentdo=dFuncMenuService.findByPkFuncmenu(mdo.getPkParent());
////            if(parentdo!=null){
////                DFuncMenuVO parentvo=new DFuncMenuVO();
////                BeanUtils.copyProperties(parentdo,parentvo);
////                vo.setPkParent(parentvo);
////            }
////            resultlist.add(vo);
////        }
//        List<DFuncMenuVO> result = dFuncMenuService.getFuncmenu();
////        for(DFuncMenuVO vo:result){
////            DFuncMenuDO parentdo=dFuncMenuService.findByPkFuncmenu(vo.getPkParent().getPkFuncmenu());
////            if(parentdo!=null){
////                DFuncMenuVO parentvo=new DFuncMenuVO();
////                BeanUtils.copyProperties(parentdo,parentvo);
////                vo.setPkParent(parentvo);
////            }
////        }
//        System.out.println(result.size());
////        List<DFuncMenuVO> first_list= new ArrayList<DFuncMenuVO>();
////        List<DFuncMenuVO> second_list= new ArrayList<DFuncMenuVO>();
////        List<DFuncMenuVO> third_list= new ArrayList<DFuncMenuVO>();
////        for(DFuncMenuVO vo:result){
////            if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("first_menu")){
////                vo.setChildren(new ArrayList<DFuncMenuVO>());
////                first_list.add(vo);
////            }else if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("second_menu")){
////                vo.setChildren(new ArrayList<DFuncMenuVO>());
////                second_list.add(vo);
////            }else if(vo.getMenuProperty()!=null&&vo.getMenuProperty().equals("third_menu")){
////                vo.setChildren(new ArrayList<DFuncMenuVO>());
////                third_list.add(vo);
////            }
////        }
////        for(DFuncMenuVO firstvo:first_list){
////            for(DFuncMenuVO secondvo:second_list){
////                if(secondvo.getPkParent().getPkFuncmenu().equals(firstvo.getPkFuncmenu())){
////                    firstvo.getChildren().add(secondvo);
////                    for(DFuncMenuVO thirdvo:third_list){
////                        if(thirdvo.getPkParent().getPkFuncmenu().equals(secondvo.getPkFuncmenu())){
////                            secondvo.getChildren().add(thirdvo);
////                        }
////                    }
////                }
////            }
////        }
//        return ResultUtils.successWithData(result);
//    }

//    /**
//     * 新增菜单
//     * @return
//     */
//    @RequestMapping(value ="/addDFuncMenu")
////    ,method = RequestMethod.POST
////    @RequestBody String data
//    public ResResult addDFuncMenu(){
////        System.out.println(vo);
//        String str = UUID.randomUUID().toString().replace("-","");
//        System.out.println(str.substring(0,20));
//        DFuncMenuDO func = new DFuncMenuDO();
//        func.setPkFuncmenu(str.substring(0,20));
//        SystemVO vo =systemService.findOne("11111111111111111111");
////        func.setPkSystem(vo);
//        func.setPkSystem("11111111111111111111");
//        DFuncMenuDO menu = dFuncMenuService.findByPkFuncmenu("33333333333333333333");
//        func.setPkParent("33333333333333333333");
////        func.setPkParent(menu);
//        func.setCollected(Short.parseShort("0"));
//        func.setFuncCode("80H01001");
//        func.setFuncName("功能注册001");
//        func.setIcon("grey iconfont icon-appicon");
//        func.setIfPower(Short.parseShort("1"));
//        func.setMenuPath(null);
//        func.setIfEnabled(Short.parseShort("0"));
//        func.setMenuProperty("third_menu");
//        func.setIfFirstEnabled(Short.parseShort("0"));
//        dFuncMenuService.addDfuncMenu(func);
//        return ResultUtils.successWithData(func);
//    }
//
//    /**
//     * 修改菜单测试
//     * @return
//     */
//    @RequestMapping(value = "/updateDFuncMenu")
//    public ResResult updateDFuncMenu(){
//        DFuncMenuDO menu = dFuncMenuService.findByPkFuncmenu("55555555555555555555");
//        menu.setFuncName("功能注册");
//        dFuncMenuService.updateDfuncMenu(menu);
//        return ResultUtils.successWithData(menu);
//    }
//
//
//    /**
//     * 依据Pk删除数据
//     * @return
//     */
//    @RequestMapping(value = "/deleteDFuncMenu")
//    public String deleteDFuncMenu(){
//        dFuncMenuService.deleteDfuncMenu("55555555555555555555");
//        return "测试删除";
//    }

    /**
     * 测试查询
     */
    @RequestMapping(value = "/testvo")
    public ResResult testvo(){
        List<DFuncMenuVO> result = dFuncMenuService.getFuncmenu();
        return ResultUtils.successWithData(result);
    }

    /**
     * 测试vo转换do
     * @return
     */
    @RequestMapping(value ="testvo2")
    public ResResult testvo2(){
        List<DFuncMenuVO> list = dFuncMenuService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO dos = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(vo,DFuncMenuDO.class);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 测试vo转换do并执行更新操作
     * @return
     */
    @RequestMapping(value ="testvo3")
    @Transactional
    public ResResult testvo3(){
        List<DFuncMenuVO> list = dFuncMenuService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO dos = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(vo,DFuncMenuDO.class);
        dos.setMenuPath("test");
        dFuncMenuService.updateDFuncMenu(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 测试vo转换为dto
     * @return
     */
    @RequestMapping(value ="testvo4")
    public ResResult testvo4(){
        List<DFuncMenuVO> list = dFuncMenuService.getFuncmenu();
        List<DFuncMenuDTO> result =new ArrayList<>();
        for(DFuncMenuVO vo:list){
            DFuncMenuDTO dto = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(vo,DFuncMenuDTO.class);
            result.add(dto);
        }
        return ResultUtils.successWithData(result);
    }

    /**
     * 测试map转换为vo
     * @return
     */
    @RequestMapping(value ="testvo5")
    public ResResult testvo5(){
        List<DFuncMenuVO> list = dFuncMenuService.getFuncmenu();
        DFuncMenuVO vo = list.get(0);
        Map<String, Object> map = new HashMap<>();
        String[] attrilist = vo.getAttributeNames();
        for (String name: attrilist) {
            map.put(name,vo.getAttributeValue(name));
        }
        DFuncMenuVO newvo = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(map,DFuncMenuVO.class);
        return ResultUtils.successWithData(newvo);
    }


    /**
     * 测试vo转换do do加入另外数据 存储map 并重新转化为vo  即测试并行结果集转换子类对象vo
     * @return
     */
    @RequestMapping(value ="testvo6")
    public ResResult testvo6(){
        List<DFuncMenuVO> list = dFuncMenuService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO dos = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(vo,DFuncMenuDO.class);
        Map<String, Object> hmap = new HashMap<>();
        String[] arrlist = dos.getAttributeNames();
        for (String name: arrlist) {
            hmap.put(name,dos.getAttributeValue(name));
        }
        hmap.put("orgCode",vo.getPkOrg().getOrgCode());
        hmap.put("orgName",vo.getPkOrg().getOrgName());
        hmap.put("deptCode",vo.getPkDept().getDeptcode());
        hmap.put("deptName",vo.getPkDept().getDeptname());
        DFuncMenuVO resultvo = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(hmap,DFuncMenuVO.class);
        return ResultUtils.successWithData(resultvo);
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