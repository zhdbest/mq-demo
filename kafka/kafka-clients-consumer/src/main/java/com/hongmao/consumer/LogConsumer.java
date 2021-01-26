package com.hongmao.consumer;

import com.google.common.collect.Lists;
import com.hongmao.constant.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2021/1/25 10:26 下午
 */
@Slf4j
public class LogConsumer {

    private static List<String> list = Lists.newArrayList();

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "log-group");
        properties.put("key.deserializer", StringDeserializer.class);
        properties.put("value.deserializer", StringDeserializer.class);
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Lists.newArrayList(KafkaTopic.KAFKA_TOPIC_TEST_LOG.name()));

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(5));
            if (records == null) {
                continue;
            }
            for (ConsumerRecord<String, String> record : records) {
                log.info(record.value());
                list.add(record.value());
            }
        }
    }
}
