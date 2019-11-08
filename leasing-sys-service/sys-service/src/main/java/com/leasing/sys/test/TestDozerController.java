package com.leasing.sys.test;

import com.leasing.common.base.entity.AbstractBaseEntity;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.dto.DFuncMenuDTO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.common.entity.common.vo.SystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class TestDozerController {
    @Autowired
    TestDozerService testDozerService;

    @Autowired
    TestParamTypeRepository paramTypeRepository;

    /**
     * vo转换do
     * @return
     */
    @RequestMapping(value ="testdozer")
    public ResResult testdozer(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO dos = DozerUtils.convert(vo,DFuncMenuDO.class);
        return ResultUtils.successWithData(dos);
    }

    /**
     * do转vo 使用vo转do的同套配置
     * @return
     */
    @RequestMapping(value ="testdozer1")
    @Transactional
    public ResResult testdozer1(){
        DFuncMenuDO dos = testDozerService.findByPkFuncmenu("824f6343a4334fa6a1d4");
        DFuncMenuVO vo = DozerUtils.convert(dos,DFuncMenuVO.class);
        return ResultUtils.successWithData(vo);
    }

    /**
     * vo转换为dto
     * @return
     */
    @RequestMapping(value ="testdozer2")
    public ResResult testdozer2(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        List<DFuncMenuDTO> result =new ArrayList<>();
        for(DFuncMenuVO vo:list){
            DFuncMenuDTO dto = DozerUtils.convert(vo,DFuncMenuDTO.class);
            result.add(dto);
        }
        return ResultUtils.successWithData(result);
    }

    /**
     * map转换为vo
     * @return
     */
    @RequestMapping(value ="testdozer3")
    public ResResult testdozer3(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO dos = DozerUtils.convert(vo,DFuncMenuDO.class);
        Map<String, Object> hmap = new HashMap<>();
        String[] arrlist = dos.getAttributeNames();
        for (String name: arrlist) {
            hmap.put(name,dos.getAttributeValue(name));
        }
        hmap.put("orgCode",vo.getPkOrg().getOrgCode());
        hmap.put("orgName",vo.getPkOrg().getOrgName());
        hmap.put("deptCode",vo.getPkDept().getDeptcode());
        hmap.put("deptName",vo.getPkDept().getDeptname());
        DFuncMenuVO resultvo = DozerUtils.convert(hmap,DFuncMenuVO.class);
        return ResultUtils.successWithData(resultvo);
    }


    /**
     * vo转换为不同类型vo
     */
    @RequestMapping(value ="testdozer4")
    public ResResult testdozer4(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        SystemVO resultvo = DozerUtils.convert(vo,SystemVO.class);
        return ResultUtils.successWithData(resultvo);
    }

    /**
     * vo转do时存在不同对象转换(设置转化)  更改DO文件后测试
     */
    @RequestMapping(value ="testdozer5")
    public ResResult testdozer5(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuDO resultdo = DozerUtils.convert(vo,DFuncMenuDO.class);
        return ResultUtils.successWithData(resultdo);
    }

    /**
     * do转vo时存在不同对象转换(配置名称可转化)
     */
    @RequestMapping(value ="testdozer6")
    public ResResult testdozer6(){
        DFuncMenuDO dos = testDozerService.findByPkFuncmenu("824f6343a4334fa6a1d4");
        DFuncMenuVO resultvo = DozerUtils.convert(dos,DFuncMenuVO.class);
        return ResultUtils.successWithData(resultvo);
    }


    @RequestMapping(value= "testa7")
    public ResResult testa7(){
        List<DFuncMenuVO> list = testDozerService.getFuncmenu();
        DFuncMenuVO vo=list.get(0);
        DFuncMenuVO newvo = (DFuncMenuVO) vo.clone();

        List<String> list1 = vo.differentColumn((AbstractBaseEntity)newvo,null);
        vo.setFuncCode("321321");
        vo.setFuncName("dsal2高达五千");
        vo.getPkSystem().setSystemCode("321421jlk");
        newvo.getPkSystem().setSystemName("测试修改");
        System.out.println("复制后未修改任何值:"+list1.toString());
        List<String> list2 = vo.differentColumn((AbstractBaseEntity)newvo,null);
        System.out.println("复制后修改部分值:"+list2.toString());
        return ResultUtils.successWithData(list);
    }
}