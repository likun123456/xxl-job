package com.xxl.job.executor.user.controller;

import com.xxl.job.executor.common.ResultJson;
import com.xxl.job.executor.user.service.IUserService;
import com.xxl.job.executor.user.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/1 13:44
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/get/{id}")
    private ResultJson<UserVO> getUserById(@PathVariable("id") String id) {
        UserVO user = userService.getUserById(id);
        return ResultJson.success(user);
    }
}
