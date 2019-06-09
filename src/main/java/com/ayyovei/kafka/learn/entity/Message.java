package com.ayyovei.kafka.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.rmi.runtime.Log;

import java.util.Date;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/6/8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private long id;
    private String message;
    private Date sendTime;


}
