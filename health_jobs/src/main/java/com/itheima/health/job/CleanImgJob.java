package com.itheima.health.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.service.SetmealService;
import com.itheima.health.util.QiNiuUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/22 20:09
 */
@Component
public class CleanImgJob {
    @Reference
    private SetmealService setmealService;

//    @Scheduled(initialDelay = 1000,fixedDelay = 3000)
    public void CleanImg() {
//        查出所有7牛云上的图片
        List<String> imgIn7Niu = QiNiuUtils.listFile();
//        查出数据库所有图片
        List<String>imgInDb=setmealService.findImgs();

//        7牛云-数据库,剩下的就定义为垃圾图片
        imgIn7Niu.removeAll(imgInDb);
//        把剩下的图片转成数组
        String[] strings = imgIn7Niu.toArray(new String[]{});
//        删除7牛云上的垃圾图片
        List<String> list = QiNiuUtils.removeFiles(strings);

    }

}
