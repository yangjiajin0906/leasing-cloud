package com.leasing.common.serviceimpl.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.annotation.Excel;
import com.leasing.common.entity.common.dto.CellValueDTO;
import com.leasing.common.enums.excel.ExcelErrorEnum;
import com.leasing.common.enums.excel.ExcelMatchType;
import com.leasing.common.enums.excel.ExcelType;
import com.leasing.common.service.common.ExcelHandingService;
import com.leasing.common.utils.tools.ExcelBaseUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019-11-21
 * @author:lvcna@yonyou.com
 * @description: Excel解析实现类
 **/
@Service("common.ExcelHandingServiceImpl")
@Transactional
public class ExcelHandingServiceImpl implements ExcelHandingService {

    @Override
    public List convertToBeanList(MultipartFile file, Class clazz, Integer sheet, ExcelMatchType type) {
        //校验方法
        checkFile(file);
        //获取Workbook对象
        Workbook workbook = getWorkBook(file);
        //获取@Excel注解的字段
        List<Field> fieldList = getExcelFields(clazz);
        //处理Excel数据返回实体类
        List resultList = handleExcelData(fieldList, workbook, sheet, type, clazz);
        return resultList;
    }



    @Override
    public List convertToBeanList(MultipartFile file, Class clazz, Integer sheet) {
        return convertToBeanList(file, clazz, sheet, ExcelMatchType.MatchTypeOrder);
    }

    @Override
    public List convertToBeanList(MultipartFile file, Class clazz, ExcelMatchType type) {
        return convertToBeanList(file, clazz, 0, type);
    }

    @Override
    public List convertToBeanListOrder(MultipartFile file, Class clazz) {
        return convertToBeanList(file, clazz, ExcelMatchType.MatchTypeOrder);
    }

    @Override
    public List convertToBeanListName(MultipartFile file, Class clazz) {
        return convertToBeanList(file, clazz, ExcelMatchType.MatchTypeName);
    }

    @Override
    public List convertToBeanList(MultipartFile file, Class clazz) {
        return convertToBeanList(file, clazz, ExcelMatchType.MatchTypeOrder);
    }

    /**
     * 文件校验
     * @param file
     * @throws IOException
     */
    private void checkFile(MultipartFile file) {
        // 判断文件是否存在
        if (null == file) {
            throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
        }
        // 获得文件名
        String fileName = file.getName();
        // 判断文件是否是excel文件
        if (!fileName.endsWith(ExcelType.XLS.getType()) && !fileName.endsWith(ExcelType.XLS_X.getType())) {
            throw new RuntimeException(ExcelErrorEnum.FILE_INVALID_TYPE.getMsg());
        }
    }

