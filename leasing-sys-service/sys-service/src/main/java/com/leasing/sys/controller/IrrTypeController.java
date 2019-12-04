package com.leasing.sys.controller;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.service.sys.IrrTypeService;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.dos.IrrEventSetDO;
import com.leasing.common.entity.common.dos.IrrTypeDO;
import com.leasing.common.entity.common.vo.IrrTypeVO;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/irrtype")
public class IrrTypeController {
    @Autowired
    IrrTypeService irrTypeService;

    /**
     * 获取事件类别对Irr影响列表
     * @return PageQueryData
     */
    @RequestMapping(value = "ListIrrType")
    public ResResult ListIrrType(){
        PageQueryData<IrrTypeVO> result = irrTypeService.ListIrrType();
        return ResultUtils.successWithData(result);
    }

    /**
     *传入pk值查询对应vo的子表
     */
    @RequestMapping(value = "getIrrType")
    public ResResult getIrrType(@RequestBody String pk){
        IrrTypeDO dos = irrTypeService.getIrrTypeDO(pk);
        return ResultUtils.successWithData(dos.getIrrEventSet());
    }

    /**
     * 更新事件类别对Irr影响对象
     * @return dos
     */
    @RequestMapping(value = "updateIrrType")
    public ResResult updateIrrType(){
        IrrTypeVO vo = irrTypeService.getIrrType("0001AA100000000070BO");
        IrrTypeDO dos = DozerUtils.convert(vo,IrrTypeDO.class);
        dos.setIrrModel(Short.parseShort("0"));
        irrTypeService.updateIrrType(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 保存事件类别对Irr影响对象
     * @return dos
     */
    @RequestMapping(value = "saveIrrType")
    public ResResult saveIrrType(){
        IrrTypeVO vo =new IrrTypeVO();
        String str = UUID.randomUUID().toString().replace("-","");
        vo.setPkIrrType(str.substring(0,20));
        vo.setIrrTypeName(Short.parseShort("1"));
        vo.setIrrModel(Short.parseShort("0"));
        vo.setBillstatus(Short.valueOf("20"));
        OrgDTO dto = new OrgDTO();
        dto.setPkOrg("1003");
        vo.setPkOrg(dto);
        vo.setMemo("测试增加影响数据");
        IrrEventSetDO eventdo = new IrrEventSetDO();
        List<IrrEventSetDO> list = new ArrayList<>();
        String str2 = UUID.randomUUID().toString().replace("-","");
        eventdo.setPkIrrEventSet(str2.substring(0,20));
        eventdo.setPkIrrType(vo.getPkIrrType());
        eventdo.setPkEventType("0001AA10000000053XWW");
        eventdo.setVal(Short.parseShort("1"));
        list.add(eventdo);
        vo.setIrrEventSet(list);
        IrrTypeDO dos = DozerUtils.convert(vo,IrrTypeDO.class);
        irrTypeService.saveIrrType(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 删除事件对Irr影响对象
     * @return dos
     */
    @RequestMapping(value = "deleteIrrType")
    public ResResult deleteIrrType(){   //前台传pk后台直接查DO 否则会报错
//        IrrTypeVO vo = irrTypeService.getIrrType("0001AA10000000008RL4");
//        IrrTypeDO dos = DozerUtils.convert(vo,IrrTypeDO.class);
        IrrTypeDO dos = irrTypeService.getIrrTypeDO("0001AA100000000CWXNK");
        irrTypeService.deleteIrrType(dos);
        return ResultUtils.successWithData(dos);
    }

}