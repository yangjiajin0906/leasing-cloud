package com.leasing.sys.serviceimpl;

import com.leasing.sys.dao.SysTestRepository;
import com.leasing.sys.service.SysTestService;
import com.leasing.sys.vo.SysTestVO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-29
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service(value = "sys.SysTestServiceImpl")
public class SysTestServiceImpl implements SysTestService {

    @Resource
    SysTestRepository sysTestRepository;

    @Override
    public int update(SysTestVO vo) {
        sysTestRepository.save(vo);
        return 0;
    }

    @Override
    public int insert(SysTestVO vo) {
        sysTestRepository.save(vo);
        Assert.isTrue(Boolean.FALSE,"my test assert service insert");
        return 0;
    }

    @Override
    public int delete(SysTestVO vo) {
        sysTestRepository.delete(vo);
        return 0;
    }

    @Override
    public List<SysTestVO> queryAll() {
        List<SysTestVO> sysTestVOS = sysTestRepository.findAll();
        return sysTestVOS;
    }

    @Override
    public List<SysTestVO> pageQuery(SysTestVO vo) {
        Example example = Example.of(vo);
        Page<SysTestVO> page = sysTestRepository.findAll(example, PageRequest.of(1,20));
        return page.getContent();
    }

    @Override
    public SysTestVO findOne(Long pk) {
        sysTestRepository.findByPkSysTest(pk);
        return null;
    }
}
