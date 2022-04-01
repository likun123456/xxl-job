package com.xxl.job.executor.user.dao;

import com.xxl.job.executor.user.entity.User;
import com.xxl.job.executor.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Date 2022/3/30 14:39
 * @Created by likun
 */
@Mapper
public interface UserDao {

    void createUser(@Param("user")User user);

    UserVO getUserById(@Param("id") String id);
}
