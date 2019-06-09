package com.ayyovei.kafka.learn;

import com.ayyovei.kafka.learn.product.MsgProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaLearnApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext run = SpringApplication.run(KafkaLearnApplication.class, args);

        while (true) {
            MsgProduct sender = run.getBean(MsgProduct.class);
            sender.sendMessage();
//            sender.sendMessage2();
            Thread.sleep(200);
        }
    }

}
