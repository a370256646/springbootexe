package com.xp.exe.mybatisdemo.interfaces;

import com.xp.exe.mybatisdemo.model.Employee;
import com.xp.exe.mybatisdemo.vo.EmployeeAndJob;

import java.util.List;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 17:13
 * Modified By:
 */
public interface IEmployeeOptional {
    /**
     * 新增员工
     * @param employee 员工信息
     * @return 新增结果
     */
    public String addEmployee(Employee employee);

    /**
     * 查询员工信息
     * @param id    员工id
     * @return  查询到的员工信息
     */
    public String getEmployee(Long id);

    /**
     * 删除员工
     * @param id 员工id
     * @return 删除结果
     */
    public String delEmployee(Long id);

    /**
     * 修改员工信息
     * @param newEmployee 新的员工信息
     * @return  修改结果
     */
    public String modifyEmployee(Employee newEmployee);

    /**
     * 根据职位姓名查询员工信息(分页)
     * @param jobName   职位姓名
     * @param pageSize  每一页展示数量
     * @param curPage   当前页
     * @return  分页查询到的数据
     */
    public List<EmployeeAndJob> getEmployeesByJobName(String jobName, int pageSize, int curPage);
}
