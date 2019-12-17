package com.leasing.common.utils.sys;

import com.leasing.common.service.sys.EventTypeService;
import com.leasing.common.entity.common.dto.EventTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description: 获取事件类别的工具类 可通过多种方式获取
 **/
@Component
public class EventTypeUtil {
    @Autowired
    EventTypeService eventTypeService;

    public static EventTypeUtil eventTypeUtil;

    @PostConstruct
    public void init(){
        eventTypeUtil = this;
    }

    /**
     * 根据业务模块获取事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeByModule(Short module){
        Assert.notNull(module, "业务模块编码不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByModule(module);
        return list;
    }

    /**
     * 根据事件类别编码获取事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeDTOByEventCode(String eventCode){
        Assert.notNull(eventCode, "事件类别编码不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByEventCode(eventCode);
        return list;
    }

    /**
     * 根据事件分类编码获取事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeDTOByEventClassCode(String eventClassCode){
        Assert.notNull(eventClassCode, "事件分类编码不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByEventClassCode(eventClassCode);
        return list;
    }

    /**
     * 根据事件类别名称获取事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeDTOByEventName(String eventName){
        Assert.notNull(eventName, "事件类别名称不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByEventName(eventName);
        return list;
    }

    /**
     * 根据事件类别编码及业务模块获取相应的事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeDTOByModuleAndEventCode(Short module,String eventCode){
        Assert.notNull(module, "业务模块不能为空!");
        Assert.notNull(eventCode, "事件类别编码不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByModuleAndEventCode(module,eventCode);
        return list;
    }

    /**
     * 根据业务模块及现金流方向获取相应的事件类别列表
     */
    public static List<EventTypeDTO> ListEventTypeDTOByModuleAndCashDeriction(Short moudle,Short cashDeriction){
        Assert.notNull(moudle, "业务模块不能为空!");
        Assert.notNull(cashDeriction, "现金流向不能为空!");
        List<EventTypeDTO> list = eventTypeUtil.eventTypeService.ListEventTypeDTOByModuleAndCashDeriction(moudle,cashDeriction);
        return list;
    }

    /**
     * 根据事件类主键获取事件类别
     */
    public static EventTypeDTO eventTypeDTOByPk(String pk){
        Assert.notNull(pk, "事件类别主键不能为空!");
        EventTypeDTO eventTypeDTO = eventTypeUtil.eventTypeService.eventTypeDTOByPk(pk);
        return eventTypeDTO;
    }

}