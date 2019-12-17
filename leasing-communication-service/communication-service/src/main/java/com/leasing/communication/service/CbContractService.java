package com.leasing.communication.service;

import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.vo.AccrualVO;
import com.leasing.communication.entity.vo.CbContractVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C业务合同接口处理
 **/
public interface CbContractService extends CbFileImpService{

    List<CbContractImpDTO> dataImp(MultipartFile file);

    List<CbContractDO> dataConvert(List<CbContractImpDTO> list);

    void save(List<CbContractDO> list);

    List<CbContractVO> testQuery();

    /**
     * @description 查询一条数据
     * @Patam pk 合同主键
     * @author Yangjiajin
     * @date 2019/12/16 11:45
     */
    CbContractDO findOne(String pk);

    /**
     * @description 更新收支计划表 并生成计提当前表数据
     * @Patam list 合同列表
     * @author Yangjiajin
     * @date 2019/12/16 11:45
     */
    void updateInoutPlan(List<CbContractDO> list);

}
