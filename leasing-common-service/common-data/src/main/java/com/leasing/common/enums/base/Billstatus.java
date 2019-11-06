package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class Billstatus extends EnumType {
    private static final long serialVersionUID = 1L;
    static final int TRUSTEE_START = 100;
    static final int ULS_START = 200;
    public static final Billstatus UNCHECK = new Billstatus(0, "复核中");
    public static final Billstatus CHECK = new Billstatus(1, "已复核");
    public static final Billstatus UNPASS = new Billstatus(2, "复核未通过");
    public static final Billstatus DISCARDED = new Billstatus(3, "已作废");
    public static final Billstatus CONFIRMED = new Billstatus(4, "已确认");
    public static final Billstatus STARTED = new Billstatus(5, "已启动");
    public static final Billstatus DISCERPTION = new Billstatus(6, "已下发");
    public static final Billstatus ACCOUNTED = new Billstatus(7, "已到账");
    public static final Billstatus UNAPPROVE = new Billstatus(8, "审核未通过");
    public static final Billstatus APPROVE = new Billstatus(9, "审核通过");
    public static final Billstatus ASSIGNED = new Billstatus(10, "已收益入账");
    public static final Billstatus BILL = new Billstatus(11, "已制单");
    public static final Billstatus BACKEND = new Billstatus(12, "已退回");
    public static final Billstatus ORDERD = new Billstatus(13, "已生成指令");
    public static final Billstatus COMPLETED = new Billstatus(14, "已完毕");
    public static final Billstatus EXAMINE = new Billstatus(15, "审批同意");
    public static final Billstatus UNEXAMINE = new Billstatus(16, "审批不同意");
    public static final Billstatus PROCESS = new Billstatus(17, "处理中");
    public static final Billstatus EFFECT = new Billstatus(18, "指令生效");
    public static final Billstatus COMPLETE = new Billstatus(19, "处理完成");
    public static final Billstatus INITALIZE = new Billstatus(20, "暂存");
    public static final Billstatus DISCARD = new Billstatus(21, "审核作废");
    public static final Billstatus WAITLEASE = new Billstatus(22, "待起租");
    public static final Billstatus INITIAL = new Billstatus(99, "初始");
    public static final Billstatus GATHERED = new Billstatus(105, "已汇总");
    public static final Billstatus GENERATOR = new Billstatus(111, "已生成");
    public static final Billstatus REPORT = new Billstatus(112, "已上报");
    public static final Billstatus MATCHED = new Billstatus(113, "匹配完成");
    public static final Billstatus NON_USE = new Billstatus(201, "未启用");
    public static final Billstatus USED = new Billstatus(202, "启用");
    public static final Billstatus STOP_USED = new Billstatus(203, "停用");
    public static final Billstatus APPROVING = new Billstatus(204, "审核中");
    public static final Billstatus SUBMIT = new Billstatus(205, "已提交");
    public static final Billstatus FLOW_UNREPORT = new Billstatus(31, "未上报");
    public static final Billstatus FLOW_REPORT = new Billstatus(32, "已上报");
    public static final Billstatus FLOW_APPROVING = new Billstatus(33, "审批中");
    public static final Billstatus FLOW_APPROVED = new Billstatus(34, "审批通过");
    public static final Billstatus FLOW_REJECT = new Billstatus(35, "审批不通过");
    public static final Billstatus FLOW_DISMISS = new Billstatus(36, "驳回修改");
    public static final Billstatus FLOW_CHANGING = new Billstatus(37, "正在执行变更");
    public static final Billstatus FLOW_CHANGING_FINISH = new Billstatus(38, "已变更完成");
    public static final Billstatus NOT_INITALIZE = new Billstatus(39, "未初始");
    public static final Billstatus FORMAL = new Billstatus(40, "正式");

    public Billstatus(int code, String label) {
        super(code, label);
    }
}