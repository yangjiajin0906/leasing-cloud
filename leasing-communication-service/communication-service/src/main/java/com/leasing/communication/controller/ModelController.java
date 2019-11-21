package com.leasing.communication.controller;

import com.leasing.communication.entity.dos.*;
import com.leasing.communication.enums.Type;
import com.leasing.communication.utils.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/19
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/model")
public class ModelController {

    /**
     * @description 客户
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportCus")
    public void exportCus(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Customer2DO> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            Customer2DO customer = new Customer2DO(null,"0114" + i
                    ,"客户" + i, i,"86929488-"+i, "1988-01-23", "签发机关"+i
                    ,i,2+i,0,i,"1385555777"+i,1,"子女情况"+i
                    ,"子女上学情况"+i,"行业类型"+i,i,"高薪职业"+i
                    ,"户籍地址"+i,"居住地址"+i,"单位名称"+i
                    ,"单位地址"+i,"单位性质"+i,20+i,20+i
                    ,1,"产权所有人"+i, new BigDecimal("108.50")
                    ,"房产所在地"+i,"详细地址"+i,"房产性质"+i
                    ,"房产区域"+i, new BigDecimal("200000.00"),"2019-08-23"
                    ,"征信对象类型"+i,"征信结果"+i,"征信原因描述"+i
                    ,"征信评分"+i,"征信编号"+i,"2019-08-23","张三"+i
                    ,"189393324"+i,i,"北京市"+i,"李四"+i
                    ,i,"152301444488889999",20+i,"13855556666"
                    ,+i,"北京XX银行"+i,"2132432444"+i
                    ,"北京市"+i,"配偶单位性质"+i
                    ,"王五"+i,i,"1232434354364564","2019-01-23"
                    ,i,20+i,"34534524324"+i,"1329635444"+i
                    , new BigDecimal("67.89"),i
                    ,"天津市"+i,"XX科技公司"+i
                    ,"XXX区XX号"+i, "1546777885"+i
                    , "担保人担保能力说明"+i,"王五"+i, "3855426555555587777"+i
                    , "XXX银行"+i, "BANK888888"+i,"18544412222");
            personList.add(customer);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("CUSTOMER",personList,Customer2DO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 合同
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportCon")
    public void exportCon(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Contract2DO> personList = new ArrayList<>();
        for (int i =1; i<100000; i++){
            Contract2DO contract2DO = new Contract2DO(null,1,1,"集团名称"+i
                    ,"0001MG0000000006283"+i,"客户名称"+i,"15222119901104221"+i,1
                    ,"2013-11-01","2013-11-05","2013-11-10","2013-11-15"
                    ,1,1,new BigDecimal("1067704.00"),new BigDecimal("352539.00")
                    ,new BigDecimal("2414602.34"),0,new BigDecimal("55.62342"),new BigDecimal("73.24283")
                    ,1,1,"XX商贸有限公司"+i,"63252340050519"+i
                    ,"XXX股份有限公司"+i,1,"62832340398215"+i
                    ,"北京望京支行"+i,1,"XXX科技有限公司"+i
                    ,new BigDecimal("423.472399"),new BigDecimal("12257.62"),1,"手机"+i
                    ,"手机"+i);

            personList.add(contract2DO);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("CONTRACT",personList,Contract2DO.class, Type.XLS_X,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 收款
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportCap")
    public void exportCap(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Capital2DO> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            Capital2DO capitalDO = new Capital2DO(null,"0001MG0000000006283"+i,"合同名称"+i,"客户名称"+i,"单位名称"+i
                    ,"2014-04-04",1,1,1,"2014-04-06",new BigDecimal("1067704.00"),new BigDecimal("1007704.00"),new BigDecimal("60000.00"),new BigDecimal("1007704.00")
                    ,new BigDecimal("1067704.00"),"2014-05-04",1,"2014-05-04","招商银行"+i,"63252340050519"+i,new BigDecimal("1067704.00"),new BigDecimal("1067704.00"),new BigDecimal("1007704.00")
                    ,new BigDecimal("60000.00"),1,"0001MG0000000006283"+i,"中建投租赁股份有限公司");

            personList.add(capitalDO);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("CAPITAL",personList,Capital2DO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 付款
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportWit")
    public void exportWit(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Withdraw2DO> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            Withdraw2DO capitalDO = new Withdraw2DO(null,"0001MG0000000006283"+i
                    ,"合同名称"+i,"方超"+i,"63252340050519"+i
                    ,"北京望京支行"+i,"63252340050626"+i,"张三"+i
                    ,"单位名称"+i,"2014-04-06"
                    ,new BigDecimal("1067704.00"),1,new BigDecimal("1067704.00"),"62258940050682"+i
                    ,"2014-04-10","0001MG0000000006283"+i,"中建投租赁股份有限公司");
            personList.add(capitalDO);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("WITHDRAW",personList,Withdraw2DO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 票据
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportInv")
    public void exportInv(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<InvoiceApply2DO> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            InvoiceApply2DO capitalDO = new InvoiceApply2DO(null,"0001MG0000000006283"+i,"合同名称"+i,"发票抬头"+i,"17593064038563753"+i
                    ,"北京"+i,"1514761642"+i,"北京望京支行"+i,"63252340050626"+i,"上海"+i,"张三"+i,"单位名称"+i,1,1
                    ,"2015-04-10",new BigDecimal("0.21"),new BigDecimal("9619.29"),new BigDecimal("312321.42"),1,1,"中建投租赁股份有限公司"
            );
            personList.add(capitalDO);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("INVOICEAPPLY",personList,InvoiceApply2DO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 租金计划
     * @author Yangjiajin
     * @date 2019/11/19 11:51
     * @param [response]
     * @return void
     */
    @RequestMapping("exportIno")
    public void exportIno(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<InoutPlan2DO> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            InoutPlan2DO capitalDO = new InoutPlan2DO(null, "CONT_CODE" + i, i, i, i, "2019-01-23"
                    , new BigDecimal("78.55"), new BigDecimal("99.33"), new BigDecimal("67.89"), "2019-01-23", new BigDecimal("444.44")
                    , new BigDecimal("123.45"), new BigDecimal("666.98"), new BigDecimal("456.98"), new BigDecimal("55.77")
                    , "CHNFGHSERFFFGHFRDSED");
            personList.add(capitalDO);
        }
        int size = personList.size();
        //导出操作
        ExcelUtil.exportExcel("INOUTPLAN",personList,InoutPlan2DO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }
}