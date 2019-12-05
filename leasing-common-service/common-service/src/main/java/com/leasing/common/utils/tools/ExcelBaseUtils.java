package com.leasing.common.utils.tools;

import com.leasing.common.entity.common.dto.CellValueDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019-11-25
 * @author:lvcna@yonyou.com
 * @description:
 **/
public class ExcelBaseUtils {

    /**
     * 科学计数
     */
    private final static String E = "e";

    /**
     * 默认文件名字
     */
    public final static String DEFAULT_NAME_XLS = "temp.xls";
    public final static String DEFAULT_NAME_XLSX = "temp.xlsx";

    /**
     * 解析Excel Cell
     * @param cell
     * @return
     */
    public static CellValueDTO getCellValue(Cell cell) {
        Object cellValue = null;
        CellValueDTO cellValueDTO = new CellValueDTO();
        cellValueDTO.setFlag(Boolean.TRUE);
        cellValueDTO.setValue(null);
        if (cell == null) {
            return cellValueDTO;
        }

        // 把数字当成String来读，避免出现1读成1.0的情况
        // 判断数据的类型
        switch (cell.getCellType()) {
            case NUMERIC:
                if (cell.getCellType() == CellType.NUMERIC) {
                    if (DateUtil.isValidExcelDate(cell.getNumericCellValue())) {
                        CellStyle style = cell.getCellStyle();
                        if (style == null) {
                            return cellValueDTO;
                        }
                        int i = style.getDataFormat();
                        String f = style.getDataFormatString();
                        boolean isDate = DateUtil.isADateFormat(i, f);
                        if (isDate) {
                            Date date = cell.getDateCellValue();
                            cellValueDTO.setValue(date);
                            return cellValueDTO;
                        }
                    }
                }
                // 防止科学计数进入
                if (String.valueOf(cell.getNumericCellValue()).toLowerCase().contains(E)) {
                    cellValueDTO.setFlag(Boolean.FALSE);
                    cellValueDTO.setErrorMsg("不支持转换科学记数法数字");
                    return cellValueDTO;
                }
                if ((int) cell.getNumericCellValue() != cell.getNumericCellValue()) {
                    // double 类型
                    cellValue = cell.getNumericCellValue();
                } else {
                    cellValue = (int) cell.getNumericCellValue();
                }
                break;
            // 字符串
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            // Boolean
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 公式
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            // 空值
            case BLANK:
                cellValue = null;
                break;
            // 故障
            case ERROR:
                cellValue = null;
                cellValueDTO.setFlag(Boolean.FALSE);
                cellValueDTO.setErrorMsg("非法字符");
                break;
            default:
                cellValue = null;
                cellValueDTO.setFlag(Boolean.FALSE);
                cellValueDTO.setErrorMsg("未知类型");
                break;
        }
        cellValueDTO.setValue(cellValue);
        return cellValueDTO;
    }


}
