package com.xxl.job.executor.user.service;

import com.xxl.job.executor.user.entity.User;
import com.xxl.job.executor.user.vo.UserVO;

/**
 * @Date 2022/3/30 14:36
 * @Created by likun
 */
public interface IUserService{
    String createUser(User user);

    UserVO getUserById(String id);
}
