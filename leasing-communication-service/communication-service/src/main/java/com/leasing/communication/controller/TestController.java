package com.leasing.communication.controller;

import com.leasing.communication.entity.Address;
import com.leasing.communication.entity.Person;
import com.leasing.communication.entity.dos.*;
import com.leasing.communication.utils.EasyPoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication")
public class TestController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    /**
     * @description 导出
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("export")
    public void export(HttpServletResponse response){
        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        for (int i =1; i<10; i++){
            Person person = new Person("路飞"+i,Short.valueOf("2")
                    ,"5sa54da5sdaaa"+i,"2019-11-1"+i,"2019-11-1"+i,"100"+i,"sdadas25d5sf5sdf5sd"+i);
            personList.add(person);
        }
        //导出操作
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param []
     * @return void
     */
    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "E:\\excel\\海贼王.xls";
        //解析excel，
        List<Person> personList = EasyPoiUtils.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
        CacheVO<Person> cacheVO = new CacheVO<>();
        cacheVO.setId("Person"+new Date().getTime());
        cacheVO.setData(personList);
        mongoTemplate.save(cacheVO);

        Query query = new Query(Criteria.where("id").is(cacheVO.getId()));
        List<CacheVO> list = mongoTemplate.find(query, CacheVO.class);
        if(list.size() > 0){
            List<Person> person = list.get(0).getData();
        }
        System.out.println(list.get(0).getData().size());
    }


    @RequestMapping("importExcel4")
    public void importExcel4(){
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\海贼王test.xlsx";
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(filePath,1,1,Address.class);
        //TODO 保存数据库
        int aSingle = 10000; //单次处理一万条数据
        int size = personList.size();
        int theTotalNumber = size / aSingle + 1; //总共处理次数
        boolean special = size % aSingle == 0; //是否整除
        List<Address> cutList = null;
        for (int i = 0; i < theTotalNumber; i++) {
            if (i == theTotalNumber - 1) {
                if (special) {
                    break;
                }
                cutList = personList.subList(aSingle * i, size);
            } else {
                cutList = personList.subList(aSingle * i, aSingle * (i + 1));
            }
            System.out.println("第" + (i + 1) + "组：" + cutList.size());
            this.saveMongo(cutList);
        }
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "s");
    }

    private void saveMongo(List<Address> list){
        CacheVO<Address> cacheVO = new CacheVO<>();
        cacheVO.setId("Address"+new Date().getTime());
        cacheVO.setTag(0);
        cacheVO.setData(list);
        mongoTemplate.save(cacheVO,"address");
    }

    @RequestMapping("getData")
    public void getData(){
        Long startTime = new Date().getTime();
        Query query = new Query(Criteria.where("tag").is(0));
        List<CacheVO> list = mongoTemplate.find(query, CacheVO.class,"address");
        Long endTime = new Date().getTime();
        System.out.println("查询出【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "s");
    }

    @RequestMapping("update")
    public void update(){
        Long startTime = new Date().getTime();
        Query query = new Query(Criteria.where("tag").is(0));
        Update update = new Update().inc("tag", 1);
        mongoTemplate.updateMulti(query, update,CacheVO.class,"address");
        Long endTime = new Date().getTime();
        System.out.println("共计用时"+(endTime-startTime)/1000 + "s");
    }

    @RequestMapping("importExcelXLS")
    public void importExcelXLS(){
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\海贼王test.xls";
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(filePath,1,1,Address.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "s");
    }


    /**
     * @description 导出
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("exportXLS")
    public void exportXLS(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Address> personList = new ArrayList<>();
        for (int i =1; i<100000; i++){
            Address address = new Address("id"+i,"type"+i,"name"+i,new Date(),"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i);
            personList.add(address);
        }
        //导出操作
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Address.class,"海贼王test.xls",response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("importExcelXLSX")
    public void importExcelXLSX(){
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\海贼王test.xlsx";
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(filePath,1,1,Address.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "s");
    }

    /**
     * @description 导出
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("exportXLSX")
    public void exportXLSX(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<Address> personList = new ArrayList<>();
        for (int i =1; i<100000; i++){
            Address address = new Address("id"+i,"type"+i,"name"+i,new Date(),"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i
                    ,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i);
            personList.add(address);
        }
        //导出操作
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Address.class,"海贼王test.xlsx",response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("importExcelXLSXTest")
    public void importExcelXLSXTest(){
        String filePath = "E:\\excel\\客户test.xlsx";
        String filePath2 = "E:\\excel\\收款信息test.xlsx";
        String filePath3 = "E:\\excel\\付款信息test.xlsx";
        String filePath4 = "E:\\excel\\票据信息test.xlsx";
        String filePath5 = "E:\\excel\\合同信息test.xls";
        String filePath6 = "E:\\excel\\租金计划test.xls";
        //解析excel，
        List<CustomerDO> personList = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
        List<CapitalDO> personList2 = EasyPoiUtils.importExcel(filePath2,1,1,CapitalDO.class);
        List<WithdrawDO> personList3 = EasyPoiUtils.importExcel(filePath3,1,1,WithdrawDO.class);
        List<InvoiceApplyDO> personList4 = EasyPoiUtils.importExcel(filePath4,1,1,InvoiceApplyDO.class);
        List<ContractDO> personList5 = EasyPoiUtils.importExcel(filePath5,1,1,ContractDO.class);
        List<InoutPlanDO> personList6 = EasyPoiUtils.importExcel(filePath6,1,1,InoutPlanDO.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
    }

}