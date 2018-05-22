package com.xp.exe.cacheDemo.interfaces;

import com.xp.exe.cacheDemo.model.Employee;

/**
 * Author:coderXp
 * Description: 员工类接口(规范增删改查)
 * Date:Create in 2018/3/12 18:15
 * Modified By:
 */
public interface IEmployeeOptional {
    /**
     * 新增员工信息
     * @param employee 员工信息
     * @return 操作结果
     */
    public String addEmployee(Employee employee);

    /**
     * 根据员工ID获取员工信息
     * @param id 员工id
     * @return 员工信息
     */
    public String getEmployee(Long id);

    /**
     * 根据员工ID删除员工信息
     * @param id 员工id
     * @return 操作结果
     */
    public String delEmployee(Long id);

    /**
     * 根据员工名修改员工信息
     * @param newEmployee 新的员工信息
     * @return 操作结果
     */
    public String modifyEmployee(Employee newEmployee);
}
