package com.itheima.health.dao;

import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/18 22:21
 */
public interface CheckItemDao {
    List<CheckItem> findAll();

    void add(CheckItem checkItem);
}
