package com.leasing.customer_service.service;

import com.leasing.customer_service.pojo.CustomerCorpVO;

import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户服务
 **/
public interface CustomerCorpService {

    Map<String, Object> queryForGrid(CustomerCorpVO vo);
}