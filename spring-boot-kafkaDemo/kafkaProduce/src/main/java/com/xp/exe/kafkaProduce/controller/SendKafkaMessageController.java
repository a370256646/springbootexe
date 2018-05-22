package com.xp.exe.kafkaProduce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.xp.exe.kafkaProduce.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description: 用来发送kafka消息到kafka server
 * Date:Create in 2018/3/15 18:23
 * Modified By:
 */
@RestController
@Slf4j
public class SendKafkaMessageController {
    /**
     * kafka操作对象
     */
    private KafkaTemplate kafkaTemplate;

    /**
     * 转换json的jackson对象
     */
    private ObjectMapper objectMapper;

    /**
     * 转换json的Gson对象
     */
    private Gson gson;

    public SendKafkaMessageController(KafkaTemplate kafkaTemplate,
                                      ObjectMapper objectMapper,
                                      Gson gson){
        this.kafkaTemplate=kafkaTemplate;
        this.objectMapper=objectMapper;
        this.gson=gson;
    }

    @RequestMapping("/sendMessage")
    public String sendKafkaMessage(){
        //往kafka server发送消息
        Message message=Message.builder()
                .id(System.currentTimeMillis())
                .content("producer发送消息的时间戳是:"+ System.currentTimeMillis())
                .build();
        String messageInfo=null;
        try {
            messageInfo = gson.toJson(message);
        }catch (Exception e){
            log.error(" message转json时出错 : "  , e);
        }
        kafkaTemplate.send("myTopic","message", messageInfo);
        return "发送成功!";
    }
}
