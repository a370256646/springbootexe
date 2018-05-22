package com.xp.exe.cacheDemo.controller;

import com.xp.exe.cacheDemo.interfaces.IEmployeeOptional;
import com.xp.exe.cacheDemo.mapper.EmployeeMapper;
import com.xp.exe.cacheDemo.model.Employee;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author:coderXp
 * Description: 员工操作类
 * Date:Create in 2018/3/8 17:20
 * Modified By:
 */
@RestController
@CacheConfig(cacheNames = "myRedisCache")
public class EmployeeController implements IEmployeeOptional {
    /**
     * spring boot官方说明,redisTemplate必须得使用byName注入才行
     */
    @Resource
    private RedisTemplate<Long , Employee> redisTemplate;

    /**
     * 另一种操作redis String的方法
     */
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 员工do操作类
     */
    private EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeMapper employeeMapper,StringRedisTemplate stringRedisTemplate){
        this.employeeMapper=employeeMapper;
        this.stringRedisTemplate=stringRedisTemplate;
    }

    @Override
    @RequestMapping("/addEmployee")
    @CachePut(key = "\"employee_\"+#employee.id")           //将数据按照指定key格式放入缓存
    public String addEmployee(Employee employee) {
        employee.setId(System.currentTimeMillis());
        employeeMapper.addEmployee(employee);
        return employee.toString();
    }

    @Override
    @RequestMapping("/getEmployee/{id}")
    @Cacheable(key = "\"employee_\"+#id")
    public String getEmployee(@PathVariable("id") Long id) {
        Employee employee=employeeMapper.getEmployee(id);
        return employee==null?"":employee.toString();
    }

    @Override
    @RequestMapping("/delEmployee/{id}")
    @CacheEvict(key = "\"employee_\"+#id")     //从缓存中删除指定key的数据
    public String delEmployee(@PathVariable("id") Long id) {
        return String.valueOf(employeeMapper.delEmployee(id));
    }

    @Override
    @RequestMapping("/modifyEmployee")
    @CachePut(key = "\"employee_\"+#newEmployee.id")           //放入缓存
    public String modifyEmployee(Employee newEmployee) {
        Employee oldEmployee=employeeMapper.getEmployeeByName(newEmployee.getName());
        if(null==oldEmployee){
            return "更新失败,用户不存在";
        }
        newEmployee.setId(oldEmployee.getId());
        employeeMapper.modifyEmployee(newEmployee);
        return newEmployee.toString();
    }
}
