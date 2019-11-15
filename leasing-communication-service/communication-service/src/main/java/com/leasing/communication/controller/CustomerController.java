package com.leasing.communication.controller;

import com.leasing.communication.entity.Address;
import com.leasing.communication.entity.dos.CacheVO;
import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.service.CustomerService;
import com.leasing.communication.utils.EasyPoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCustomerInfo")
    public void importCustomerInfo(String filePath){
        filePath = "E:\\excel\\客户.xlsx";
        //解析excel
        List<CustomerDO> cList = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
        int aSingle = 10000; //单次处理一万条数据
        int size = cList.size();
        int theTotalNumber = size / aSingle + 1; //总共处理次数
        boolean special = size % aSingle == 0; //是否整除
        List<CustomerDO> cutList = null;
        for (int i = 0; i < theTotalNumber; i++) {
            if (i == theTotalNumber - 1) {
                if (special) {
                    break;
                }
                cutList = cList.subList(aSingle * i, size);
            } else {
                cutList = cList.subList(aSingle * i, aSingle * (i + 1));
            }
            this.saveMongo(cList);
            System.out.println("第" + (i + 1) + "组：" + cutList.size());
        }
    }

    /**
     * @description 将list保存在Mongo
     * @author Yangjiajin
     * @date 2019/11/14 10:50
     * @param [list]
     * @return void
     */
    private void saveMongo(List<CustomerDO> list){
        CacheVO<CustomerDO> cacheVO = new CacheVO<>();
        cacheVO.setId("Customer"+new Date().getTime());
        cacheVO.setTag(0);
        cacheVO.setData(list);
        mongoTemplate.save(cacheVO);
    }

    @RequestMapping("export")
    public void export(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<CustomerDO> personList = new ArrayList<>();
        for (int i =1; i<60000; i++){
            CustomerDO customer = new CustomerDO("0001MG0000000002911" + i,"0114" + i
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
                    , "XXX银行"+i, "BANK888888"+i);
            personList.add(customer);
        }
        int size = personList.size();
        //导出操作
        EasyPoiUtils.exportExcel(personList,"客户信息","客户",CustomerDO.class,"客户.xlsx",response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("importCustomerInfo2")
    public void importCustomerInfo2(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\excel\\客户.xlsx";
        //解析excel
        List<CustomerDO> cList = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+cList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }
}