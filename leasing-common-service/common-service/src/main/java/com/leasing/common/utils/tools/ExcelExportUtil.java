package com.leasing.common.utils.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.leasing.common.entity.foundation.vo.CellOutVO;
import com.leasing.common.entity.foundation.vo.ExcelOutPicVO;
import com.leasing.common.entity.foundation.vo.ExcelOutVO;
import com.leasing.common.entity.foundation.vo.SheetOutVO;

import com.leasing.common.utils.base.ObjectUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:Excel导出工具类  传入参数完成自定义Excel导出
 **/
public class ExcelExportUtil {

    private static String fontName_yahei = "微软雅黑";
    private static String fontName_songti = "宋体";
    private static short fontHeight = 11;

    public static String getCellStringValue(HSSFCell cell) {
        String cellValue = "";
        switch (cell.getCellType()) {
            case STRING://字符串类型
                cellValue = cell.getStringCellValue();
                if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
                    cellValue = " ";
                break;
            case NUMERIC: //数值类型
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case FORMULA: //公式
                cell.setCellType(CellType.NUMERIC);
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case BLANK:
                cellValue = " ";
                break;
            case BOOLEAN:
                break;
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }


    /**
     * 生成ExcelOutVO
     * @param beginRow 开始行数
     * @param beginCol 开始列数
     * @param exHead 按顺序 列明显示名称<fieldName,{<'value',disName><'type',type>}> type类型看CellOutVO.CELL_TYPE
     * @param allDatas excel根据exHead显示的数据List<fileName,disName>
     * @return ExcelOutVO
     */
    public static ExcelOutVO createExcelOutVO(String title,int beginRow,int beginCol,LinkedHashMap<String,Object> exHead,List<Map> allDatas) {
        ExcelOutVO excelOutVO  = new ExcelOutVO();
        SheetOutVO sheetOutVO = new SheetOutVO();
        sheetOutVO.setBeginRow(beginRow);
        sheetOutVO.setBeginCol(beginCol);
        if(StringUtils.isNotEmpty(title)){
            sheetOutVO.setTitle(title);
        }
        excelOutVO.addSheetOutVO(sheetOutVO);
        List<List<CellOutVO>> exRows = new ArrayList<List<CellOutVO>>();
        //列名
        List<CellOutVO> column = new ArrayList<CellOutVO>();
        for(Map.Entry<String,Object> entry:exHead.entrySet()){
            System.out.println(entry.getKey() + "--->" + entry.getValue());
            CellOutVO cellOutVO;
            if(entry.getValue() instanceof Map ){
                Map valueMap = (Map) entry.getValue();
                cellOutVO = new CellOutVO(ObjectUtil.toString(valueMap.get("value")));
            } else {
                cellOutVO = new CellOutVO(entry.getValue());
            }
            column.add(cellOutVO);

        }
        exRows.add(column);
        //对应列名的数据
        for (int i = 0; i < allDatas.size() ; i++) {
            List<CellOutVO> exData = new ArrayList<CellOutVO>();
            Map dataMap = allDatas.get(i);
            for(Map.Entry<String,Object> entry:exHead.entrySet()){
                CellOutVO cellOutVO;
                if(dataMap.get(entry.getKey())!=null){
                    if(entry.getValue() instanceof Map ) {
                        Map valueMap = (Map)entry.getValue();
                        cellOutVO = new CellOutVO(dataMap.get(entry.getKey()), ObjectUtil.toIntegerNull(valueMap.get("type")));
                    } else {
                        cellOutVO = new CellOutVO(dataMap.get(entry.getKey()));
                    }
                    exData.add(cellOutVO);
                }else{
                    cellOutVO = new CellOutVO("未找到对应的列");
                    exData.add(cellOutVO);
                }
            }
            exRows.add(exData);
        }
        sheetOutVO.setList(exRows);
        return excelOutVO;
    }

    /**
     * 根据ExcelOutVＯ的内空更新excel
     */
    public static void createExcel(ExcelOutVO excelOutVO, OutputStream outputStream,int colWidth) {

        try {
            //读取excel模板
            HSSFWorkbook wb = new HSSFWorkbook();

            List<SheetOutVO> list = excelOutVO.getList();
            for (SheetOutVO sheetOutVO : list) {
                //创建一sheet页
                HSSFSheet wsheet = wb.createSheet(sheetOutVO.getTitle());
                HSSFCellStyle cellStyle = getCellStyle(sheetOutVO, wb);
                HSSFCellStyle cellStyleDate = getCellStyleDate(sheetOutVO, wb);
                HSSFCellStyle cellStyleHead = getCellStyleHead(sheetOutVO, wb);
                HSSFCellStyle cellStyleType = getCellStyleType(sheetOutVO, wb);
                HSSFCellStyle cellStyleNumeric = getCellStyleNumeric(sheetOutVO, wb);
                HSSFCellStyle cellStyleError = getCellStyleError(sheetOutVO, wb);
                HSSFCellStyle cellStyleRed = getCellStyle(sheetOutVO, wb);
                HSSFFont fontRed = wb.createFont();
                fontRed.setFontName(fontName_songti);
                fontRed.setFontHeightInPoints(fontHeight);
                fontRed.setColor(Font.COLOR_RED);
                cellStyleRed.setFont(fontRed);
                int maxClums =0;
                List<List<CellOutVO>> data = sheetOutVO.getList();
                if (data != null && !data.isEmpty()) {
                    int beginRow = sheetOutVO.getBeginRow();
                    if(data.get(0).size()>maxClums) maxClums=data.get(0).size();//用来记录出有多少个列
                    for (int i = 0; i <data.size() ; i++) {
                        List<CellOutVO> cellOutVOs = data.get(i);
                        int beginCol = sheetOutVO.getBeginCol();
                        //创建行
                        HSSFRow row = wsheet.createRow(beginRow);
                        if(i==0){
                            row.setHeight(Short.valueOf("400"));
                        } else {
                            row.setHeight(Short.valueOf("300"));
                        }
                        for (int j = 0; j <cellOutVOs.size() ; j++) {
                            CellOutVO cellOutVO = cellOutVOs.get(j);
                            //在相应的单元格进行赋值
                            if (wsheet.getRow(beginRow) != null && wsheet.getRow(beginRow).getCell(beginCol) != null) {
                                System.out.println(beginRow + "row" + beginCol + "col--->有数据");
                                //wsheet.getCellComment(beginRow, beginCol).setString(string);
                            } else {
                                //创建单元格
                                HSSFCell cell = row.createCell(beginCol);
                                if(0==i){
                                    cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));

                                    //目前只支持红色
                                    if(cellOutVO.getFontColor().equals("red")){
                                        cell.setCellStyle(cellStyleRed);
                                    }else{
                                        cell.setCellStyle(cellStyleHead);
                                    }
                                } else {
                                    if(cellOutVO.getFontColor().equals("red")){
                                        setCellValue(cell, cellOutVO, cellStyleRed, cellStyleRed, cellStyleRed, cellStyleRed, cellStyleRed);
                                    }else{
                                        setCellValue(cell, cellOutVO, cellStyleDate, cellStyle, cellStyleType, cellStyleNumeric, cellStyleError);
                                    }

                                }
                            }
                            beginCol++;
                        }
                        beginRow++;
                    }
                }

                //每一旬设置为自动宽度
                for(int i=0;i<=maxClums;i++){
                    if (colWidth==0) {
                        wsheet.autoSizeColumn(i,true);
                    } else {
                        wsheet.setColumnWidth(i, colWidth);
                    }
                }

                //处理图片内容
                List<ExcelOutPicVO> pictrues = sheetOutVO.getPictures();
                if (pictrues != null && !pictrues.isEmpty()) {
                    for (int i = 0; i <pictrues.size() ; i++) {
                        ExcelOutPicVO pictrue = pictrues.get(i);
                        String fileNames =  pictrue.getFilePathNames();
                        int row = pictrue.getRow();
                        int col = pictrue.getCol();
                        int type = pictrue.getPicType();

                        if(fileNames.trim().length()==0){
                            continue;

                        }
                        InputStream is = new FileInputStream(fileNames);
                        byte[] bytes = IOUtils.toByteArray(is);
                        int pictureIdx = wb.addPicture(bytes,type);

                        CreationHelper helper = wb.getCreationHelper();
                        Drawing drawing = wsheet.createDrawingPatriarch();
                        ClientAnchor anchor = helper.createClientAnchor();

                        // 图片插入坐标
                        anchor.setCol1(col);
                        anchor.setRow1(row);
                        // 插入图片
                        Picture pict = drawing.createPicture(anchor, pictureIdx);
                        pict.resize();
                        is.close();
                    }
                }
            }

            wb.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static void setCellValue(HSSFCell cell, CellOutVO cellOutVO, HSSFCellStyle cellStyleDate,HSSFCellStyle cellStyle,
                                     HSSFCellStyle cellStyleType,HSSFCellStyle cellStyleNumeric,HSSFCellStyle cellStyleError) {

        //设置值
        switch(cellOutVO.getCellType()){
            case CellOutVO.CELL_TYPE.INIT:
                cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));
                cell.setCellStyle(cellStyle);
                return ;
            case CellOutVO.CELL_TYPE.DATE:
                cell.setCellValue(ObjectUtil.toDate(cellOutVO.getCellValue(), "yyyy-MM-dd"));
                cell.setCellStyle(cellStyleDate);
                return ;
            case CellOutVO.CELL_TYPE.NUMERIC:
                cell.setCellValue(ObjectUtil.toDouble(cellOutVO.getCellValue()));
                cell.setCellStyle(cellStyleNumeric);
                cell.setCellType(CellType.NUMERIC);
                return ;
            case CellOutVO.CELL_TYPE.TYPE:
                cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));
                cell.setCellStyle(cellStyleType);
                return ;
            case CellOutVO.CELL_TYPE.ERROR:
                cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));
                cell.setCellStyle(cellStyleError);
                return ;
            default:
                cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));
                cell.setCellStyle(cellStyle);
        }
    }
    /**
     * 根据ExcelOutVＯ的内空更新excel
     *
     * @param templeFile   下载的excel模板
     * @param excelOutVO
     * @param outputStream
     */
    public static void updateExcel(File templeFile, ExcelOutVO excelOutVO, OutputStream outputStream) {

        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templeFile));
            //读取excel模板
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            List<SheetOutVO> list = excelOutVO.getList();
            for (SheetOutVO sheetOutVO : list) {
                HSSFSheet wsheet = wb.getSheetAt(sheetOutVO.getSheet());//得到指定的sheet
                // 创建单元格样式对象
                HSSFCellStyle cellStyle = getCellStyle(sheetOutVO, wb);
                HSSFCellStyle cellStyleDate = getCellStyleDate(sheetOutVO, wb);
                HSSFCellStyle cellStyleHead = getCellStyleHead(sheetOutVO, wb);
                HSSFCellStyle cellStyleType = getCellStyleType(sheetOutVO, wb);
                HSSFCellStyle cellStyleNumeric = getCellStyleNumeric(sheetOutVO, wb);
                HSSFCellStyle cellStyleError = getCellStyleError(sheetOutVO, wb);
                Map<String, Object> map = sheetOutVO.getMap();
                if (map != null) {
                    for (String s : map.keySet()) {
                        for (int rwoindex = 0; rwoindex <= wsheet.getLastRowNum(); rwoindex++) {
                            //得到excel行
                            HSSFRow row = wsheet.getRow(rwoindex);
                            if (row == null) continue;
                            for (int colindex = 0; colindex <= row.getLastCellNum(); colindex++) {
                                //得到单元格
                                HSSFCell cell = row.getCell(colindex);
                                if (cell != null) {
                                    String value = getCellStringValue(cell);
                                    if (value.trim().equals(s)) {
                                        //单元格付值
                                        cell.setCellValue(map.get(s).toString());
                                        break;
                                    }
                                }

                            }
                        }
                    }
                }
                List<List<CellOutVO>> data = sheetOutVO.getList();
                if (data != null && !data.isEmpty()) {
                    int beginRow = sheetOutVO.getBeginRow();
                    for (int i = 0; i <data.size() ; i++) {
                        List<CellOutVO> cellOutVOs = data.get(i);
                        int beginCol = sheetOutVO.getBeginCol();
                        //创建行
                        HSSFRow row = wsheet.createRow(beginRow);
                        for (int j = 0; j <cellOutVOs.size() ; j++) {
                            CellOutVO cellOutVO = cellOutVOs.get(j);
                            //在相应的单元格进行赋值
                            if (wsheet.getRow(beginRow) != null && wsheet.getRow(beginRow).getCell(beginCol) != null) {
                                System.out.println(beginRow + "row" + beginCol + "col--->有数据");
                                //wsheet.getCellComment(beginRow, beginCol).setString(string);
                            } else {
                                //创建单元格
                                HSSFCell cell = row.createCell(beginCol);
                                if(0==i){
                                    cell.setCellValue(ObjectUtil.toString(cellOutVO.getCellValue()));
                                    cell.setCellStyle(cellStyleHead);
                                } else {
                                    setCellValue(cell, cellOutVO, cellStyleDate,cellStyle,cellStyleType,cellStyleNumeric,cellStyleError);
                                }
                            }
                            beginCol++;
                        }
                        beginRow++;
                    }
                }

                //处理图片内容
                List<ExcelOutPicVO> pictrues = sheetOutVO.getPictures();
                if (pictrues != null && !pictrues.isEmpty()) {

                    for (ExcelOutPicVO pictrue : pictrues) {
                        String fileNames =  pictrue.getFilePathNames();
                        int row = pictrue.getRow();
                        int col = pictrue.getCol();
                        int type = pictrue.getPicType();

                        if(fileNames.trim().length()==0){
                            continue;

                        }
                        InputStream is = new FileInputStream(fileNames);
                        byte[] bytes = IOUtils.toByteArray(is);
                        int pictureIdx = wb.addPicture(bytes,type);

                        CreationHelper helper = wb.getCreationHelper();
                        Drawing drawing = wsheet.createDrawingPatriarch();
                        ClientAnchor anchor = helper.createClientAnchor();

                        // 图片插入坐标
                        anchor.setCol1(col);
                        anchor.setRow1(row);
                        // 插入图片
                        Picture pict = drawing.createPicture(anchor, pictureIdx);
                        pict.resize();
                        is.close();
                    }
                }
            }

            wb.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 日期格式
     */
    private static HSSFCellStyle getCellStyleDate(SheetOutVO sheetOutVO, HSSFWorkbook wb) {
        HSSFCellStyle cellStyleDate = wb.createCellStyle();
        cellStyleDate.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyleDate.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderRight(sheetOutVO.getBorderStyle());
        HSSFDataFormat format= wb.createDataFormat();
        cellStyleDate.setDataFormat(format.getFormat("yyyy/m/d"));
//        cellStyleDate.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleDate.setVerticalAlignment(VerticalAlignment.BOTTOM);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setFontName(fontName_songti);
        font.setFontHeightInPoints(fontHeight);
        cellStyleDate.setFont(font);
        return cellStyleDate;
    }

    /**
     * 金额格式
     */
    private static HSSFCellStyle getCellStyleNumeric(SheetOutVO sheetOutVO, HSSFWorkbook wb) {
        HSSFCellStyle cellStyleDate = wb.createCellStyle();
        cellStyleDate.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyleDate.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderRight(sheetOutVO.getBorderStyle());
        cellStyleDate.setAlignment(HorizontalAlignment.RIGHT);
        cellStyleDate.setVerticalAlignment(VerticalAlignment.BOTTOM);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setFontName(fontName_songti);
        font.setFontHeightInPoints(fontHeight);
        cellStyleDate.setFont(font);
        return cellStyleDate;
    }

    /**
     * 类型格式
     */
    private static HSSFCellStyle getCellStyleType(SheetOutVO sheetOutVO, HSSFWorkbook wb) {
        HSSFCellStyle cellStyleDate = wb.createCellStyle();
        cellStyleDate.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyleDate.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderRight(sheetOutVO.getBorderStyle());
        cellStyleDate.setAlignment(HorizontalAlignment.CENTER);
        cellStyleDate.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setFontName(fontName_yahei);
        font.setFontHeightInPoints(fontHeight);
        cellStyleDate.setFont(font);
        return cellStyleDate;
    }
    /**
     * 表头格式
     */
    private static HSSFCellStyle getCellStyleHead(SheetOutVO sheetOutVO, HSSFWorkbook wb) {
        HSSFCellStyle cellStyleDate = wb.createCellStyle();
        cellStyleDate.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyleDate.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyleDate.setBorderRight(sheetOutVO.getBorderStyle());
        cellStyleDate.setAlignment(HorizontalAlignment.CENTER);
        cellStyleDate.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setFontName(fontName_yahei);
        font.setFontHeightInPoints(fontHeight);
        cellStyleDate.setFont(font);
        return cellStyleDate;
    }
    /**
     * 常规格式
     */
    private static HSSFCellStyle getCellStyle(SheetOutVO sheetOutVO,HSSFWorkbook wb) {
        // 创建单元格样式对象
        HSSFCellStyle cellStyle = wb.createCellStyle();
        // CellStyle.BORDER_DOUBLE      双边线
        // CellStyle.BORDER_THIN        细边线
        // CellStyle.BORDER_MEDIUM      中等边线
        // CellStyle.BORDER_DASHED      虚线边线
        // CellStyle.BORDER_HAIR        小圆点虚线边线
        // CellStyle.BORDER_THICK       粗边线
        cellStyle.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyle.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyle.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyle.setBorderRight(sheetOutVO.getBorderStyle());
        // 设置单元格内容水平对其方式
        // XSSFCellStyle.ALIGN_CENTER       居中对齐
        // XSSFCellStyle.ALIGN_LEFT         左对齐
        // XSSFCellStyle.ALIGN_RIGHT        右对齐
//        cellStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setFontName(fontName_songti);
        font.setFontHeightInPoints(fontHeight);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 错误格式
     */
    private static HSSFCellStyle getCellStyleError(SheetOutVO sheetOutVO,HSSFWorkbook wb) {
        // 创建单元格样式对象
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(sheetOutVO.getBorderStyle());//CellStyle.BORDER_THICK     默认
        cellStyle.setBorderTop(sheetOutVO.getBorderStyle());
        cellStyle.setBorderLeft(sheetOutVO.getBorderStyle());
        cellStyle.setBorderRight(sheetOutVO.getBorderStyle());
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        //设置格式
        HSSFFont font = wb.createFont();
        font.setColor(Font.COLOR_RED);
        font.setFontName(fontName_songti);
        font.setFontHeightInPoints(fontHeight);
        cellStyle.setFont(font);
        return cellStyle;
    }


    //代码测试
    public static void main(String[] args) throws FileNotFoundException {
        Map map = new HashMap();
        map.put("$aa$", "aa");
        map.put("$bb$", "222");
        map.put("$cc$", "cc");

        SheetOutVO sheetOutVO1 = new SheetOutVO();
        sheetOutVO1.setTitle("go");
        sheetOutVO1.setSheet(0);
        sheetOutVO1.setMap(map);
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\workbook1.xls"));
        //createExcel(new File("D:\\workbook.xls"), map, outputStream);
        ExcelOutVO excelOutVO = new ExcelOutVO();
        SheetOutVO sheetOutVO = new SheetOutVO();
        sheetOutVO.setBeginRow(2);
        sheetOutVO.setBeginCol(3);
        sheetOutVO.setSheet(1);
        /*excelOutVO.setMap(map);*/

        List list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(new CellOutVO("aaa",CellOutVO.CELL_TYPE.INIT));
        list1.add(new CellOutVO("3",CellOutVO.CELL_TYPE.NUMERIC));
        list1.add(new CellOutVO("a44aa",CellOutVO.CELL_TYPE.INIT));

        List list2 = new ArrayList();
        list2.add(new CellOutVO("5343",CellOutVO.CELL_TYPE.INIT));
        list2.add(new CellOutVO("uuu",CellOutVO.CELL_TYPE.INIT));
        list2.add(new CellOutVO("11",CellOutVO.CELL_TYPE.NUMERIC));

        list.add(list1);
        list.add(list2);
        sheetOutVO.setList(list);


        ExcelOutPicVO pic = new ExcelOutPicVO("D:\\1.jpg",2,6,"png");//2,6 从0开始  第2行第6列
        List pics = new ArrayList();
        pics.add(pic);

        sheetOutVO.setPictures(pics);
        excelOutVO.addSheetOutVO(sheetOutVO);
        excelOutVO.addSheetOutVO(sheetOutVO1);

        createExcel(excelOutVO, outputStream,0);
        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}