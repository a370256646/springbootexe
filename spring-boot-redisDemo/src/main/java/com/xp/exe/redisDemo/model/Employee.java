package com.xp.exe.redisDemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Author:coderXp
 * Description:   员工实体类    因为使用到了RedisTemplate所以必须要求实现序列化
 * Date:Create in 2018/3/12 16:15
 * Modified By:
 */
@Data
public class Employee implements Serializable{
    private long id;
    private String name;
    private Byte age;
    private Long jobId;
}
