package com.hongmao.admin;

import com.google.common.collect.Lists;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2021/2/19 7:39 下午
 */
public class AdminClientTest {

    private AdminClient adminClient() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return AdminClient.create(properties);
    }

    /**
     * 创建Topic
     * @throws Exception 可能抛出Exception
     */
    @Test
    public void createTopics() throws Exception {
        List<NewTopic> topicList = Lists.newArrayList();
        NewTopic newTopic = new NewTopic("Test3", 1, (short) 1);
        topicList.add(newTopic);
        CreateTopicsResult result = adminClient().createTopics(topicList);
        // 如果只有上面的代码 不会创建成功
        result.all().get();
    }

    /**
     * 获取Topic
     * @throws Exception 可能抛出Exception
     */
    @Test
    public void listTopics() throws Exception {
        ListTopicsResult result = adminClient().listTopics();
        System.out.println(result.names().get());
    }

    /**
     * 删除Topic
     * @throws Exception 可能抛出Exception
     */
    @Test
    public void deleteTopics() throws Exception {
        DeleteTopicsResult result = adminClient().deleteTopics(Lists.newArrayList("Test3"));
        result.all().get();
    }

    /**
     * 获取Topic详细信息
     * @throws Exception 可能抛出Exception
     */
    @Test
    public void describeTopics() throws Exception {
        DescribeTopicsResult result = adminClient().describeTopics(Lists.newArrayList("myTest"));
        System.out.println(result.values().get("myTest").get());
    }

    /**
     * 获取Topic详细信息
     * @throws Exception 可能抛出Exception
     */
    @Test
    public void describeCluster() throws Exception {
        DescribeClusterResult result = adminClient().describeCluster();
        System.out.println("clusterId : " + result.clusterId().get());
        System.out.println("controller : " + result.controller().get());
        System.out.println("nodes : " + result.nodes().get());
    }
}
