package com.leasing.communication.entity.vo;

/**
 * @project:leasing-cloud
 * @date:2019/11/28
 * @author:Yjj@yonyou.com
 * @description: 核算主体
 **/
public class GlorgbookRefVO {
    /**
     * 机构主键
     */
    private String pkEntityorg;
    /**
     * 是否启用(是为Y)
     */
    private String isstartuse;

    /**
     * Description: 机构主键<br>
     *
     * @return 机构主键
     * @author: kehy<br>
     * @Date：2014-2-8
     */
    public String getPkEntityorg() {
        return pkEntityorg;
    }

    /**
     * Description: 机构主键<br>
     *
     * @param pkEntityorg
     *            机构主键
     * @author: kehy<br>
     * @Date：2014-2-8
     */
    public void setPkEntityorg(String pkEntityorg) {
        this.pkEntityorg = pkEntityorg;
    }

    /**
     * Description: 是否启用<br>
     *
     * @return 是否启用
     * @author: kehy<br>
     * @Date：2014-2-8
     */
    public String getIsstartuse() {
        return isstartuse;
    }

    /**
     * Description: 是否启用<br>
     *
     * @param isstartuse
     *            是否启用
     * @author: kehy<br>
     * @Date：2014-2-8
     */
    public void setIsstartuse(String isstartuse) {
        this.isstartuse = isstartuse;
    }

}