package com.xp.exe.jpaDemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:coderXp
 * Description: 学生和班级的复合vo类
 * Date:Create in 2018/3/8 10:57
 * Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClassVo {
    private long stuNo;
    private String stuName;
    private Byte stuAge;
    private String stuProvince;
    private long classId;
    private String className;
}
