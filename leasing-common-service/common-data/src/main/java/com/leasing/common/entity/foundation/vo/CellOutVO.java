package com.leasing.common.entity.foundation.vo;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class CellOutVO {
    /**
     * 字体颜色
     */
    private String fontColor="";
    /**
     * 字体是否加粗
     */
    private boolean isBold = false;

    /**
     * 单元格值
     */
    private Object cellValue;

    /**
     * 单元格 类型
     */
    private int cellType =  CELL_TYPE.INIT;//默认字符串

    public  interface CELL_TYPE {
        /**
         * 常规
         */
        int INIT = 0;
        /**
         * 日期型
         */
        int DATE = 1;
        /**
         * 数值
         */
        int NUMERIC = 2;
        /**
         * 类别型
         */
        int TYPE = 3;
        /**
         * 错误信息
         */
        int ERROR = 4;
    }

    public CellOutVO(Object value) {
        this.setCellValue(value);
    }

    public CellOutVO(Object value, Integer cellType) {
        this.setCellValue(value);
        if(cellType!=null){
            this.setCellType(cellType.intValue());
        }
    }

    public Object getCellValue() {
        return cellValue;
    }

    public void setCellValue(Object cellValue) {
        this.cellValue = cellValue;
    }

    public int getCellType() {
        return cellType;
    }

    public void setCellType(int cellType) {
        this.cellType = cellType;
    }


    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setIsBold(boolean isBold) {
        this.isBold = isBold;
    }
}