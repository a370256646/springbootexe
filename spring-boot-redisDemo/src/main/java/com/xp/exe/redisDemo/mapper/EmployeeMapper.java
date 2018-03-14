package com.xp.exe.redisDemo.mapper;

import com.xp.exe.redisDemo.model.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/12 18:20
 * Modified By:
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee e where e.id=#{id}")
    Employee getEmployee(Long id);

    @Insert("insert into employee e values(#{id},#{name},#{age},#{jobId})")
    int addEmployee(Employee employee);

    @Delete("delete from employee e where e.id=#{id}")
    int delEmployee(Long id);

    @Select("select * from employee e where e.name=#{name}")
    Employee getEmployeeByName(String name);

    @Update("update employee e set e.age=#{age},e.jobId=#{jobId} where e.id=#{id}")
    int modifyEmployee(Employee newEmployee);
}
