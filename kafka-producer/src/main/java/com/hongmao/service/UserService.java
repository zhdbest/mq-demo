package com.hongmao.service;

import com.hongmao.model.UserDTO;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/14 20:11
 */
public interface UserService {

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    UserDTO findById(Long id);
}
