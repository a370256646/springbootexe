package com.xp.exe.jpaDemo.interfaces;

import com.xp.exe.jpaDemo.model.ClassInfo;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 14:23
 * Modified By:
 */
public interface IClassInfoOptional {
    /**
     * 增加班级信息
     * @param classInfo 班级信息
     * @return  增加结果
     */
    public String addClassInfo(ClassInfo classInfo);

    /**
     * 删除班级信息
     * @param classId 班级id
     * @return 删除结果
     */
    public String delClassInfo(Long classId);

    /**
     * 查询班级信息
     * @param classId 班级id
     * @return 查询结果
     */
    public String getClassInfo(Long classId);
}
