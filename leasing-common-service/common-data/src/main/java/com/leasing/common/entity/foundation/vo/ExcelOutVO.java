package com.leasing.common.entity.foundation.vo;
import java.util.ArrayList;
import java.util.List;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class ExcelOutVO {
    private List<SheetOutVO> list;


    public ExcelOutVO(){
        list = new ArrayList();
    }

    public void addSheetOutVO(SheetOutVO sheetoutvo){
        list.add(sheetoutvo);
    }

    public SheetOutVO getSheetOutVO(int i){
        return list.get(i);
    }
    public List<SheetOutVO> getList() {
        return list;
    }

    public void setList(List<SheetOutVO> list) {
        this.list = list;
    }
}