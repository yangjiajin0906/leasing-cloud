package com.leasing.common.serviceimpl;

import com.leasing.common.base.repository.IrrTypeRepo;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.service.IrrTypeService;
import com.leasing.common.entity.common.dos.IrrTypeDO;
import com.leasing.common.entity.common.vo.IrrTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件对Irr影响实现类
 **/
@Service("IrrTypeServiceImpl")
@Transactional
public class IrrTypeServiceImpl implements IrrTypeService {

    @Autowired
    IrrTypeRepo irrTypeRepo;

    @Override
    public PageQueryData<IrrTypeVO> ListIrrType(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(50);
//        IrrTypeQuery queryvo =new IrrTypeQuery();
        //queryvo.setIrrTypeName(Short.parseShort("1"));
        PageQueryData<IrrTypeVO> list = irrTypeRepo.pageQuery(pagination,null,"ListIrrType");
        return list;
    }

    @Override
    public IrrTypeVO getIrrType(String pk){
        return irrTypeRepo.findOne(pk,IrrTypeVO.class);
    }

    @Override
    public IrrTypeDO getIrrTypeDO(String pk){
        return irrTypeRepo.findOne(pk);
    }

    @Override
    public void updateIrrType(IrrTypeDO dos){
        irrTypeRepo.updateEntity(dos);
    }

    @Override
    public void saveIrrType(IrrTypeDO dos){
        irrTypeRepo.saveEntity(dos);
    }

    @Override
    public void deleteIrrType(IrrTypeDO dos){
        irrTypeRepo.delete(dos);
    }

}