package com.leasing.common.service.common;

import com.leasing.common.enums.excel.ExcelMatchType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-21
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface ExcelHandingService<T> {

    /**
     * 将Excel文件流转换为相应的JAVA Bean，默认按顺序来匹配
     * @param file
     * @param clazz
     * @return
     */
    List<T> convertToBeanList(MultipartFile file, Class<T> clazz);


    /**
     * 将Excel文件流转换为相应的JAVA Bean，默认取第一个Sheet
     * @param file
     * @param clazz
     * @return
     */
    List<T> convertToBeanList(MultipartFile file, Class<T> clazz, ExcelMatchType type);


    /**
     * 将Excel文件流转换为相应的JAVA Bean，默认按顺序来匹配
     * @param file
     * @param clazz
     * @return
     */
    List<T> convertToBeanList(MultipartFile file, Class<T> clazz, Integer sheet);

    /**
     * 将Excel文件流转换为相应的JAVA Bean
     * @param file 文件流
     * @param clazz 反射类对象类型
     * @param sheet 页签顺序
     * @param type 匹配配型
     * @return
     */
    List<T> convertToBeanList(MultipartFile file, Class<T> clazz, Integer sheet,ExcelMatchType type);


    /**
     * 将Excel文件流转换为相应的JAVA Bean,匹配规则按顺序来匹配
     * @param file
     * @param clazz
     * @return
     */
    List<T> convertToBeanListOrder(MultipartFile file, Class<T> clazz);


    /**
     * 将Excel文件流转换为相应的JAVA Bean,匹配规则按名字来匹配
     * @param file
     * @param clazz
     * @return
     */
    List<T> convertToBeanListName(MultipartFile file, Class<T> clazz);
}
