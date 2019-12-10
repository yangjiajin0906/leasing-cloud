package com.leasing.common.serviceimpl.sys;

import com.leasing.common.repository.sys.EventTypeRepo;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.service.sys.EventTypeService;
import com.leasing.common.entity.common.dos.EventTypeDO;
import com.leasing.common.entity.common.dto.EventTypeDTO;
import com.leasing.common.entity.common.query.EventTypeQuery;
import com.leasing.common.entity.common.vo.EventTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件类别实现类
 **/
@Service("EventTypeServiceImpl")
@Transactional
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    EventTypeRepo eventTypeRepo;

    @Override
    public PageQueryData<EventTypeVO> ListEventType(){
        Pagination pagination = new Pagination();
        pagination.setPageIndex(1);
        pagination.setPageSize(50);
        EventTypeQuery queryvo =new EventTypeQuery();
        //queryvo.setEventClassName("投放");
        PageQueryData<EventTypeVO> list = eventTypeRepo.pageQuery(pagination,queryvo,"ListEventType");
        return list;
    }

    @Override
    public EventTypeVO getEventType(String pk){
        return eventTypeRepo.findOne(pk,EventTypeVO.class);
    }

    @Override
    public void updateEventType(EventTypeDO dos){
        eventTypeRepo.updateEntity(dos);
    }

    @Override
    public void saveEventType(EventTypeDO dos){
        eventTypeRepo.saveEntity(dos);
    }

    @Override
    public void deleteEventType(EventTypeDO dos){
        eventTypeRepo.delete(dos);
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByModule(Short module){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByModule(module);
            return result;
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByEventCode(String eventCode){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByEventCode(eventCode);
        return result;
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByEventClassCode(String eventClassCode){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByEventClassCode(eventClassCode);
        return result;
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByEventName(String eventName){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByEventName(eventName);
        return result;
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByModuleAndEventCode(Short module,String eventCode){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByModuleAndEventCode(module,eventCode);
        return result;
    }

    @Override
    public List<EventTypeDTO> ListEventTypeDTOByModuleAndCashDeriction(Short moudle,Short cashDeriction){
        List<EventTypeDTO> result = eventTypeRepo.ListEventTypeDTOByModuleAndCashDeriction(moudle,cashDeriction);
        return result;
    }


}