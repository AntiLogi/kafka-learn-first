package com.ayyovei.kafka.learn.product;

import com.ayyovei.kafka.learn.entity.Message;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/6/8
 */
@Component
public class MsgProduct {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new Gson();
    /**
     * 发送向一个主题为test的队列发送消息
     * @throws InterruptedException
     */
    public void sendMessage() throws InterruptedException, ExecutionException {
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMessage(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        System.out.println("1生产了" + m.getMessage());
        Thread.sleep(1000);
        kafkaTemplate.send("test", gson.toJson(m));
        Future future = kafkaTemplate.send("test", gson.toJson(m));
        future.get();
    }
}
