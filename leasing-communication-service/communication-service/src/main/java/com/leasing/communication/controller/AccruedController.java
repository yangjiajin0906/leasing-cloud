package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.communication.entity.dos.AccruedBDO;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccruedBVO;
import com.leasing.communication.entity.vo.AccruedChildVO;
import com.leasing.communication.entity.vo.AccruedVO;
import com.leasing.communication.service.AccruedService;
import com.leasing.communication.service.CbFileOssService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 月末计提Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/accrued")
public class AccruedController {
    @Resource
    AccruedService leaseAccruedService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        AccruedQuery leaseAccruedQuery = new AccruedQuery();
        Pagination pagination = new Pagination(1, 50);
        PageQueryData<AccruedVO> pageQueryData = leaseAccruedService.pageQuery(pagination,leaseAccruedQuery,"accruedRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }

    @RequestMapping(value = "/findOne")
    public ResResult findOne(@RequestBody(required = false) String data){
        AccruedChildVO vo = JSON.parseObject(data, AccruedChildVO.class);
        vo = leaseAccruedService.findByPk(vo.getPk());
        return ResultUtils.successWithData(vo);
    }

    @RequestMapping(value = "/onAdd")
    public ResResult onAdd(@RequestBody(required = false) String data){
        AccruedVO vo = JSON.parseObject(data,AccruedVO.class);
        OrgDTO org = vo.getPkOrg();
        List<AccruedVO> list = new ArrayList<>();
        vo = leaseAccruedService.onAdd(vo.getPkOrg().getRefpk(),vo.getAccrualMonth(), list);
        vo.setPkOrg(org);
        return ResultUtils.successWithData(vo);
    }

    @RequestMapping(value = "/save")
    public ResResult save(@RequestBody(required = false) String data){
        AccruedVO vo = JSON.parseObject(data,AccruedVO.class);
        AccruedDO dos = DozerUtils.convert(vo,AccruedDO.class);
        dos.setPkLeaseAccrued("1111111111111133311");
        dos.setLeaseAccruedB(null);
        List<AccruedBDO> list = new ArrayList();
        for(int i = 0; i<vo.getLeaseAccruedB().size(); i++){
            AccruedBDO accruedBDO = DozerUtils.convert(vo.getLeaseAccruedB().get(i),AccruedBDO.class);
            accruedBDO.setPkLeaseAccruedB((i+"111111111111111111111").substring(0,20));
            list.add(accruedBDO);
        }
        dos.setLeaseAccruedB(list);
        dos.setPkOrg("1003");
        dos = leaseAccruedService.save(dos);
        return ResultUtils.successWithData(dos);
    }

    @Resource
    CbFileOssService cbFileOssService;

    @RequestMapping(value = "/test")
    public void test() {
        List<FileOssLogDTO> logDTOS = cbFileOssService.fileImportByDate();
        System.out.println(logDTOS);
    }
}