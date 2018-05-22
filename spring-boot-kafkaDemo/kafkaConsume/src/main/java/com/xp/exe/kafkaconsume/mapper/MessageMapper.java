package com.xp.exe.kafkaconsume.mapper;

import com.xp.exe.kafkaProduce.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author:coderXp
 * Description: message do操作类
 * Date:Create in 2018/3/15 18:38
 * Modified By:
 */
@Mapper
public interface MessageMapper {
    @Insert("insert into message(id,content) values(#{id},#{content})")
    public int saveMessage(Message message);
}
