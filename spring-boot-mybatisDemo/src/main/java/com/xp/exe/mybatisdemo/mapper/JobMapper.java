package com.xp.exe.mybatisdemo.mapper;

import com.xp.exe.mybatisdemo.model.Job;
import org.apache.ibatis.annotations.*;

/**
 * Author:coderXp
 * Description: 职位sql mapper
 * Date:Create in 2018/3/8 17:12
 * Modified By:
 */
@Mapper
public interface JobMapper {
    @Insert("insert into job values (#{id},#{name},#{description})")
    int addJob(Job job);

    @Select("select * from job where id=#{id} ")
    Job getJob(Long id);

    @Delete("delete from job where id=#{id}")
    int delJob(Long id);
}
