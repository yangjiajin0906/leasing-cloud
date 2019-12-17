package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.utils.base.DateUtils;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.communication.entity.dos.AccruedDetailDO;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.query.CbOverdueContractQuery;
import com.leasing.communication.entity.vo.AccruedChildVO;
import com.leasing.communication.entity.vo.AccruedVO;
import com.leasing.communication.repository.CbCapitalDetailRepo;
import com.leasing.communication.service.AccruedService;
import com.leasing.communication.service.CbContractService;
import com.leasing.communication.service.CbFileOssService;
import com.leasing.communication.test.DemoForOutSysClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = JSON.parseObject(data,Map.class);
        Pagination pagination = JSON.parseObject(data,Pagination.class);
        Object queryData = map.get("queryData");
        AccruedQuery accruedQuery = new AccruedQuery();
        if(!ObjectUtil.isEmpty(queryData)){
            accruedQuery = JSON.parseObject(map.get("queryData").toString(),AccruedQuery.class);
            accruedQuery.setAccrualMonth(accruedQuery.getAccrualMonth().substring(0, 7));
        }
        PageQueryData<AccruedVO> pageQueryData = leaseAccruedService.pageQuery(pagination,accruedQuery,"accruedRepo.pageQuery");
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
        AccruedDO dos = JSON.parseObject(JSON.toJSONString(vo),AccruedDO.class);
        dos.setPkOrg(vo.getPkOrg().getRefpk());
        dos.setPkCorp(vo.getPkOrg().getRefpk());
        dos.setBillstatus(Billstatus.INITALIZE.getShort());
        String currentMonth = vo.getAccrualMonth().substring(0, 7);
        dos.setAccrualMonth(currentMonth);
        dos.setOperateTime(DateUtils.getCurDateTime());
        dos.setOperateDate(DateUtils.getCurDate());
        List<AccruedDetailDO> list = new ArrayList();
        for(int i = 0; i<vo.getPkAccruedDetail().size(); i++){
            AccruedDetailDO accruedBDO = dos.getPkAccruedDetail().get(i);
            accruedBDO.setPkContract(vo.getPkAccruedDetail().get(i).getPkContract().getPkContract());
            accruedBDO.setPkCurrtype(vo.getPkAccruedDetail().get(i).getPkCurrtype().getPkCurrtype());
            list.add(accruedBDO);
        }
        dos.setPkAccruedDetail(list);
        dos.setPkOrg("1003");
        dos = leaseAccruedService.save(dos);
        leaseAccruedService.updateAccruedFlag(dos,Short.valueOf("0"));
        return ResultUtils.successWithData(dos);
    }

//    @Resource
//    CbFileOssService cbFileOssService;
//
//    @RequestMapping(value = "/test")
//    public void test() {
//        List<FileOssLogDTO> logDTOS = cbFileOssService.fileImportByDate();
//        System.out.println(logDTOS);
//    }

    @Resource
    CbCapitalDetailRepo cbCapitalDetailRepo;
    @RequestMapping(value = "/test")
    public void test() {
        CbCapitalDetailDO detailDO = cbCapitalDetailRepo.findOne("5de967023ab847d9b74b");
        detailDO.setCurrtypecode("CNY");
        detailDO.setCustomerCode("01166");
        detailDO.setContCode("003-ZL-DX-2009001");
        DemoForOutSysClient.addFlow(detailDO,"6");
    }

    @Resource
    CbContractService cbContractService;
    @RequestMapping(value = "/test2")
    public void test2(){
        CbContractDO dos = cbContractService.findOne("CB654703295561990143");
        List<CbContractDO> list = new ArrayList<>();
        list.add(dos);
        cbContractService.updateInoutPlan(list);
    }

}