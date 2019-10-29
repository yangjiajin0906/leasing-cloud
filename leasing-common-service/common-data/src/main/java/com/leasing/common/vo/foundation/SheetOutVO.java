package com.leasing.common.vo.foundation;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.List;
import java.util.Map;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class SheetOutVO {
    private String title="sheet1";       //sheet名字
    private int beginRow;       //需要添加数据的开始行，从0开始
    private int endRow;
    private int beginCol;       //需要添加数据的开始列，从0开始
    private int endCol;
    private int sheet;     //需要添加数据的sheet号
    private List<List<CellOutVO>> list;   //需要添加的数据
    private Map<String, Object> map;  //当前 需要替换的数据
    private List<ExcelOutPicVO> pictures;//需要插入的图片信息

    private short borderStyle= CellStyle.BORDER_THIN ;//默认，为1，线边框
    private short alignment= XSSFCellStyle.ALIGN_CENTER;
    private short vertical =XSSFCellStyle.VERTICAL_CENTER;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ExcelOutPicVO> getPictures() {
        return pictures;
    }

    public void setPictures(List<ExcelOutPicVO> pictures) {
        this.pictures = pictures;
    }

    public short getAlignment() {
        return alignment;
    }

    public void setAlignment(short alignment) {
        this.alignment = alignment;
    }

    public short getVertical() {
        return vertical;
    }

    public void setVertical(short vertical) {
        this.vertical = vertical;
    }

    public short getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(short borderStyle) {
        this.borderStyle = borderStyle;
    }


    public int getBeginRow() {
        return beginRow;
    }

    public void setBeginRow(int beginRow) {
        this.beginRow = beginRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getBeginCol() {
        return beginCol;
    }

    public void setBeginCol(int beginCol) {
        this.beginCol = beginCol;
    }

    public int getEndCol() {
        return endCol;
    }

    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    public int getSheet() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet = sheet;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<List<CellOutVO>> getList() {
        return list;
    }

    public void setList(List<List<CellOutVO>> list) {
        this.list = list;
    }
}