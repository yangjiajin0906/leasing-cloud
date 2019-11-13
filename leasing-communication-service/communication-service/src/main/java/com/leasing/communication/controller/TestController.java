package com.leasing.communication.controller;

import com.leasing.communication.entity.Address;
import com.leasing.communication.entity.Person;
import com.leasing.communication.entity.dos.CacheVO;
import com.leasing.communication.utils.EasyPoiUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
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

    @Autowired
    private GridFsTemplate gridFsTemplate;

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

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        int ftest = 3;//每次取的数据
        int size = list.size();
        int temp = size / ftest + 1;
        boolean special = size % ftest == 0;
        List<String> cutList = null;
        for (int i = 0; i < temp; i++) {
            if (i == temp - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(ftest * i, size);
            } else {
                cutList = list.subList(ftest * i, ftest * (i + 1));
            }
            System.out.println("第" + (i + 1) + "组：" + cutList.toString());
        }
    }

    @RequestMapping("importExcel2")
    public void importExcel2(){
        Long startTime = new Date().getTime();
        String filePath = "E:\\海贼王test.xlsx";
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(filePath,1,1,Address.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
        CacheVO<Address> cacheVO = new CacheVO<>();
        cacheVO.setId("Address"+new Date().getTime());
        cacheVO.setData(personList);
        redisTemplate.opsForValue().set(cacheVO.getId(),cacheVO);

        CacheVO cacheVO1 = (CacheVO)redisTemplate.opsForValue().get(cacheVO.getId());
        List<Person> person = cacheVO1.getData();
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "s");
    }

    @RequestMapping("importExcel3")
    public void importExcel3(MultipartFile mFile){
        Long startTime = new Date().getTime();
        String filePath = "E:\\海贼王test.xlsx";
        File file = new File(filePath);
        //解析excel，
        List<Address> personList = EasyPoiUtils.importExcel(mFile,1,1,Address.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
        //TODO 保存数据库
        CacheVO<Address> cacheVO = new CacheVO<>();
        cacheVO.setId("Address"+new Date().getTime());
        cacheVO.setData(personList);
        redisTemplate.opsForValue().set(cacheVO.getId(),cacheVO);

        CacheVO cacheVO1 = (CacheVO)redisTemplate.opsForValue().get(cacheVO.getId());
        List<Person> person = cacheVO1.getData();
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
    @RequestMapping("export2")
    public void export2(HttpServletResponse response){
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
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xlsx",response);
    }
}