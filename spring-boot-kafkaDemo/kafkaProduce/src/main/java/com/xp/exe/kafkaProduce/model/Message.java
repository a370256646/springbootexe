package com.xp.exe.kafkaProduce.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Author:coderXp
 * Description: 消息实体类
 * Date:Create in 2018/3/15 18:17
 * Modified By:
 */
@Data
@Builder
public class Message {
    private long id;
    private String content;
    private Timestamp addTime;
}
