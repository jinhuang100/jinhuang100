package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckGroupService;
import com.itheima.health.service.CheckItemService;
import com.itheima.health.util.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/18 22:06
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckGroupService checkGroupService;



    @Reference
   private CheckItemService checkItemService;


    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckItem>list=checkItemService.findAll();

        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);

    }
    @PostMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){

//        调用服务添加
        checkItemService.add(checkItem);
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }



}
