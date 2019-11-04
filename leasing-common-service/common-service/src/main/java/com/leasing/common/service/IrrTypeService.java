package com.leasing.common.service;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件对Irr影响接口
 **/
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.entity.common.dos.IrrTypeDO;
import com.leasing.common.entity.common.vo.IrrTypeVO;

public interface IrrTypeService {
    /**
     * 查询全部事件类别对Irr影响列表
     */
    PageQueryData<IrrTypeVO> ListIrrType();

    /**
     * 查询单个事件类别对Irr影响VO对象
     */
    IrrTypeVO getIrrType(String pk);

    /**
     * 查询单个事件类别对Irr影响DO对象
     */
    IrrTypeDO getIrrTypeDO(String pk);

    /**
     * 更新数据
     */
    void updateIrrType(IrrTypeDO dos);

    /**
     * 保存数据
     */
    void saveIrrType(IrrTypeDO dos);

    /**
     * 删除数据
     */
    void deleteIrrType(IrrTypeDO dos);
}
