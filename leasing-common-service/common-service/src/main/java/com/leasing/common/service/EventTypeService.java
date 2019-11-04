package com.leasing.common.service;


import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.entity.common.dos.EventTypeDO;
import com.leasing.common.entity.common.dto.EventTypeDTO;
import com.leasing.common.entity.common.vo.EventTypeVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件类别实现接口
 **/

public interface EventTypeService {
    /**
     * 查询全部事件类别数据
     */
    PageQueryData<EventTypeVO> ListEventType();

    /**
     * 查询单个事件类别VO对象
     */
    EventTypeVO getEventType(String pk);

    /**
     * 更新数据
     */
    void updateEventType(EventTypeDO dos);

    /**
     * 保存数据
     */
    void saveEventType(EventTypeDO dos);

    /**
     * 删除数据
     */
    void deleteEventType(EventTypeDO dos);

    /**
     * 根据业务模块获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByModule(Short module);

    /**
     * 根据事件类别编码获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByEventCode(String eventCode);

    /**
     * 根据事件分类编码获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByEventClassCode(String eventClassCode);

    /**
     * 根据事件类别名称获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByEventName(String eventName);

    /**
     * 根据业务模块及事件类别编码获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByModuleAndEventCode(Short module,String eventCode);

    /**
     * 根据业务模块及现金流方向获取事件类别列表DTO
     */
    List<EventTypeDTO> ListEventTypeDTOByModuleAndCashDeriction(Short moudle,Short cashDeriction);
}
