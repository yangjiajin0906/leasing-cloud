package com.leasing.common.base.repository.refpository;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.refvo.base.OrgrefVO;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:wangjc@yonyou.com
 * @description: 机构参照存储库接口
 **/
@Repository
public interface OrgRefRepo extends BaseRepository<OrgDTO, BaseQuery, OrgrefVO, String> {

}