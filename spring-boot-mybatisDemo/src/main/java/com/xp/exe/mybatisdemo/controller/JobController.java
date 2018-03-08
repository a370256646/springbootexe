package com.xp.exe.mybatisdemo.controller;

import com.xp.exe.mybatisdemo.interfaces.IJobOptional;
import com.xp.exe.mybatisdemo.mapper.JobMapper;
import com.xp.exe.mybatisdemo.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 17:36
 * Modified By:
 */
@RestController
public class JobController implements IJobOptional {
    private JobMapper jobMapper;
    public JobController(JobMapper jobMapper){
        this.jobMapper=jobMapper;
    }
    @Override
    @RequestMapping("/addJob")
    public String addJob(Job job) {
        job.setId(System.currentTimeMillis());
        return String.valueOf(jobMapper.addJob(job));
    }

    @Override
    @RequestMapping("/getJob/{id}")
    public String getJob(@PathVariable("id") Long id) {
        return jobMapper.getJob(id).toString();
    }

    @Override
    @RequestMapping("/delJob/{id}")
    public String delJob(@PathVariable("id") Long id) {
        return String.valueOf(jobMapper.delJob(id));
    }
}
