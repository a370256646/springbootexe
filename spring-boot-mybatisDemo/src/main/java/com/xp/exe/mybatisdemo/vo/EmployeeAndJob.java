package com.xp.exe.mybatisdemo.vo;

import lombok.Data;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 19:29
 * Modified By:
 */
@Data
public class EmployeeAndJob {
    private long id;
    private String name;
    private byte age;
    private long jobId;
    private String jobName;
    private String description;
}
