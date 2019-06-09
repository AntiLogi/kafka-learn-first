package com.ayyovei.kafka.learn.consume;

import com.ayyovei.kafka.learn.entity.Message;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/6/8
 */
@Component
public class MsgConsumer {
    private Gson gson = new Gson();

    @KafkaListener(topics = {"test"})
    public void processMessage(String content) {
        Message m = gson.fromJson(content, Message.class);
        System.out.println("test1--消费消息:" + m.getMessage());
    }

//    @KafkaListener(topics = {"test2"})
//    public void processMessage2(String content) {
//        Message m = gson.fromJson(content, Message.class);
//        System.out.println("test2--消费消息:" + m.getMsg());
//    }

}
