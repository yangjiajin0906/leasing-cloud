package com.leasing.common.utils.tools;

import com.leasing.common.config.OIDSingleton;

/**
 * @project:leasing-cloud
 * @date:2019-12-10
 * @author:lvcna@yonyou.com
 * @description: 主键生成器
 **/
public class OIDUtils {
    public static String getOid(){
        long oid = OIDSingleton.SNOWFLAKEID.getOidWorker().nextId();
        return "CB".concat(String.valueOf(oid));
    }

}
