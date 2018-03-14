package com.xp.exe.mybatisdemo.mapper;

import com.xp.exe.mybatisdemo.model.Employee;
import com.xp.exe.mybatisdemo.vo.EmployeeAndJob;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author:coderXp
 * Description: 员工do操作对象
 * Date:Create in 2018/3/8 17:11
 * Modified By:
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id= #{id}")
    Employee getEmployeeById(Long id);

    @Select("select * from employee where name=#{name}")
    Employee getEmployeeByName(String name);

    @Insert("insert into employee values(#{id},#{name}," +
            "#{age},#{jobId})")
    int addEmployee(Employee employee);

    @Delete("delete from employee e where e.id=#{id}")
    int delEmployee(Long id);

    @Update("update employee e set e.name=#{name} , e.age=#{age} , e.jobId=#{jobId}" +
            "where e.name=#{name}")
    int modifyEmployee(Employee newEmployee);

    @Select("select e.id,e.name,e.age,e.jobId,j.name,j.description from employee e , job j " +
            "where e.jobId = j.id " +
            "and j.name=#{jobName} " +
            "limit #{startNum},#{endNum}")
    List<EmployeeAndJob> getEmployeeAndJobByJobName(@Param("jobName") String jobName,
                             @Param("startNum") int startNum, @Param("endNum") int endNum);
}
