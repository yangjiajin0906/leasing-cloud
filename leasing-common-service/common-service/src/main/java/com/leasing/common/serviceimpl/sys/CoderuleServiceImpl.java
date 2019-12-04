package com.leasing.common.serviceimpl.sys;

import com.leasing.common.repository.sys.CoderuleRepo;
import com.leasing.common.repository.sys.CoderuleTypeRepo;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.common.dos.CoderuleTypeDO;
import com.leasing.common.service.sys.CoderuleService;
import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.vo.CoderuleVO;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.enums.constant.CodeRuleKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则实现类
 **/
@Service("CoderuleServiceImpl")
@Transactional
public class CoderuleServiceImpl implements CoderuleService {
    @Autowired
    CoderuleRepo coderuleRepo;

    @Autowired
    CoderuleTypeRepo coderuleTypeRepo;


    @Override
    public PageQueryData<CoderuleVO> ListCoderule(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(50);
//        CoderuleQuery queryvo =new CoderuleQuery();
//        queryvo.setBusinessPoint("10082406");
        PageQueryData<CoderuleVO> list = coderuleRepo.pageQuery(pagination,null,"ListCoderule");
        return list;
    }
    @Override
    public CoderuleVO getCoderule(String pk){
        return coderuleRepo.findOne(pk,CoderuleVO.class);
    }
    @Override
    public CoderuleDO getCoderuleDO(String pk){
        return coderuleRepo.findOne(pk);
    }
    @Override
    public void updateCoderule(CoderuleDO dos){
        coderuleRepo.updateEntity(dos);
    }
    @Override
    public void saveCoderule(CoderuleDO dos){
        coderuleRepo.saveEntity(dos);
    }
    @Override
    public void deleteCoderule(CoderuleDO dos){
        coderuleRepo.delete(dos);
    }

    @Override
    public List<Map<String,Object>> findCoderuleByFuncCodeAndVariableName(String funcCode,String variableName){
        return coderuleRepo.findCoderuleByFuncCodeAndVariableName(funcCode,variableName, Billstatus.CHECK.getShort());
    }

    @Override
    public List<Map<String,Object>> getCodeRuleTypeWithNoLiquid(String pkCoderule){
        return  coderuleRepo.getCodeRuleTypeWithNoLiquid(pkCoderule, CodeRuleKey.LIQUID);
    }

    @Override
    public List<Map<String,Object>> getCodeRuleTypeWithLiquid(String pkCoderule,String referSort){
        return coderuleRepo.getCodeRuleTypeWithLiquid(pkCoderule,CodeRuleKey.LIQUID,referSort);
    }

    @Override
    public void insertCoderuleType(CoderuleTypeDO dos){
        coderuleTypeRepo.saveEntity(dos);
    }

    @Override
    public void updateCoderuleType(String INITIAL_VALUE,String PK_CODERULE_TYPE){
        CoderuleTypeDO dos = coderuleTypeRepo.findOne(PK_CODERULE_TYPE);
        if(dos != null){
            dos.setInitialValue(Integer.parseInt(INITIAL_VALUE));
            coderuleTypeRepo.updateEntity(dos);
        }
    }


}