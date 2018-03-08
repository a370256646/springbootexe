package com.xp.exe.mybatisdemo.controller;

import com.xp.exe.mybatisdemo.interfaces.IEmployeeOptional;
import com.xp.exe.mybatisdemo.mapper.EmployeeMapper;
import com.xp.exe.mybatisdemo.model.Employee;
import com.xp.exe.mybatisdemo.vo.EmployeeAndJob;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 17:20
 * Modified By:
 */
@RestController
public class EmployeeController implements IEmployeeOptional {
    private EmployeeMapper employeeMapper;
    public EmployeeController(EmployeeMapper employeeMapper){
        this.employeeMapper=employeeMapper;
    }

    @Override
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        employee.setId(System.currentTimeMillis());
        return String.valueOf(employeeMapper.addEmployee(employee));
    }

    @Override
    @RequestMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        return employeeMapper.getEmployeeById(id).toString();
    }

    @Override
    @RequestMapping("/delEmployee/{id}")
    public String delEmployee(@PathVariable("id") Long id) {
        return String.valueOf(employeeMapper.delEmployee(id));
    }

    @Override
    @RequestMapping("/modifyEmployee")
    public String modifyEmployee(Employee newEmployee) {
        Employee oldEmployee=employeeMapper.getEMployeeByName(newEmployee.getName());
        if(null==oldEmployee){
            return "用户不存在";
        }
        newEmployee.setId(oldEmployee.getId());
        return String.valueOf(employeeMapper.modifyEmployee(newEmployee));
    }

    @Override
    @RequestMapping("/getEmployeesByJobName")
    public List<EmployeeAndJob> getEmployeesByJobName(String jobName, int pageSize, int curPage) {
        int startNum=pageSize*(curPage-1);
        int endNum=pageSize;
        return employeeMapper.getEmployeeAndJobByJobName(jobName,startNum,endNum);
    }
}
