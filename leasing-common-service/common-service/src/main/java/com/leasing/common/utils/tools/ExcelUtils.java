package com.leasing.common.utils.tools;

import com.leasing.common.enums.excel.ExcelErrorEnum;
import com.leasing.common.enums.excel.ExcelMatchType;
import com.leasing.common.service.common.ExcelHandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-21
 * @author:lvcna@yonyou.com
 * @description: Excel常用工具类
 **/
@Component
public class ExcelUtils {

    public static ExcelUtils excelUtils;
    @Autowired
    ExcelHandingService excelHandingService;
    @PostConstruct
    public void init(){
        excelUtils = this;
    }

    public static <T> List<T> convertExcel(MultipartFile file, Class<T> clazz){
        List<T> resultList = excelUtils.excelHandingService.convertToBeanList(file, clazz);
        return resultList;
    }

    public static <T> List<T> convertExcel(MultipartFile file, Class<T> clazz, Integer sheet,ExcelMatchType type){
        List<T> resultList = excelUtils.excelHandingService.convertToBeanList(file, clazz, sheet, type);
        return resultList;
    }

    public static <T> List<T> convertExcel(InputStream is, String fileName, Class<T> clazz) throws IOException{
        List<T> resultList = excelUtils.excelHandingService.convertToBeanList(is, fileName, clazz);
        return resultList;
    }

    public static <T> List<T> convertExcelByName(InputStream is, String fileName, Class<T> clazz) throws IOException{
        List<T> resultList = excelUtils.excelHandingService.convertToBeanListName(is, fileName, clazz);
        return resultList;
    }

    /**
     * 转换Excel文件对象为业务对象,默认按注解顺序号来匹配
     * @param file
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convertExcel(File file, Class<T> clazz){
        //校验文件信息
        if(null == file || !file.exists()){
            throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
        }
        //获取文件流
        InputStream is = null;
        List<T> resultList = null;
        try {
            is = new FileInputStream(file);
            resultList = excelUtils.excelHandingService.convertToBeanList(is, file.getName(), clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ExcelErrorEnum.FILE_STREAM_FAIL.getMsg());
        } finally {
            if(null == is){
                throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
            } else {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(ExcelErrorEnum.FILE_STREAM_FAIL.getMsg());
                }
            }
        }

        return resultList;
    }


}
