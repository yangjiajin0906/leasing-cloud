package com.leasing.communication.controller;

import com.leasing.communication.entity.Address;
import com.leasing.communication.entity.Person;
import com.leasing.communication.utils.EasyPoiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
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


    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param []
     * @return void
     */
    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "E:\\海贼王.xlsx";
        //解析excel，
        List<Person> personList = EasyPoiUtils.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
    }

    @RequestMapping("importExcel2")
    public void importExcel2(){
        String filePath = "E:\\海贼王test.xlsx";
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(filePath,1,1,Address.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
    }

    /**
     * @description 导出
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("export2")
    public void export2(HttpServletResponse response){
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
    }


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
        for (int i =1; i<100000; i++){
            Person person = new Person("路飞"+i,1,new Date(), BigDecimal.valueOf(1000000.00),1.00,Long.valueOf("1"));
            personList.add(person);
        }
        //导出操作
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xlsx",response);
    }
}