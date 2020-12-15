package com.hongmao.service.impl;

import com.alibaba.fastjson.JSON;
import com.hongmao.constant.KafkaTopic;
import com.hongmao.model.UserDTO;
import com.hongmao.service.UserService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/14 20:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public UserDTO insert(UserDTO userDTO) {
        // 发送消息
        kafkaTemplate.send(KafkaTopic.KAFKA_TOPIC_USER.name(), JSON.toJSONString(userDTO));
        return userDTO;
    }
}
