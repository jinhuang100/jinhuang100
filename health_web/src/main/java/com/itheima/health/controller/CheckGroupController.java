package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckGroupService;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/18 22:06
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;



    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> list=checkGroupService.findAll();

        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);

    }

}
