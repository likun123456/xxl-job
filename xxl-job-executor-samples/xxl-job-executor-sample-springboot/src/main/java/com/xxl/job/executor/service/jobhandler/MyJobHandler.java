package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.executor.user.entity.User;
import com.xxl.job.executor.user.service.IUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date 2022/3/30 11:28
 * @Created by likun
 */
@Component
public class MyJobHandler {

    @Resource
    private IUserService userService;

    @XxlJob("createUserJobHandler")
    public String createUserJobHandler() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        System.out.println("执行定时任务时间:" + now);
        User user = new User();
        user.setName("bruce");
        user.setAge((int) Math.round((Math.random() * 1000)) % 40);
        user.setGender((int) Math.round((Math.random() * 1000)) % 2);
        return userService.createUser(user);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.round((Math.random() * 1000)) % 2);
        }
    }
}
