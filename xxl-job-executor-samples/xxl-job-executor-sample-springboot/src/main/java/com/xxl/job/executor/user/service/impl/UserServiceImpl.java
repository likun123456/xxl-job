package com.xxl.job.executor.user.service.impl;

import com.xxl.job.executor.user.dao.UserDao;
import com.xxl.job.executor.user.entity.User;
import com.xxl.job.executor.user.service.IUserService;
import com.xxl.job.executor.user.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date 2022/3/30 14:36
 * @Created by likun
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public String createUser(User user) {
        String uuid = User.genUuid();
        user.setUuid(uuid);
        userDao.createUser(user);
        return uuid;
    }

    @Override
    public UserVO getUserById(String id) {
        return userDao.getUserById(id);
    }
}
