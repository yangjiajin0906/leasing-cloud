package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "(" +
        "SELECT A.SOURCE_BILL PK_PROJECT_INFO," +
        "       A.THING_CODE THING_CODE," +
        "       A.THING_NAME THING_NAME," +
        "       A.THING_MODEL THING_MODEL," +
        "       A.PARAM_NAME PARAM_NAME," +
        "       SUM(A.TOTAL_COST) TOTAL_COST," +
        "       SUM(A.NET_WORTH) NET_WORTH," +
        "       SUM(A.VALUATION) VALUATION," +
        "       A.DELIVERY_DATE DELIVERY_DATE," +
        "       A.DELIVERY_ADDRESS DELIVERY_ADDRESS," +
        "       A.USE_ADDRESS USE_ADDRESS," +
        "       A.ACCEPTOR ACCEPTOR" +
        "  FROM (SELECT PRT.SOURCE_BILL SOURCE_BILL," +
        "               DECODE(CPRT.CNT, 1, PRT.THING_CODE, NULL) THING_CODE," +
        "               DECODE(CPRT.CNT, 1, PRT.THING_NAME, '详见“租赁物件”页签') THING_NAME," +
        "               DECODE(CPRT.CNT, 1, PRT.MODEL, NULL) THING_MODEL," +
        "               DECODE(CPRT.CNT, 1, P.PARAM_NAME, NULL) PARAM_NAME," +
        "               PRT.TOTAL_COST TOTAL_COST," +
        "               PRT.NET_WORTH NET_WORTH," +
        "               PRT.VALUATION VALUATION," +
        "               DECODE(CPRT.CNT, 1, PRT.DELIVERY_DATE, NULL) DELIVERY_DATE," +
        "               DECODE(CPRT.CNT, 1, PRT.DELIVERY_ADDRESS, NULL) DELIVERY_ADDRESS," +
        "               DECODE(CPRT.CNT, 1, PRT.USE_ADDRESS, NULL) USE_ADDRESS," +
        "               DECODE(CPRT.CNT, 1, PRT.ACCEPTOR, NULL) ACCEPTOR" +
        "          FROM YLS_PROJECT_RENT_THING PRT" +
        "          LEFT JOIN YLS_PARAMETER P" +
        "            ON P.PK_PARAMETER = PRT.THING_TYPE" +
        "          LEFT JOIN (SELECT COUNT(T.PK_PROJECT_RENT_THING) CNT," +
        "                           T.SOURCE_BILL SOURCE_BILL" +
        "                      FROM YLS_PROJECT_RENT_THING T" +
        "                     GROUP BY T.SOURCE_BILL) CPRT" +
        "            ON CPRT.SOURCE_BILL = PRT.SOURCE_BILL) A" +
        " GROUP BY A.SOURCE_BILL," +
        "          A.THING_CODE," +
        "          A.THING_NAME," +
        "          A.THING_MODEL," +
        "          A.PARAM_NAME," +
        "          A.DELIVERY_DATE," +
        "          A.DELIVERY_ADDRESS," +
        "          A.USE_ADDRESS," +
        "          A.ACCEPTOR" +
        "    )")
public class ProjectRentThingRefVO extends BaseRefVO {


    /**
     * 来源单据主键
     */
    @Id
    public String pkProjectInfo;
    /**
     * 型号
     */
    public String thingModel;
    /**
     * 设备总价
     */
    public BigDecimal totalCost;
    /**
     * 净值
     */
    public BigDecimal netWorth;
    /**
     * 估值
     */
    public BigDecimal valuation;
    /**
     * 分类
     */
    public String paramName;
    /**
     * 交货日期
     */
    public String deliveryDate;
    /**
     * 交货地点
     */
    public String deliveryAddress;
    /**
     * 使用地点
     */
    public String useAddress;
    /**
     * 接收人
     */
    public String acceptor;

    public String thingCode;

    public String thingName;

//    public ProjectRentThingRefVO(String sourceBill, String thingModel, BigDecimal totalCost, BigDecimal netWorth, BigDecimal valuation, String paramName, String deliveryDate, String deliveryAddress, String useAddress, String acceptor, String thingCode, String thingName) {
//        this.sourceBill = sourceBill;
//        this.thingModel = thingModel;
//        this.totalCost = totalCost;
//        this.netWorth = netWorth;
//        this.valuation = valuation;
//        this.paramName = paramName;
//        this.deliveryDate = deliveryDate;
//        this.deliveryAddress = deliveryAddress;
//        this.useAddress = useAddress;
//        this.acceptor = acceptor;
//        this.thingCode = thingCode;
//        this.thingName = thingName;
//        this.setPk(sourceBill);
//        this.setCode(thingCode);
//        this.setName(thingName);
//    }


    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

    public String getThingModel() {
        return thingModel;
    }

    public void setThingModel(String thingModel) {
        this.thingModel = thingModel;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
    }

    public BigDecimal getValuation() {
        return valuation;
    }

    public void setValuation(BigDecimal valuation) {
        this.valuation = valuation;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getUseAddress() {
        return useAddress;
    }

    public void setUseAddress(String useAddress) {
        this.useAddress = useAddress;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    public String getThingCode() {
        return thingCode;
    }

    public void setThingCode(String thingCode) {
        this.thingCode = thingCode;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }
}