    /**
     * 解析文件，生成poi Workbook
     * @param file
     * @return
     */
    private Workbook getWorkBook(MultipartFile file) {
        // 校验文件对象
        if(null == file || file.isEmpty()){
            throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
        }
        // 获得文件名
        String fileName = file.getName();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        // 获取excel文件的io流
        InputStream is = null;
        try {
            is = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith(ExcelType.XLS.getType())) {
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith(ExcelType.XLS_X.getType())) {
                workbook = new XSSFWorkbook(is);
            } else {
                throw new RuntimeException(ExcelErrorEnum.FILE_INVALID_TYPE.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ExcelErrorEnum.FILE_STREAM_FAIL.getMsg());
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(ExcelErrorEnum.FILE_STREAM_FAIL.getMsg());
                }
            } else {
                throw new RuntimeException(ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
            }
        }
        return workbook;
    }


    /**
     * 按排序获取Excel注解的字段
     * 如果字段设定排序，排序后返回
     * @param clazz
     * @return
     */
    private List<Field> getExcelFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldList = new ArrayList();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Excel.class)) {
                fieldList.add(field);
            }
        }
        //对字段按照@Excel->OrderNum进行排序
        fieldList.sort(Comparator.comparing(e -> e.getAnnotation(Excel.class).orderNum()));
        return fieldList;
    }


    /**
     * 处理Excel数据返回实体类
     * @param fieldList
     * @param workbook
     * @param sheetNum
     * @param type
     * @return
     */
    private List handleExcelData(List<Field> fieldList, Workbook workbook,
                                        Integer sheetNum, ExcelMatchType type, Class clazz) {

        Sheet sheet = workbook.getSheetAt(sheetNum);
        Assert.notNull(sheet,ExcelErrorEnum.FILE_NOT_EXISTS.getMsg());
        JSONArray jsonArray = null;
        if(type.equals(ExcelMatchType.MatchTypeOrder)){
            jsonArray = handleDataByOrder(sheet, fieldList);
        } else if (type.equals(ExcelMatchType.MatchTypeName)){
            jsonArray = handleDataByName(sheet, fieldList);
        } else {
            throw new RuntimeException(ExcelErrorEnum.FILE_MATCH_FAIL.getMsg());
        }
        List<Class> result = JSONObject.parseArray(jsonArray.toJSONString(), clazz);
        return result;
    }

    /**
     * 根据Excle列排序解析数据，返回JsonArray
     * @param sheet
     * @param fieldList
     */
    private JSONArray handleDataByOrder(Sheet sheet, List<Field> fieldList) {
        String sheetName = sheet.getSheetName();
        int startRow = sheet.getFirstRowNum() + 1;
        int lastRow = sheet.getLastRowNum();
        //缓存返回对象结果集
        JSONArray array = new JSONArray();
        //记录错误信息明细
        StringBuffer errorMsg = new StringBuffer();
        for(int rowNum = startRow; rowNum <= lastRow; rowNum++){
            JSONObject jsonObject = new JSONObject();
            Row row = sheet.getRow(rowNum);
            for(Field field : fieldList){
                int orderNum = field.getAnnotation(Excel.class).orderNum();
                Cell cell = row.getCell(orderNum);
                CellValueDTO cellValue = ExcelBaseUtils.getCellValue(cell);
                if(cellValue.getFlag()){
                    jsonObject.put(field.getName(), cellValue.getValue());
                } else {
                    errorMsg.append(sheetName + "页签 | " +"第" + rowNum + "行,第" + orderNum + "列" + cellValue.getErrorMsg() + System.lineSeparator());
                }
            }
            array.add(jsonObject);
        }
        if(StringUtils.isNotBlank(errorMsg.toString())){
            throw new RuntimeException(errorMsg.toString());
        }
        return array;
    }

    /**
     * 根据Excle列名匹配解析数据
     * @param sheet
     * @param fieldList
     */
    private JSONArray handleDataByName(Sheet sheet, List<Field> fieldList) {
        String sheetName = sheet.getSheetName();
        int startRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();
        JSONArray array = new JSONArray();
        StringBuffer errorMsg = new StringBuffer();

        // 缓存实体类列名 : 字段英文名
        Map<String, String> colNameMap = cacheFieldMap(fieldList);
        // 缓存Excel列号 : 字段名
        Map<Integer, String> colOrderMap = cacheColMap(sheet.getRow(startRow));
        //
        //列名校验,是否Excel中所有列名在实体类中都有相应注解,只校验1行即可
        Boolean colCheckFlag = false;
        StringBuffer colErrorMsg = new StringBuffer();
        for(int rowNum = startRow + 1; rowNum <= lastRow; rowNum++){
            JSONObject jsonObject = new JSONObject();
            Row row = sheet.getRow(rowNum);
            int cellNum = row.getPhysicalNumberOfCells();
            int startNum = Integer.valueOf(row.getFirstCellNum());
            for(int i = startNum; i < cellNum; i++){
                Cell cell = row.getCell(i);
                if(colOrderMap.containsKey(i)){
                    String colName = colOrderMap.get(i);
                    //如果第一行校验匹配关系没问题,之后就无需再进行校验
                    if(!colCheckFlag && !colNameMap.containsKey(colName)){
                        colErrorMsg.append("第" + i + "列名字无法在实体类中找到匹配的对照关系,请检查导入模板!" + System.lineSeparator());
                        continue;
                    }
                    String fieldName = colNameMap.get(colName);
                    CellValueDTO cellValue = ExcelBaseUtils.getCellValue(cell);
                    if(cellValue.getFlag()){
                        jsonObject.put(fieldName, cellValue.getValue());
                    } else {
                        errorMsg.append(sheetName + "页签 | " +"第" + rowNum + "行,第" + i + "列" + cellValue.getErrorMsg() + System.lineSeparator());
                    }
                }
            }
            if(StringUtils.isNotBlank(colErrorMsg.toString())){
                throw new RuntimeException(colErrorMsg.toString());
            }
            colCheckFlag = true;
            array.add(jsonObject);
        }
        return array;
    }



    /**
     * 缓存列名 ：字段名 键值信息
     * @param fieldList
     * @return
     */
    private Map<String, String> cacheFieldMap(List<Field> fieldList) {
        Map<String, String> colomnMap = new HashMap();
        for(Field field : fieldList){
            String titleName = field.getAnnotation(Excel.class).titleName();
            colomnMap.put(titleName, field.getName());
        }
        return colomnMap;
    }

    /**
     * 缓存列号 : 字段名 键值信息
     * @param row
     * @return
     */
    private Map<Integer,String> cacheColMap(Row row) {
        Map<Integer,String> cacheMap = new HashMap();
        int start = Integer.valueOf(row.getFirstCellNum());
        int end = Integer.valueOf(row.getLastCellNum());
        StringBuffer errorMsg = new StringBuffer();
        for(int i = start; i < end; i++){
            Cell cell = row.getCell(i);
            CellValueDTO cellValue = ExcelBaseUtils.getCellValue(cell);
            if(cellValue.getFlag()){
                if(cellValue.getValue() == null || StringUtils.isBlank(cellValue.getValue().toString())){
                    continue;
                }
                cacheMap.put(i, (String)cellValue.getValue());
            } else {
                errorMsg.append("Excel表第一行第" + i + "列取表格内容出错" + System.lineSeparator());
            }
        }
        if(StringUtils.isNotBlank(errorMsg.toString())){
            throw new RuntimeException(errorMsg.toString());
        }
        return cacheMap;
    }
}
