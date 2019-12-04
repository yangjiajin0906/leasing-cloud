package com.leasing.sys.test;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;

import com.leasing.common.entity.sys.dto.ParamTypeDTO;
import com.leasing.common.refvo.sys.ParameterRefVO;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.sys.dao.dos.ParamTypeDO;
import com.leasing.sys.dao.dos.ParameterDO;
import com.leasing.sys.dao.query.ParameterQuery;
import com.leasing.sys.dao.vo.ParameterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    @Autowired
    TestParameterRepo testParameterRepo;

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
        List vos = parameterRepository.findByNativeName("Test.test");
        return ResultUtils.successWithData(vos);
    }



    //测试本地SQL
    @RequestMapping(value = "test16")
    ResResult test16(){
        String pk = "1001630";
        List vos = parameterRepository.findTest9(pk);
        return ResultUtils.successWithData(vos);
    }

    //测试本地SQL
    @RequestMapping(value = "test17")
    ResResult test17(){
        String pk = "1001630";
        List vos = parameterRepository.findTest10(pk);
        return ResultUtils.successWithData(vos);
    }


    //测试SQL分页
    @RequestMapping(value = "test18")
    ResResult test18(){
        Pagination pagination = new Pagination(2,20);
        ParameterQuery query = new ParameterQuery();
        query.setParamCode("21");
        query.setParamName("实际核销");
        List list = null;
        return ResultUtils.successWithData(list);
    }

    //测试SQL分页
    @RequestMapping(value = "test19")
    ResResult test19(){
        Pagination pagination = new Pagination(2,20);
        Page<ParameterDO> page = parameterRepository.findTest11(PageRequest.of(1,20));
        return ResultUtils.successWithData(page);
    }


    //测试SQL分页
    @RequestMapping(value = "test20")
    ResResult test20(){
        Pagination pagination = new Pagination(2,20);
        ParameterVO vo = new ParameterVO();
        vo.setParamCode("");
        Page<ParameterVO> page = parameterRepository.findTest12(PageRequest.of(1,20), Example.of(vo));
        return ResultUtils.successWithData(page);
    }




    //测试SQL分页
    @RequestMapping(value = "test21")
    ResResult test21(){
        Pagination pagination = new Pagination(2,20);
        ParameterVO vo = new ParameterVO();
        vo.setParamCode("");
        List<ParameterVO> list = testParameterRepo.findAll();
        return ResultUtils.successWithData(list);
    }


    //测试SQL分页
    @RequestMapping(value = "test23")
    ResResult test23(){
        ParameterVO vo = new ParameterVO();
        ParamTypeDTO dto = new ParamTypeDTO();
//        dto.setPkParamType("0001AA1000000000OY5C");
        dto.setParamType(255);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("paramCode", match -> match.exact());
        Pageable page = PageRequest.of(2,20);
        vo.setParamType(255);
        Example e = Example.of(vo,matcher);
        Page<ParameterVO> list = parameterRepository.findTest13(page,e);
//        Page<ParameterVO> list = parameterRepository.findAll(e,page);
        return ResultUtils.successWithData(list);
    }

    //测试SQL分页
    @RequestMapping(value = "test24")
    ResResult test24(){

        Pagination pagination = new Pagination(2,20);
        ParameterQuery query = new ParameterQuery();
//        query.setParamCode("31");
//        query.setParamType(255);
        query.setParamName("手续费");
        PageQueryData<ParameterVO> list = parameterRepository.pageQuery(pagination,query,"query111");
//        Page<ParameterVO> list = parameterRepository.findAll(e,page);
        return ResultUtils.successWithData(list);
    }


    //整体测试
    @RequestMapping(value = "test25")
    ResResult test25(){
        //测试分页
        Pagination pagination = new Pagination(2,20);
        ParameterQuery query = new ParameterQuery();
        query.setParamTypeA("000255");
        PageQueryData<ParameterVO> list = parameterRepository.pageQueryNative(pagination,query,"pagequery");


//        List<Map<String, Object>>  list1 = parameterRepository.findByNativeName("test1");
//        List<ParameterVO> list2 = parameterRepository.findByJPQLName(ParameterVO.class,"test2");
        ParameterVO vo = parameterRepository.findOne("0001AA10000000059Q9H",ParameterVO.class);
        return ResultUtils.successWithData(list);
    }

}



