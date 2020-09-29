package com.itheima.health.service;

import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/18 22:14
 */
public interface CheckItemService {
    List<CheckItem> findAll();

    void add(CheckItem checkItem);
}
