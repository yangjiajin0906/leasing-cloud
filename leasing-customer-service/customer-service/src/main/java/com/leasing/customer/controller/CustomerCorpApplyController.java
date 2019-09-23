package com.leasing.customer.controller;

import com.leasing.common_service.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单位客户申请基本信息表
 *
 * @Author ZHANG_CLAY
 * @Date Sep 2, 2019
 * @Description 单位客户申请基本信息表
 */
@RequestMapping("/customerCorpApply")
@RestController
public class CustomerCorpApplyController {
//
//    @Resource
//    private CustomerService customerService;

    /**
     * 查询列表
     *
     * @param data 查询条件
     */
    @PostMapping(value = "/list")
    public Result list(@RequestParam(value = "data") String data) {
        Result result = new Result();

        List<Map<String, Object>> tempList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("customer_code", "0" + (i+ 1));
            map.put("customer_name", "黑山XXX");
            map.put("dr", "0");
            map.put("memo", "测试数据");
            map.put("ts", "2019-08-28 14:00:00");
            tempList.add(map);
        }
        result.setData(tempList);
        return result;

    }

    /**
     * 保存（新增与修改）
     *
     * @param data 待保存的数据
     */

    @PostMapping(value = "/saveOrUpdate")
    public Result saveOrUpdate(@RequestParam(value = "data") String data) {

        Result result = new Result();
        result.setData("1111");
        return result;
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        Result result = new Result(true);

        return result;
    }

    /**
     * 根据主键查看详情
     *
     * @param id 主键
     */
    @GetMapping(value = "/findOne")
    public Result findOne(@RequestParam(value = "id") String id) {
        Result result = new Result(true);

        return result;
    }
}
