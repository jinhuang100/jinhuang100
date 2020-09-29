package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.Setmeal;
import com.itheima.health.service.SetmealService;
import com.itheima.health.util.QiNiuUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/23 20:44
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealMobileController {

    @Reference
    private SetmealService setmealService;

    @GetMapping("/getSetmeal")
    public Result getSetmeal() {
//        查询所有的套餐
        List<Setmeal> list = setmealService.findAll();
        // 套餐里有图片有全路径吗? 拼接全路径
        list.forEach(s -> {
            s.setImg(QiNiuUtils.DOMAIN + s.getImg());
        });
//        返回给页面
        return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS, list);
    }

    @GetMapping("/findById")
    public Result findById(int id) {
//        调用服务查询套餐详情
        Setmeal setmeal = setmealService.findById(id);
//        设置图片完整路径
        setmeal.setImg(QiNiuUtils.DOMAIN+setmeal.getImg());
//        返回结果
        return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);
    }

//    查询套餐信息
    @GetMapping("/findDetailById3")
    public Result findDetailById3(int id){
        // 调用服务查询套餐详情
        Setmeal setmeal = setmealService.findDetailById3(id);
        // 设置图片完整路径
        setmeal.setImg(QiNiuUtils.DOMAIN + setmeal.getImg());
        // 返回
        return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);

    }
}
