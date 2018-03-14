package com.xp.exe.redisDemo.interfaces;

import com.xp.exe.redisDemo.model.Employee;

/**
 * Author:coderXp
 * Description: 员工类增删改查
 * Date:Create in 2018/3/12 18:15
 * Modified By:
 */
public interface IEmployeeOptional {
    public String addEmployee(Employee employee);

    public String getEmployee(Long id);

    public String delEmployee(Long id);

    public String modifyEmployee(Employee newEmployee);
}
