package com.xp.exe.jpaDemo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Author:coderXp
 * Description: 班级实体类
 * Date:Create in 2018/3/8 11:00
 * Modified By:
 */
@Entity
@Table(name = "class_info")
@Data
public class ClassInfo {
    @Id
    @Column(name = "class_id")
    private long classId;
    @Basic
    @Column(name = "class_name")
    private String className;
}
