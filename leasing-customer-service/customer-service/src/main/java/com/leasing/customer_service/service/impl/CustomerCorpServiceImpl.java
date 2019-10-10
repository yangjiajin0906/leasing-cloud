package com.leasing.customer_service.service.impl;

import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.repository.CustomerCorpRepository;
import com.leasing.customer_service.service.CustomerCorpService;
import com.leasing.customer_service.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/

@Service("CustomerCorpService")
public class CustomerCorpServiceImpl implements CustomerCorpService {

    @Resource
    private CustomerCorpRepository corpRepository;

    @Override
    public Map<String, Object> queryForGrid(CustomerCorpVO vo) {
        Sort sort = new Sort(Sort.Direction.DESC, "operateTime");
        Page<CustomerCorpVO> vos = corpRepository.findAll(vo.toSpec(), vo.toPageable(sort));

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", vos.getContent());
        resultMap.put("total", vos.getTotalElements());
        resultMap.put("totalPages", vos.getTotalPages());
        return resultMap;
    }

    /**
     * 排序字段以及排序方式的设置方法，这里不要加“order by”关键字
     *
     * @return
     */
    public String getOrderBy() {
        StringBuffer sql = new StringBuffer();
        sql.append("  case billstatus ");
        sql.append("         when 20 then ");
        sql.append("              1 ");
        sql.append("         when 36 then ");
        sql.append("              2 ");
        sql.append("         when 204 then ");
        sql.append("              3 ");
        sql.append("         when 8 then ");
        sql.append("              4 ");
        sql.append("         when 9 then ");
        sql.append("              5 ");
        sql.append("         end, ");
        sql.append("   operate_time desc ");

        return sql.toString();
    }
}