package com.xp.exe.mybatisdemo.interfaces;

import com.xp.exe.mybatisdemo.model.Job;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 17:13
 * Modified By:
 */
public interface IJobOptional {
    /**
     * 新增职位
     * @param job 职位信息
     * @return 新增结果
     */
    public String addJob(Job job);

    /**
     * 查询职位信息
     * @param id    职位id
     * @return  查询到的职位信息
     */
    public String getJob(Long id);

    /**
     * 删除职位
     * @param id 职位id
     * @return 删除结果
     */
    public String delJob(Long id);
}
