package com.itheima.health.dao;

import com.itheima.health.pojo.Setmeal;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/22 20:21
 */
public interface SetmealDao {
    List<String> findImgs();

    List<Setmeal> findAll();

    Setmeal findById(int id);

    Setmeal findDetailById3(int id);
}
