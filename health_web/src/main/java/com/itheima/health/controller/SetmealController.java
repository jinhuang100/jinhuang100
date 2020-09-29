package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import com.itheima.health.util.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: liujinhuang
 * @Date: 2020/9/18 22:06
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    private static final Logger log=LoggerFactory.getLogger(SetmealController.class);

    @PostMapping("/upload")
    public Result upload(MultipartFile imgFile){

//        获得原文件名
        String originalFilename = imgFile.getOriginalFilename();
//        截取原文件名来获取后缀名
        String extention = originalFilename.substring(originalFilename.lastIndexOf("."));
//        使用UUID生成唯一文件名+后缀名
        String uniqueName = UUID.randomUUID().toString()+extention;
//        调用QiNiuUtilh上传文件
        try {
            QiNiuUtils.uploadViaByte(imgFile.getBytes(),uniqueName);

 //        响应结果给页面

//         封装结果到map里
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("domain",QiNiuUtils.DOMAIN);
            resultMap.put("imgName",uniqueName);
            return new Result(true,MessageConstant.PIC_UPLOAD_SUCCESS,resultMap);

//         map有2个key,domain,imgName

        } catch (IOException e) {
           log.error("上传图片失败",e);
        }
        return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);


    }



    }

