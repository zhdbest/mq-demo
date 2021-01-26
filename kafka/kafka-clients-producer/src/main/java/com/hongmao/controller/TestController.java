package com.hongmao.controller;

import com.hongmao.constant.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2021/1/25 7:37 下午
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    KafkaProducer<String, String> kafkaProducer;

    @GetMapping("get")
    public void get() {
        ProducerRecord<String, String> record = new ProducerRecord<>(KafkaTopic.KAFKA_TOPIC_TEST_LOG.name(), "调用时间：" + LocalDateTime.now());
        kafkaProducer.send(record);
    }
}
