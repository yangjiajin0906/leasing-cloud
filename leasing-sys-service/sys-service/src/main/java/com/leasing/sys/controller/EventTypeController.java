package com.leasing.sys.controller;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.service.sys.EventTypeService;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.dos.EventTypeDO;
import com.leasing.common.entity.common.dto.EventTypeDTO;
import com.leasing.common.entity.common.vo.EventTypeVO;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.sys.EventTypeUtil;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.entity.customer.dto.OrgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:wangjc@yonyou.com
 * @description:事件类别前台controller
 **/
@RestController
@RequestMapping(value = "/leasing/event")
public class EventTypeController {
    @Autowired
    EventTypeService eventTypeService;

    /**
     * 获取事件类别列表
     * @return PageQueryData
     */
    @RequestMapping(value = "ListEventType")
    public ResResult ListEventType(){
        PageQueryData<EventTypeVO> result = eventTypeService.ListEventType();
        return ResultUtils.successWithData(result);
    }

    /**
     * 更新事件类别对象
     * @return dos
     */
    @RequestMapping(value = "updateEventType")
    public ResResult updateEventType(){
        EventTypeVO vo = eventTypeService.getEventType("0001AA10000000053XWW");
        EventTypeDO dos = DozerUtils.convert(vo,EventTypeDO.class);
        dos.setOrderNum(9);
        eventTypeService.updateEventType(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 保存事件类别对象
     * @return dos
     */
    @RequestMapping(value = "saveEventType")
    public ResResult saveEventType(){
        EventTypeVO vo = new EventTypeVO();
        String str = UUID.randomUUID().toString().replace("-","");
        vo.setPkEventType(str.substring(0,20));
        vo.setModule(Short.valueOf("1"));
        vo.setEventClassCode("12");
        vo.setEventClassName("追加收益");
        vo.setEventCode("12001");
        vo.setEventName("追加收益");
        vo.setCashDeriction(Short.valueOf("0"));
        vo.setIsEnable(Short.valueOf("0"));
        vo.setBillstatus(Short.valueOf("20"));
        OrgDTO dto = new OrgDTO();
        dto.setPkOrg("1003");
        vo.setPkOrg(dto);
        EventTypeDO dos = DozerUtils.convert(vo,EventTypeDO.class);
        eventTypeService.saveEventType(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 删除事件类别对象
     * @return dos
     */
    @RequestMapping(value = "deleteEventType")
    public ResResult deleteEventType(){
        EventTypeVO vo = eventTypeService.getEventType("0001AA10000000053XWW");
        EventTypeDO dos = DozerUtils.convert(vo,EventTypeDO.class);
        eventTypeService.deleteEventType(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 测试事件类别工具类的使用
     */
    @RequestMapping(value = "testUtil")
    public ResResult testUtil(){
        List<EventTypeDTO> list1 = EventTypeUtil.ListEventTypeByModule(Short.parseShort("1"));
        return ResultUtils.successWithData(list1);
    }


}