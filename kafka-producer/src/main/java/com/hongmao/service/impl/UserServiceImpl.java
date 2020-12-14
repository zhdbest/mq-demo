package com.hongmao.service.impl;

import com.hongmao.model.UserDTO;
import com.hongmao.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/14 20:12
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public UserDTO findById(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(101L);
        userDTO.setUsername("hongmao");
        return userDTO;
    }
}
