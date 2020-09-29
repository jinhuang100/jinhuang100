package com.itheima.health.service;

import com.itheima.health.pojo.Setmeal;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/22 20:14
 */
public interface SetmealService {
    List<String> findImgs();

//    查询所有套餐
    List<Setmeal> findAll();

    Setmeal findById(int id);

    Setmeal findDetailById3(int id);
}
