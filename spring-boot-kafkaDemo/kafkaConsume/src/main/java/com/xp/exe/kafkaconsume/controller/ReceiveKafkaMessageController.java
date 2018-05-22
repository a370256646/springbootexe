package com.xp.exe.kafkaconsume.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.xp.exe.kafkaProduce.model.Message;
import com.xp.exe.kafkaconsume.mapper.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description: 用来从kafka server接收消息并存入数据库
 * Date:Create in 2018/3/15 18:31
 * Modified By:
 */
@Slf4j
@RestController
public class ReceiveKafkaMessageController {
    /**
     * message do操作对象
     */
    private MessageMapper messageMapper;

    /**
     * 转换json的jackson对象
     */
    private ObjectMapper objectMapper;

    /**
     * 转换json的Gson对象
     */
    private Gson gson;

    public ReceiveKafkaMessageController(MessageMapper messageMapper,
                                         ObjectMapper objectMapper,
                                         Gson gson){
        this.messageMapper=messageMapper;
        this.objectMapper=objectMapper;
        this.gson=gson;
    }

    /**
     * 从kafka server订阅和接收消息
     * 通过@KafkaListener注解来订阅myTopic消息
     * @param consumerRecord 消息载体,包括topic,key和value
     */
    @KafkaListener(topics = {"myTopic"})
    public void saveKafkaMessage(ConsumerRecord consumerRecord){
        log.debug("接收到的消息主题为:"+consumerRecord.topic()+" ,消息key为:"+consumerRecord.key()+
                " ,消息值为: " + consumerRecord.value());
        //将数据处理一下并插入数据库
        String messageInfo= (String) consumerRecord.value();
        Message message=null;
        try {
           // message = objectMapper.readValue(messageInfo, Message.class);
            message=gson.fromJson(messageInfo , Message.class);
        }catch (Exception e) {
            log.error(" json转object时出错  :" , e);
        }
        message.setContent(message.getContent()+" ,consumer收到的时间戳是"+ System.currentTimeMillis());
        messageMapper.saveMessage(message);
    }
}
