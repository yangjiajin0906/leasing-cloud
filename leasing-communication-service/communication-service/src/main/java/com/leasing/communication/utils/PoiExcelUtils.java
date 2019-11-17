package com.leasing.communication.utils;

import com.leasing.communication.interfaces.ExcelTag;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:Yjj@yonyou.com
 * @description: POI导入导出工具类
 **/
public class PoiExcelUtils {
    /**
     * 解析数据，将inputStream转为List
     *
     * @param excel
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> parse(InputStream excel, Class<T> clazz) throws Exception {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excel);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        XSSFRow titleCell = xssfSheet.getRow(0);
        List<T> dataList = new ArrayList<>(xssfSheet.getLastRowNum());
        T datum;
        Map<String, Field> fieldMap = getFieldMap(clazz);
        for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
            XSSFRow xssfRow = xssfSheet.getRow(i);
            datum = clazz.newInstance();
            int minCell = xssfRow.getFirstCellNum();
            int maxCell = xssfRow.getLastCellNum();
            for (int cellNum = minCell; cellNum <= maxCell; cellNum++) {
                XSSFCell title = titleCell.getCell(cellNum);
                if (title == null) {
                    continue;
                }
                String tag = title.getStringCellValue();
                Field field = fieldMap.get(tag);
                if (field == null) {
                    continue;
                }
                Class<?> type = field.getType();
                Object value = null;
                XSSFCell cell = xssfRow.getCell(cellNum);
                if (cell == null) {
                    continue;
                }
                if (type.equals(String.class)) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    value = cell.getStringCellValue();
                } else if (type.equals(Date.class)) {
                    value = cell.getDateCellValue();
                }
                PropertyUtils.setProperty(datum, field.getName(), value);
            }
            dataList.add(datum);
        }
        return dataList;
    }

    private static <T> Map<String, Field> getFieldMap(Class<T> clazz) {
        Field[] fields = FieldUtils.getFieldsWithAnnotation(clazz, ExcelTag.class);
        Map<String, Field> fieldMap = new HashMap<>(fields.length / 3 * 4);
        for (Field field : fields) {
            ExcelTag annotation = field.getAnnotation(ExcelTag.class);
            fieldMap.put(annotation.tag(), field);
        }
        return fieldMap;
    }

    /**
     * 导出数据到outputStream
     *
     * @param outputStream
     * @param dataList
     * @param clazz
     * @param <T>
     * @throws Exception
     */
    public static <T> void export(OutputStream outputStream, List<T> dataList, Class<T> clazz) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        ExcelTag annotation = clazz.getAnnotation(ExcelTag.class);
        String tag = annotation.tag();
        //工作簿
        XSSFSheet sheet = wb.createSheet(tag);
        Field[] fields = FieldUtils.getFieldsWithAnnotation(clazz, ExcelTag.class);
        //表头
        XSSFRow headers = sheet.createRow(0);
        for (int index = 0; index < fields.length; index++) {
            Field field = fields[index];
            int type = 0;
            if (String.class.equals(field.getType())) {
                type = Cell.CELL_TYPE_STRING;
            }
            ExcelTag excelTag = field.getAnnotation(ExcelTag.class);
            XSSFCell cell = headers.createCell(index, type);
            XSSFCellStyle style = wb.createCellStyle();
            XSSFFont font = wb.createFont();
            //font.setColor(excelTag.fontColor().getIndex());
            style.setFont(font);
            cell.setCellStyle(style);
            tag = excelTag.tag();
            cell.setCellValue(tag);
        }
        //插入数据
        XSSFRow row;
        Field field;
        for (int i = 0; i < dataList.size(); i++) {
            T datum = dataList.get(i);
            row = sheet.createRow(i + 1);
            for (int index = 0; index < fields.length; index++) {
                field = fields[index];
                int type = 0;
                XSSFCell cell = row.createCell(index, type);
                cell.setCellStyle(wb.createCellStyle());
                Object property = PropertyUtils.getProperty(datum, field.getName());
                if (String.class.equals(field.getType())) {
                    cell.setCellValue((String) property);
                } else if (Date.class.equals(field.getType())) {
                    cell.setCellValue((Date) property);
                }
            }
        }
        //生成文档
        wb.write(outputStream);
    }
}