package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CustomerDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c客户信息导入
 **/
public interface CustomerService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    CustomerDO save(CustomerDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<CustomerDO> list);

    /**
     * 批量保存到mongoDB 每50000条数据保存一次
     * @param file
     * @return
     */
    void saveMongoDB(MultipartFile file);

    /**
     * @description 校验数据
     * @author Yangjiajin
     * @date 2019/11/15 17:53
     * @param [list]
     * @return java.util.List<com.leasing.communication.entity.dos.CustomerDO>
     */
    List<CustomerDO> checkData(List<CustomerDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CustomerDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CustomerDO update(CustomerDO vo);

    /**
     * 单体查询
     * @return
     */
    CustomerDO findOne(String pk);
}