package com.hongmao.controller;

import com.hongmao.model.UserDTO;
import com.hongmao.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 新增用户
     * @param userDTO 用户信息
     * @return 新增的信息
     */
    @PostMapping("insert")
    public UserDTO insert(@RequestBody UserDTO userDTO) {
        return userService.insert(userDTO);
    }
}
