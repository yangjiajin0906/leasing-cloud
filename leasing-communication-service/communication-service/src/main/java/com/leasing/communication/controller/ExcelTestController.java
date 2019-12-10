package com.leasing.communication.controller;

import com.leasing.common.enums.excel.ExcelMatchType;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.service.CbContractService;
import com.leasing.communication.service.CbFileOssService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-27
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/excelTest")
public class ExcelTestController {

    @Resource
    CbContractService cbContractService;

    @Value("${test:default_name}")
    String test;

    @Value("${aliyun.oss.endPoint:default_name}")
    String mytest;

    @RequestMapping("import")
    public void importCustomerInfoTest(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\20191120-CONTRACT-1.xls";
        //解析excel
        File file = new File(filePath);
        InputStream inputStream = null;
        MultipartFile multipartFile = null;
        try {
            inputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile("20191120-CONTRACT-1.xls", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<CbContractImpDTO> list = ExcelUtils.convertExcel(multipartFile,CbContractImpDTO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");


        Long startTime1 = new Date().getTime();
        filePath = "E:\\20191120-CONTRACT-1.xlsx";
        //解析excel
        File file1 = new File(filePath);
        InputStream inputStream1 = null;
        MultipartFile multipartFile1 = null;
        try {
            inputStream1 = new FileInputStream(file1);
            multipartFile1 = new MockMultipartFile("20191120-CONTRACT-1.xlsx", inputStream1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<CbContractImpDTO> list1 = ExcelUtils.convertExcel(multipartFile1,CbContractImpDTO.class);
        Long endTime1 = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime1-startTime1)/1000 + "秒");
    }

    @RequestMapping("importName")
    public void importCustomerInfo(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\20191120-CONTRACT-1.xls";
        //解析excel
        File file = new File(filePath);
        InputStream inputStream = null;
        MultipartFile multipartFile = null;
        try {
            inputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile("20191120-CONTRACT-1.xls", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<CbContractImpDTO> list = ExcelUtils.convertExcel(multipartFile,CbContractImpDTO.class,0, ExcelMatchType.MatchTypeName);
        CbContractDO dos = DozerUtils.convert(list.get(0), CbContractDO.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    @RequestMapping("importS")
    public void importCustomerS(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\20191120-CONTRACT-1.xls";
        //解析excel
        File file = new File(filePath);
        InputStream inputStream = null;
        MultipartFile multipartFile = null;
        try {
            inputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile("20191120-CONTRACT-1.xls", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<CbContractImpDTO> list = cbContractService.dataImp(multipartFile);
        List<CbContractDO> dos = cbContractService.dataConvert(list);
        cbContractService.save(dos);
    }


    @RequestMapping("importT")
    public void importCustomerT(String filePath){
        Long startTime = new Date().getTime();
        filePath = "E:\\20191120-CONTRACT-1.xlsx";
        //解析excel
        File file = new File(filePath);
        InputStream inputStream = null;
        MultipartFile multipartFile = null;
        try {
            inputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile("20191120-CONTRACT-1.xlsx", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<CbContractImpDTO> list = cbContractService.dataImp(multipartFile);
        List<CbContractDO> dos = cbContractService.dataConvert(list);
        cbContractService.save(dos);
    }

    @RequestMapping("importA")
    public void importCustomerA(){

        List<CbContractVO> query = cbContractService.testQuery();
        query.toArray();
    }


    @Resource
    CbFileOssService cbFileOssService;
    @RequestMapping("importY")
    public void importCustomerY(){
        System.out.println(mytest);
        cbFileOssService.fileImportByDate();

    }


}
