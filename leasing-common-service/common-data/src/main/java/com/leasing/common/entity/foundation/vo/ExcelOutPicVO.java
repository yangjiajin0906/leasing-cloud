package com.leasing.common.entity.foundation.vo;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class ExcelOutPicVO {
    private String filePathNames;
    private int row;
    private int col;
    private int picType=6;//默认为png 目前只支持dib jpg

    /**
     *
     * @param filePathNames 图片路径
     * @param row 行位置从0开始
     * @param col 列位置 从0开始
     * @param picType 图片的类型 png dib jpg
     */
    public ExcelOutPicVO(String filePathNames, int row, int col, String picType){
        this.filePathNames=filePathNames;
        this.row=row;
        this.col=col;
        int type = 6;
        if(picType.trim().length()==0){
            throw new RuntimeException("图片类型不能为空");
        }
        if(picType.trim().equals("DIB") || picType.trim().equals("dib")) type=7;
        if(picType.trim().equals("JPG") || picType.trim().equals("jpg")) type=5;
        this.picType=type;
    }

    public int getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        int type = 6;
        if(picType.trim().equals("DIB") || picType.trim().equals("dib")) type=7;
        if(picType.trim().equals("JPEG") || picType.trim().equals("jpeg")) type=5;
        this.picType = type;
    }

    public String getFilePathNames() {
        return filePathNames;
    }

    public void setFilePathNames(String filePathNames) {
        this.filePathNames = filePathNames;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}