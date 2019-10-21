package com.leasing.sys.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.refvo.sys.ParameterRefVO;
import com.leasing.common.utils.ResultUtils;
import com.leasing.sys.dao.dos.ParameterDO;
import com.leasing.sys.dao.repository.ParamTypeRepository;
import com.leasing.sys.dao.repository.ParameterRepository;
import com.leasing.sys.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "leasing/sys")
public class ParameterController {

    @Resource
    ParameterService parameterService;

    @Autowired
    ParamTypeRepository paramTypeRepository;
    @Autowired
    ParameterRepository parameterRepository;

    //标准外连接,出现典型N+1问题。
    @RequestMapping(value = "test1")
    ResResult test1(){
        String pk = "0";
        Object obj = parameterRepository.findTest(pk);
        return ResultUtils.successWithData(obj);
    }

    @RequestMapping(value = "test2")
    ResResult test2(){
        String pk = "0";
        Object obj = parameterRepository.findTest1(pk);
        return ResultUtils.successWithData(obj);
    }


    @RequestMapping(value = "test3")
    ResResult test3(){
        String pk = "0";
        Object obj = parameterRepository.findTest2(pk);
        return ResultUtils.successWithData(obj);
    }
    @RequestMapping(value = "test4")
    ResResult test4(){
        String pk = "1000012";
        Object obj = parameterRepository.findTest3(pk);
        return ResultUtils.successWithData(obj);
    }

    @RequestMapping(value = "test5")
    ResResult test5(){
        Object obj = parameterRepository.findAll();
        return ResultUtils.successWithData(obj);
    }


    //多级迫切左连接
    @RequestMapping(value = "test6")
    ResResult test6(){
        String pk = "1001630";
        Object obj = parameterRepository.findTest4(pk);
        return ResultUtils.successWithData(obj);
    }

    //迫切左连接下一层,开始出现N+1,必须通过fetch关键字到底层。
    @RequestMapping(value = "test7")
    ResResult test7(){
        String pk = "1001630";
        Object obj = parameterRepository.findTest5(pk);
        return ResultUtils.successWithData(obj);
    }


    //参照投影-自定义SQL-VO
    @RequestMapping(value = "test8")
    ResResult test8(){
        String pk = "19";
        Object obj = parameterRepository.findTest6(pk, ParameterRefVO.class);
        return ResultUtils.successWithData(obj);
    }

    //参照投影-动态类型
    @RequestMapping(value = "test9")
    ResResult test9(){
        String pk = "19";
        Object obj = parameterRepository.findByParamCode(pk,ParameterRefVO.class);
        return ResultUtils.successWithData(obj);
    }

    //参照投影-自定义SQL-DTO
    @RequestMapping(value = "test10")
    ResResult test10(){
        String pk = "19";
        Object obj = parameterRepository.findTest7(pk, ParameterRefVO.class);
        return ResultUtils.successWithData(obj);
    }

    //更新DO

    @RequestMapping(value = "test11")
    ResResult test11(){
        Object obj = parameterService.test1();
        return ResultUtils.successWithData(obj);
    }



}



