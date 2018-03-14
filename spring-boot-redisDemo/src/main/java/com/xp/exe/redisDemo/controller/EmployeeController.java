package com.xp.exe.redisDemo.controller;

import com.xp.exe.redisDemo.interfaces.IEmployeeOptional;
import com.xp.exe.redisDemo.mapper.EmployeeMapper;
import com.xp.exe.redisDemo.model.Employee;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/12 18:15
 * Modified By:
 */
@RestController
public class EmployeeController implements IEmployeeOptional {
    @Resource    //spring boot官方说明,redisTemplate必须得使用byName注入才行
    private RedisTemplate<Long , Employee> redisTemplate;
    //另一种操作redis String的方法
    private StringRedisTemplate stringRedisTemplate;

    private EmployeeMapper employeeMapper;
    public EmployeeController(EmployeeMapper employeeMapper,StringRedisTemplate stringRedisTemplate){
        this.employeeMapper=employeeMapper;
        this.stringRedisTemplate=stringRedisTemplate;
    }
    @Override
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        //增加一个用户,同时更新缓存
        employee.setId(System.currentTimeMillis());
        int addCount=employeeMapper.addEmployee(employee);
        String msg;
        if(addCount>0){
            msg="更新成功!";
            //将数据保存到Redis中缓存起来
            redisTemplate.opsForValue().set(employee.getId(),employee);
        }else{
            msg="更新失败!";
        }
        return msg;
    }

    @Override
    @RequestMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        String msg;
        //先从缓存中拿,拿不了再从数据库拿
        Employee redisTemplateEmployee=redisTemplate.opsForValue().get(id);
        if(null==redisTemplateEmployee){
            //去数据库查,并将查询结果放入redis
            redisTemplateEmployee=employeeMapper.getEmployee(id);
            msg="从数据库中拿到了员工信息: ";
            redisTemplate.opsForValue().set(redisTemplateEmployee.getId(),redisTemplateEmployee);
        }else{
            msg="从缓存中拿到了员工信息: ";
        }
        return msg+redisTemplateEmployee.toString();
    }

    @Override
    @RequestMapping("/delEmployee/{id}")
    public String delEmployee(@PathVariable("id") Long id) {
        int delRowCount=employeeMapper.delEmployee(id);
        String msg;
        if(delRowCount>0){
            msg="数据库删除数据成功!";
            //删除缓存中该员工的数据
            redisTemplate.opsForValue().getOperations().delete(id);
        }else {
            msg="数据库删除数据失败!";
        }
        return msg;
    }

    @Override
    @RequestMapping("/modifyEmployee")
    public String modifyEmployee(Employee newEmployee) {
        Employee oldEmployee=employeeMapper.getEmployeeByName(newEmployee.getName());
        if(null==oldEmployee){
            return "更新失败,用户不存在";
        }
        newEmployee.setId(oldEmployee.getId());
        int modifyCount=employeeMapper.modifyEmployee(newEmployee);
        String msg;
        if (modifyCount>0) {
            //更新缓存
            redisTemplate.opsForValue().getAndSet(newEmployee.getId(),newEmployee);
            msg="更新成功!";
        }else{
            msg="更新失败!";
        }
        return msg;
    }
}
