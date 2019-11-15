package com.leasing.common.base.repository.refpository;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.ref.base.OrgrefVO;
import com.leasing.common.vo.foundation.OrgDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:wangjc@yonyou.com
 * @description: 机构参照存储库接口
 **/
@Repository
public interface OrgRefRepo extends BaseRepository<OrgDTO, BaseQuery, OrgrefVO, String> {

}