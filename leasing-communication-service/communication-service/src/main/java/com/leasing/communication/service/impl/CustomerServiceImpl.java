package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.CacheVO;
import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.repository.CustomerRepo;
import com.leasing.communication.service.CustomerService;
import com.leasing.communication.utils.EasyPoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service("communication.CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService{

    @Resource
    CustomerRepo customerRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public CustomerDO save(CustomerDO vo) {
        return customerRepo.saveEntity(vo);
    }

    @Override
    public void save(List<CustomerDO> list) {
        customerRepo.saveAll(list);
    }

    @Override
    public void saveMongoDB(MultipartFile file) {
        Long startTime = new Date().getTime();
        List<CustomerDO> list = EasyPoiUtils.importExcel(file,1,1,CustomerDO.class);
        int aSingle = 5000; //单次处理一万条数据
        int size = list.size();
        int theTotalNumber = size / aSingle + 1; //总共处理次数
        boolean special = size % aSingle == 0; //是否整除
        List<CustomerDO> cutList = null;
        for (int i = 0; i < theTotalNumber; i++) {
            if (i == theTotalNumber - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(aSingle * i, size);
            } else {
                cutList = list.subList(aSingle * i, aSingle * (i + 1));
            }
            this.saveMongo(cutList);
            System.out.println("第" + (i + 1) + "组：" + cutList.size());
        }
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+size+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }

    /**
     * @description 把list封装成对象,保存到mongo
     * @author Yangjiajin
     * @date 2019/11/14 10:50
     * @param [list]
     * @return void
     */
    private void saveMongo(List<CustomerDO> list){
        CacheVO<CustomerDO> cacheVO = new CacheVO<>();
        cacheVO.setId("Customer"+new Date().getTime());
        cacheVO.setTag(0); //第一次保存状态设为0
        cacheVO.setData(list);
        mongoTemplate.save(cacheVO,"yc-customer");
    }

    @Override
    public List<CustomerDO> checkData(List<CustomerDO> list) {
        return list;
    }

    @Override
    public void delete(CustomerDO vo) {
        customerRepo.delete(vo);
    }

    @Override
    public CustomerDO update(CustomerDO vo) {
        return customerRepo.updateEntity(vo);
    }

    @Override
    public CustomerDO findOne(String pk) {
        return customerRepo.findOne(pk);
    }
}