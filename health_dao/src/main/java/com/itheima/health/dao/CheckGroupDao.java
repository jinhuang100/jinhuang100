package com.itheima.health.dao;

import com.itheima.health.pojo.CheckGroup;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/21 22:08
 */
public interface CheckGroupDao {
    List<CheckGroup> findAll();
}
