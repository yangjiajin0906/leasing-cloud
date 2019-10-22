package com.leasing.sys.test;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.refvo.sys.ParameterRefVO;
import com.leasing.common.utils.ResultUtils;
import com.leasing.sys.dao.dos.ParamTypeDO;
import com.leasing.sys.dao.dos.ParameterDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "leasing/sys")
public class TestParameterController {

    @Resource
    TestParameterService parameterService;

    @Autowired
    TestParamTypeRepository paramTypeRepository;
    @Autowired
    TestParameterRepository parameterRepository;

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
        ParameterDO dods = null;
        List<ParameterDO> obj = parameterRepository.findAll();
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
        String pk = "23";
        Object obj = parameterRepository.findTest7(pk, ParameterRefVO.class);
        return ResultUtils.successWithData(obj);
    }

    //更新DO

    @RequestMapping(value = "test11")
    ResResult test11(){
        Object obj = parameterService.test1();
        return ResultUtils.successWithData(obj);
    }

    //批量更新DO
    @RequestMapping(value = "test12")
    ResResult test12(){
        String pk = "1001630";
        List<ParameterDO> vos = parameterRepository.findTest8(pk);
        vos.remove(vos.size() - 1);
        parameterRepository.saveAll(vos);
        return ResultUtils.successWithData(vos);
    }


    //级联问题处理
    @RequestMapping(value = "test13")
    ResResult test13(){
        String pk = "0001AA100000000Q3LM8";
        //获取主表数据,同时获取级联的子表集合
        ParamTypeDO vo = paramTypeRepository.findOne(pk);
        //获取子表集合中一条数据
        ParameterDO parameterDO = vo.getParameter().get(1);
        //从主表的子集中删除此条数据
        vo.getParameter().remove(parameterDO);
        //保存主表业务对象，由框架来处理子集级联。
        paramTypeRepository.save(vo);
        return ResultUtils.successWithData(vo);
    }


    //测试本地JPQL
    @RequestMapping(value = "test14")
    ResResult test14(){
        String pk = "1001630";
        String jpql = "select d,pe.paramVarname from ParameterDO d " +
                " left join ParamTypeDO pe on d.pkParamType = pe.pkParamType " +
                " where pe.pkParamType = '0001AA1000000001346I' ";
//        List vos = parameterRepository.findByJPQL(jpql);
        List vos = null;
        return ResultUtils.successWithData(vos);
    }


    //测试本地SQL
    @RequestMapping(value = "test15")
    ResResult test15(){
        String pk = "1001630";
        String sql = "select D.* from YLS_PARAMETER d " +
                " left join YLS_PARAM_TYPE pe on d.pk_param_type = pe.pk_param_type " +
                " where pe.pk_param_type = '0001AA1000000001346I' ";
        List vos = parameterRepository.findByNativeSql(sql);
        return ResultUtils.successWithData(vos);
    }



    //测试本地SQL
    @RequestMapping(value = "test16")
    ResResult test16(){
        String pk = "1001630";
        List vos = parameterRepository.findTest9(pk);
        return ResultUtils.successWithData(vos);
    }

}



