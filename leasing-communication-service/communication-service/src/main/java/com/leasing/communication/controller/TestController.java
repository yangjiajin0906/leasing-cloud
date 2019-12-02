package com.leasing.communication.controller;

import com.leasing.communication.entity.Address;
import com.leasing.communication.entity.Person;
import com.leasing.communication.entity.dos.CacheVO;
import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.entity.dos.InvoiceApplyDO;
import com.leasing.communication.enums.Type;
import com.leasing.communication.service.CustomerService;
import com.leasing.communication.utils.EasyPoiUtils;
import com.leasing.communication.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @Resource
    CustomerService customerService;

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
            Person person = new Person("路飞"+i,Integer.valueOf("1"),"2019-11-1",new BigDecimal("10000"),Double.valueOf("100"),Long.valueOf("1"));
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
//        CacheVO<Person> cacheVO = new CacheVO<>();
//        cacheVO.setId("Person"+new Date().getTime());
//        cacheVO.setData(personList);
//        mongoTemplate.save(cacheVO);
//
//        Query query = new Query(Criteria.where("id").is(cacheVO.getId()));
//        List<CacheVO> list = mongoTemplate.find(query, CacheVO.class);
//        if(list.size() > 0){
//            List<Person> person = list.get(0).getData();
//        }
//        System.out.println(list.get(0).getData().size());
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
        for (int i =1; i<60000; i++){
            Address address = new Address("id"+i,"是撒按时是是水电费啥的啥的啥的"+i,"name"+i,new Date(),"nam发送到防守打法水电费水电费啥的水电费水电费啥的e"+i,"n发送到水电费水电费ame"+i
                    ,"啊实打实多"+i,"nam大声道阿萨德阿萨德阿萨德e"+i,"nad阿萨德阿萨德阿萨德按时打算打ame"+i,"na啥的发送到啥的水电费水电费啥的me"+i,"name"+i,"name"+i,"name"+i,"name"+i,"na发送到啥的防守打法水电费是否me"+i
                    ,"按时打算"+i,"na阿萨德阿萨德阿萨德按时me"+i,"na啊阿萨德撒阿萨德me"+i,"name"+i,"nam啥的防守打法是是e"+i,"na撒大声地发送到发送到me"+i,"na啥的啥的啥的啥的me"+i,"na啥的发顺丰啥的是否me"+i,"n啥的防守打法啥的发送ame"+i
                    ,"按时打算按时按时按时"+i,"na按时阿萨德啊啊me"+i,"na水电费水电费水电费啥的发送到防守打法me"+i,"na撒大声地防守打法水电费me"+i,"na是防守打法水电费me"+i,"name"+i,"name"+i,"name"+i,"na盛世嫡妃水电费啥的是饭me"+i
                    ,"按时按时按时按时按时"+i,"na打阿萨德按时按时me"+i,"n啥的 少奋斗啥的水电费啥的水电费水电费ame"+i,"nam啥的水电费水电费e"+i,"na啥的 水电费啥的me"+i,"nam三十多啥的e"+i,"na啥的是啥的 水电费水电费水电费me"+i,"name"+i
                    ,"nam按时打算啊按时e"+i,"n按时阿萨德按时打算ame"+i,"nam啥的防守打法水电费水电费水电费啥的水电费e"+i,"na啥的防守打法me"+i,"na撒大声地水电费me"+i,"na啥的防守打法me"+i,"na水电费水电费水电费水电费me"+i,"n水电费啥的防守打法水电费水电费ame"+i);
            personList.add(address);
        }
        //导出操作
        EasyPoiUtils.exportExcel(personList,"花名册","草帽一伙",Address.class,"海贼王test.xlsx",response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+personList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("importExcelXLSXTest")
    public void importExcelXLSXTest(){
//        String filePath = "E:\\excel\\客户test.xlsx";
//        String filePath2 = "E:\\excel\\收款信息test.xlsx";
//        String filePath3 = "E:\\excel\\付款信息test.xlsx";
        String filePath4 = "E:\\excel\\票据信息test.xlsx";
//        String filePath5 = "E:\\excel\\合同信息test.xls";
//        String filePath6 = "E:\\excel\\租金计划test.xls";
        //解析excel，
//        List<CustomerDO> personList = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
//        List<CapitalDO> personList2 = EasyPoiUtils.importExcel(filePath2,1,1,CapitalDO.class);
//        List<WithdrawDO> personList3 = EasyPoiUtils.importExcel(filePath3,1,1,WithdrawDO.class);
        List<InvoiceApplyDO> personList4 = EasyPoiUtils.importExcel(filePath4,1,1,InvoiceApplyDO.class);
//        List<ContractDO> personList5 = EasyPoiUtils.importExcel(filePath5,1,1,ContractDO.class);
//        List<InoutPlanDO> personList6 = EasyPoiUtils.importExcel(filePath6,1,1,InoutPlanDO.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList4.size()+"】行");
    }


    @RequestMapping("importCustomerInfo2")
    public void importCustomerInfo2(MultipartFile file){

        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\客户.xls";
        //解析excel
        List<CustomerDO> cList = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+cList.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("exportCus")
    public void exportCus(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<CustomerDO> personList = new ArrayList<>();
        for (int i =1; i<60000; i++){
            CustomerDO customer = new CustomerDO(null,"0114" + i
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
        EasyPoiUtils.exportExcel(personList,"客户信息","客户",CustomerDO.class,"客户.xls",response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 将list保存在Oracle
     * @author Yangjiajin
     * @date 2019/11/14 10:50
     * @param [list]
     * @return void
     */
    private void saveOracle(List<CustomerDO> list){
        customerService.save(list);
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCustomerInfoTest")
    public void importCustomerInfoTest(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\excel\\客户.xls";
        //解析excel
        List<CustomerDO> list = EasyPoiUtils.importExcel(filePath,1,1,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCustomerInfoTest2")
    public void importCustomerInfoTest2(MultipartFile multipartFile) throws IOException {
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\客户.xlsx";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), inputStream);
        //解析excel
        List<CustomerDO> list = EasyPoiUtils.importExcel(multipartFile,1,1,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 导出
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("exportPoi")
    public void exportPoi(HttpServletResponse response){
        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        for (int i =1; i<100000; i++){
            Person person = new Person("路飞"+i,Integer.valueOf("1"),"2019-11-1",new BigDecimal("10000"),Double.valueOf("100"),Long.valueOf("1"));
            personList.add(person);
        }
        //导出操作
        ExcelUtil.exportExcel("Person",personList,Person.class, Type.XLS_X,response);
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param [response]
     * @return void
     */
    @RequestMapping("importPoi")
    public void importPoi(MultipartFile multipartFile) throws IOException {
        String strUrl = "E:\\excel\\Person.xlsx";
        File file = new File(strUrl);
        InputStream inputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), inputStream);
        //导入操作
        List<Person> personList = ExcelUtil.importExcel(multipartFile,Person.class);
        System.out.println(personList.size());
    }

    @RequestMapping("exportCusPoi")
    public void exportCusPoi(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<CustomerDO> personList = new ArrayList<>();
        for (int i =1; i<60000; i++){
            CustomerDO customer = new CustomerDO(null,"0114" + i
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
        ExcelUtil.exportExcel("CUSTOMER",personList,CustomerDO.class, Type.XLS,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("exportCusPoi2")
    public void exportCusPoi2(HttpServletResponse response){
        Long startTime = new Date().getTime();
        //模拟从数据库获取需要导出的数据
        List<CustomerDO> personList = new ArrayList<>();
        for (int i =1; i<20000; i++){
            CustomerDO customer = new CustomerDO(null,"0114" + i
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
        ExcelUtil.exportExcel("CUSTOMER",personList,CustomerDO.class, Type.XLS_X,response);
        Long endTime = new Date().getTime();
        System.out.println("导出了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCus2")
    public void importCus2(MultipartFile multipartFile) throws IOException {
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\CUSTOMER.xlsx";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), inputStream);
        //解析excel
        List<CustomerDO> list = ExcelUtil.importExcel(multipartFile,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCus")
    public void importCus(MultipartFile multipartFile) throws IOException {
        Long startTime = new Date().getTime();
        String filePath = "E:\\excel\\CUSTOMER.xls";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), inputStream);
        //解析excel
        List<CustomerDO> list = ExcelUtil.importExcel(multipartFile,CustomerDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

}