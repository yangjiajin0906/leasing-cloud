package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.DateUtils;
import com.leasing.common.utils.frame.SpringUtils;
import com.leasing.common.utils.tools.AliyunOssUtils;
import com.leasing.communication.entity.dto.CbImpDetailDTO;
import com.leasing.communication.entity.dto.CbImpSetDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.entity.param.FileImpParam;
import com.leasing.communication.enums.CbImpType;
import com.leasing.communication.repository.SourceSystemRepo;
import com.leasing.communication.service.CbFileImpService;
import com.leasing.communication.service.CbFileOssService;
import com.leasing.communication.service.CbImpSetService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-5
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service(value = "communication.CbFileOssServiceImpl")
public class CbFileOssServiceImpl implements CbFileOssService {

    @Resource
    CbImpSetService cbImpSetService;

    @Resource
    SourceSystemRepo sourceSystemRepo;

    @Override
    public List<OSSObject> loadFileListByDir(String dir) {
        return AliyunOssUtils.loadFileByDir(dir);
    }

    @Override
    public OSSObject loadFileByKey(String key) {
        return AliyunOssUtils.downLoadByKey(key);
    }

    @Override
    public List<OSSObject> loadFileListByDate(SourceSystemDTO sourceSystemDO) {
        String date = DateUtils.getCurDate();
        return AliyunOssUtils.loadFileByDir(date);
    }

    @Override
    public List<FileOssLogDTO> fileImportByDate() {
        List<SourceSystemDTO> sourceSystemDTOS = sourceSystemRepo.findAllDTO();
        List<FileOssLogDTO> logDTOS = new ArrayList<>();
        for(SourceSystemDTO sourceSystemDTO : sourceSystemDTOS){
            List<OSSObject> ossObjects = loadFileListByDate(sourceSystemDTO);
            List<FileImpParam> params = packFileParam(ossObjects, sourceSystemDTO);
            List<FileOssLogDTO> dtos = filePersist(params);
            logDTOS.addAll(dtos);
        }
        return logDTOS;
    }

    /**
     * 组装文件导入参数
     * @param OssList
     * @return
     */
    private List<FileImpParam> packFileParam(List<OSSObject> OssList, SourceSystemDTO systemDTO){

        //获取导入模板配置
        CbImpSetDTO cbImpSetDTO = cbImpSetService.findBySystem(systemDTO);
        //缓存文件信息
        Map<String,List<OSSObject>> fileList = packFileList(OssList);
        //按照导入模板封装参数
        List<FileImpParam> params = packParamByImpSet(cbImpSetDTO, fileList);
        return params;
    }

    /**
     * 缓存 文件类型(key) : 文件集合(value)
     * @param ossList
     * @return
     */
    private Map<String,List<OSSObject>> packFileList(List<OSSObject> ossList) {
        Map<String,List<OSSObject>> map = new HashMap<>();
        for(OSSObject ossObject: ossList){
            String key = fileNameSubstr(ossObject.getKey());
            if(StringUtils.isBlank(key)){
                continue;
            }
            if(map.containsKey(key)){
                map.get(key).add((ossObject));
            } else {
                List<OSSObject> ossObjects = new ArrayList();
                ossObjects.add(ossObject);
                map.put(key, ossObjects);
            }

        }
        return map;
    }

    /**
     * 按照导入模板封装参数
     * @param cbImpSetDTO
     */
    private List<FileImpParam> packParamByImpSet(CbImpSetDTO cbImpSetDTO, Map<String,List<OSSObject>> fileMap) {
        List<FileImpParam> params = new ArrayList<>();
        //模板设置明细
        List<CbImpDetailDTO> detailDTOS = cbImpSetDTO.getDetailList();
        if(null == detailDTOS || detailDTOS.isEmpty()){
            throw new BaseException("未找到来源系统" + cbImpSetDTO.getPkSystem().getSystemName() + "的导入模板配置信息,请检查!");
        }
        Map<Integer,String> impMap = CbImpType.cacheType();
        for(CbImpDetailDTO detailDTO : detailDTOS){
            FileImpParam param = FileImpParam.initInstance();
            param.setBusinessType(impMap.get(detailDTO.getImpType()));
            param.setBeanName(detailDTO.getBeanName());
            param.setImpType(detailDTO.getImpType());
            param.setOrder(detailDTO.getImpOrder());
            param.setSystemVO(cbImpSetDTO.getPkSystem());
            //处理文件相关
            param.setFileList(fileMap.get(impMap.get(detailDTO.getImpType())));
            params.add(param);
        }
        return params;
    }

    /**
     * 反射接口方法,导入文件,文件转换为业务对象并持久化到数据库中
     * @param fileImpParams
     * @return
     */
    List<FileOssLogDTO> filePersist(List<FileImpParam> fileImpParams){
        List<FileOssLogDTO> logDTOS = new ArrayList<>();
        Map<Integer,String> busyTypeMap = CbImpType.cacheBusiType();
        for(FileImpParam fileImpParam : fileImpParams){
            String beanName = fileImpParam.getBeanName();
            String busiType = busyTypeMap.get(fileImpParam.getImpType());
            CbFileImpService cbFileImpService = (CbFileImpService)SpringUtils.getBean(beanName);
            for(OSSObject ossObject : fileImpParam.getFileList()){
                FileOssLogDTO logDTO = cbFileImpService.dataImp(ossObject);
                if(logDTO.getFlag()){
                    logDTO.setLogMsg("业务类型" + busiType + ",导入文件名称为" + ossObject.getKey() + "文件导入成功!");
                }
                logDTOS.add(logDTO);
            }
        }
        return logDTOS;
    }

    /**
     * 根据OSS上文件名规则 得到业务类型
     * 命名规则为：yyyymmdd-业务类型-批次号
     * @param key
     * @return
     */
    private String fileNameSubstr(String key){
        String index = key.substring(key.indexOf("/") + 1);
        if(index.indexOf("-") < 0 || index.indexOf("-",index.indexOf("-") + 1) < 0){
            return "";
        }
        return index.substring(index.indexOf("-") + 1, index.indexOf("-",index.indexOf("-") + 1));
    }
}
