package com.leasing.sys.controller;

import com.leasing.sys.service.SysTestService;
import com.leasing.sys.vo.SysTestVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-9-29
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class SysTestController {

    @Resource
    SysTestService sysTestService;

    @Transactional
    @RequestMapping(value = "/sysTest")
    public Map sysTest(){
        Map returnMap = new HashMap();
        SysTestVO vo = new SysTestVO();
        vo.setRiqi("2019-03-23");
        vo.setRiqishijian("2019-09-29 12:17:22");
        vo.setShuzi(BigDecimal.ONE);
        vo.setZifuchuan("my jpa data");
        sysTestService.insert(vo);
        Assert.isTrue(Boolean.FALSE,"my test assert");
        returnMap.put("findone",sysTestService.findOne(12345678L));
        return returnMap;
    }
}
