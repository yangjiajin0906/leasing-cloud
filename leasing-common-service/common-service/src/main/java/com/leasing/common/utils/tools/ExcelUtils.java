package com.leasing.common.utils.tools;

import com.leasing.common.enums.excel.ExcelMatchType;
import com.leasing.common.service.common.ExcelHandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
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

    public static <T> List<T> convertExcel(File file, Class<T> clazz, Integer sheet, ExcelMatchType type){

        List<T> resultList = excelUtils.excelHandingService.convertToBeanList(file, clazz, sheet, type);
        return resultList;
    }
}
