package com.leasing.common.repository.sys;
/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件对Irr影响存储库层接口
 **/
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.IrrTypeDO;
import com.leasing.common.entity.common.vo.IrrTypeVO;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrTypeRepo extends BaseRepository<IrrTypeDO, BaseQuery, IrrTypeVO,String> {

}
