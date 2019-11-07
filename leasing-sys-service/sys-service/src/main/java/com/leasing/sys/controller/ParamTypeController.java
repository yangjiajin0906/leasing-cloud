package com.leasing.sys.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.sys.dos.ParamTypeDO;
import com.leasing.common.entity.sys.query.ParamTypeQuery;
import com.leasing.common.entity.sys.vo.ParamTypeVO;
import com.leasing.common.entity.sys.vo.ParameterVO;
import com.leasing.common.service.sys.ParamTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-24
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/paramType")
public class ParamTypeController {


    @Resource
    ParamTypeService paramTypeService;

    /**
     * @description 分页查询
     * @author Yangjiajin
     * @date 2019/11/4 11:24
     * @param [data]
     * @return com.leasing.common.base.repository.support.PageQueryData<com.leasing.common.entity.sys.vo.ParamTypeVO>
     */
    @RequestMapping(value = "/pageQuery")
    public PageQueryData<ParamTypeVO> pageQuery(String data){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(100);
        ParamTypeQuery query = new ParamTypeQuery();
        PageQueryData<ParamTypeVO> pageQueryData = paramTypeService.pageQuery(pagination,query);
        return pageQueryData;
    }

    /**
     * @description 获得子表数据
     * @author Yangjiajin
     * @date 2019/11/4 11:27
     * @param [data]
     * @return com.leasing.common.entity.sys.vo.ParamTypeVO
     */
    @RequestMapping(value = "/listChild")
    public List<ParameterVO> listChild(String data){
        List<ParameterVO> list = paramTypeService.listChild("0001AA1000000005GZ2X");
        return list;
    }

    /**
     * @description 通过主键查询VO
     * @author Yangjiajin
     * @date 2019/11/4 11:27
     * @param [data]
     * @return com.leasing.common.entity.sys.vo.ParamTypeVO
     */
    @RequestMapping(value = "/findOne")
    public ParamTypeVO findOne(String data) {
        ParamTypeVO vo = paramTypeService.findByPk("0001AA1000000005GZ2X");
        return vo;
    }

    /**
     * @description 保存
     * @author Yangjiajin
     * @date 2019/11/4 11:28
     * @param [data]
     * @return com.leasing.common.entity.sys.dos.ParamTypeDO
     */
    @RequestMapping(value = "/save")
    public ParamTypeDO save(String data){
        ParamTypeDO vo = JSON.parseObject(data,ParamTypeDO.class);
        return paramTypeService.save(vo);
    }

    /**
     * @description 更新
     * @author Yangjiajin
     * @date 2019/11/4 11:28
     * @param [data]
     * @return com.leasing.common.entity.sys.dos.ParamTypeDO
     */
    @RequestMapping(value = "/update")
    public ParamTypeDO update(String data){
        ParamTypeDO vo = JSON.parseObject(data,ParamTypeDO.class);
        return paramTypeService.update(vo);
    }

    /**
     * @description 删除
     * @author Yangjiajin
     * @date 2019/11/4 11:28
     * @param [data]
     * @return void
     */
    @RequestMapping(value = "/delete")
    public void delete(String data){
        ParamTypeDO vo = paramTypeService.findOne("YJJ1AA1000000005GZ2X");
        paramTypeService.delete(vo);
    }


}
