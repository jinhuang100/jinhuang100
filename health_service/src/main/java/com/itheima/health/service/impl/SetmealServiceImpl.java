package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.health.dao.SetmealDao;
import com.itheima.health.pojo.Setmeal;
import com.itheima.health.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/22 20:20
 */
@Service(interfaceClass = SetmealService.class)
public class SetmealServiceImpl implements SetmealService{
    @Autowired
    private SetmealDao setmealDao;
    @Override
    public List<String> findImgs() {
        return setmealDao.findImgs();
    }

    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }

    @Override
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }

    @Override
    public Setmeal findDetailById3(int id) {
        return setmealDao.findDetailById3(id);
    }
}
