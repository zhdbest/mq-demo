package com.hongmao.controller;

import com.hongmao.model.UserDTO;
import com.hongmao.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/14 20:06
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping("{id}")
    public UserDTO user(@PathVariable Long id) {
        return userService.findById(id);
    }
}
