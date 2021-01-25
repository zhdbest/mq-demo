package com.hongmao.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hongmao.model.UserDTO;
import com.hongmao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/15 19:15
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, UserDTO> userMap = Maps.newConcurrentMap();

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public UserDTO findById(Long id) {
        return userMap.get(id);
    }

    @KafkaListener(topics = "KAFKA_TOPIC_USER", groupId = "user-group")
    public void consumer(ConsumerRecord<String, String> consumerRecord) {
        String message = consumerRecord.value();
        if (StringUtils.isBlank(message)) {
            return;
        }
        UserDTO userDTO = JSON.parseObject(message, UserDTO.class);
        if (userDTO == null || userDTO.getId() == null) {
            return;
        }
        log.info(message);
        userMap.put(userDTO.getId(), userDTO);
    }
}
