package com.leasing.common.serviceimpl.sys;

import com.leasing.common.entity.common.dos.PowerMenuDO;
import com.leasing.common.entity.common.dto.RoleOrgDTO;
import com.leasing.common.entity.common.query.PowerMenuQuery;
import com.leasing.common.entity.common.query.RoleOrgQuery;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.entity.common.vo.PowerMenuVO;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import com.leasing.common.entity.foundation.vo.RoleOrgVO;
import com.leasing.common.entity.foundation.vo.RoleVO;
import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.common.repository.sys.DFuncMenuRepo;
import com.leasing.common.repository.sys.PowerMenuRepo;
import com.leasing.common.repository.sys.RoleOrgRepo;
import com.leasing.common.repository.sys.SystemRepository;
import com.leasing.common.service.sys.PowerMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description:权限分配接口实现类
 **/
@Service("PowerMenuServiceImpl")
@Transactional
public class PowerMenuServiceImpl implements PowerMenuService {
    @Autowired
    PowerMenuRepo powerMenuRepo;

    @Autowired
    DFuncMenuRepo dFuncMenuRepo;

    @Autowired
    SystemRepository systemRepository;

    @Autowired
    RoleOrgRepo roleOrgRepo;



    @Override
    public List<DFuncMenuVO> ListPowerFuncMenuByUser(UserVO user){
        SystemVO systemVO = systemRepository.findOne("11111111111111111111",SystemVO.class);
        List<DFuncMenuVO> list = dFuncMenuRepo.ListPowerFuncMenuByUser(user.getPkUser(), systemVO);
        return list;
    }

    @Override
    public List<DFuncMenuVO> ListPowerFuncMenu(RoleOrgVO vo){
        SystemVO systemVO = systemRepository.findOne("11111111111111111111",SystemVO.class);
        List<DFuncMenuVO> list = dFuncMenuRepo.ListPowerFuncMenu(vo.getPkRole(), vo.getPkCorp(),systemVO);
        return list;
    }

    @Override
    public List<PowerMenuVO> ListAllPowerMenuVO(){
        PowerMenuQuery query = new PowerMenuQuery();
        return powerMenuRepo.pageQuery(query,"ListAllPowerMenuVO");
    }

    @Override
    public List<RoleOrgDTO> ListAllRoleOrg(){
        RoleOrgQuery query = new RoleOrgQuery();
        List<RoleOrgVO> list = roleOrgRepo.pageQuery(query,"ListRoleOrg");
        List<RoleOrgDTO> resultlist = new ArrayList<>();
        Map<RoleVO,List<OrgDTO>> map = new HashMap<>();
        //遍历得到list 将相同角色存入key 不同机构迭代接入List 存入map
        for (RoleOrgVO roleOrgVO:list) {
            if(map.containsKey(roleOrgVO.getPkRole())){
                List<OrgDTO> orgList = map.get(roleOrgVO.getPkRole());
                orgList.add(roleOrgVO.getPkCorp());
                map.put(roleOrgVO.getPkRole(),orgList);
            }else{
                List<OrgDTO> orgList = new ArrayList<>();
                orgList.add(roleOrgVO.getPkCorp());
                map.put(roleOrgVO.getPkRole(), orgList);
            }
        }
        //遍历得到最后的结果map 构造所需返回指定类型的结果集
        Iterator<RoleVO> keys = map.keySet().iterator();
        while (keys.hasNext()){
            RoleVO key = keys.next();
            List<OrgDTO> orglist = map.get(key) ;
            RoleOrgDTO dto = new RoleOrgDTO();
            dto.setPkRole(key);
            dto.setOrgList(orglist);
            resultlist.add(dto);
        }
        return resultlist;
    }

    @Override
    public void deletePowerFuncMenu(String pkRole,String pkOrg){
        powerMenuRepo.deletePowerMenu(pkRole,pkOrg);
    }

    @Override
    public void addPowerFuncMenu(PowerMenuDO dos){
        powerMenuRepo.save(dos);
    }





}