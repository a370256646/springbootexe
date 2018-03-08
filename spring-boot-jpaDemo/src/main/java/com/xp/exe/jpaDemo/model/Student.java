package com.xp.exe.jpaDemo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Author:coderXp
 * Description: 学生对象实体类
 * Date:Create in 2018/3/8 9:58
 * Modified By:
 */
@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name = "stu_no")
    private long stuNo;
    @Basic
    @Column(name = "stu_name")
    private String stuName;
    @Basic
    @Column(name = "stu_age")
    private Byte stuAge;
    @Basic
    @Column(name = "stu_province")
    private String stuProvince;
    @Basic
    @Column(name = "class_id")
    private long classId;
}
