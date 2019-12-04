package com.leasing.common.repository.sys;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件类别对象存储库层接口
 **/
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.EventTypeDO;
import com.leasing.common.entity.common.dto.EventTypeDTO;
import com.leasing.common.entity.common.vo.EventTypeVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventTypeRepo extends BaseRepository<EventTypeDO, BaseQuery, EventTypeVO,String> {


    @Query(value = "select e from EventTypeDTO e where e.module = :module")
    List<EventTypeDTO> ListEventTypeDTOByModule(@Param("module")Short module);

    @Query(value = "select e from EventTypeDTO e where e.eventCode = :eventCode")
    List<EventTypeDTO> ListEventTypeDTOByEventCode(@Param("eventCode")String eventCode);

    @Query(value = "select e from EventTypeDTO e where e.eventClassCode = :eventClassCode")
    List<EventTypeDTO> ListEventTypeDTOByEventClassCode(@Param("eventClassCode")String eventClassCode);

    @Query(value = "select e from EventTypeDTO e where e.eventName = :eventName")
    List<EventTypeDTO> ListEventTypeDTOByEventName(@Param("eventName")String eventName);

    @Query(value = "select e from EventTypeDTO e where e.module = :module and e.eventCode = :eventCode")
    List<EventTypeDTO> ListEventTypeDTOByModuleAndEventCode(@Param("module")Short module,@Param("eventCode")String eventCode);

    @Query(value = "select e from EventTypeDTO e where e.module = :module and e.cashDeriction = :cashDeriction")
    List<EventTypeDTO> ListEventTypeDTOByModuleAndCashDeriction(@Param("module")Short module,@Param("cashDeriction")Short cashDeriction);



}
