package com.hongmao.service;

import com.hongmao.model.UserDTO;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/14 20:11
 */
public interface UserService {

    /**
     * 新增用户
     * @param userDTO 用户信息
     * @return 新增的信息
     */
    UserDTO insert(UserDTO userDTO);
}
