package com.xp.exe.jpaDemo.interfaces;

import com.xp.exe.jpaDemo.model.Student;
import com.xp.exe.jpaDemo.vo.StudentClassVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author:coderXp
 * Description: 学生操作接口,规范学生类的行为
 * Date:Create in 2018/3/8 10:03
 * Modified By:
 */
public interface IStudentOptional {
    /**
     * 增加学生信息
     * @param student 学生信息
     * @return 增加操作结果
     */
    public String addStudent(Student student);

    /**
     * 查询学生细信息
     * @param id 学生id
     * @return  学生信息(json)
     */
    public String getStudent(long id);

    /**
     * 修改学生信息
     * @param student 新的学生信息
     * @return 操作结果
     */
    public String modifyStudent(Student student);

    /**
     * 删除学生信息
     * @param id 学生id
     * @return 操作结果
     */
    public String delStudent(long id);

    /**
     * 获取所有学生信息
     * @return
     */
    public List<Student> getAllStudents();

    /**
     * 获取指定班级下的学生信息
     * @param classId 班级id
     * @param pageable   分页对象(默认)
     * @return  分页后的某一班的学生信息
     */
    public List<Student> getStudentByClassId(Long classId,Pageable pageable);

    /**
     * 根据班级名称查询班级和学生信息(复杂操作)
     * @param className 班级名称
     * @param pageable   分页对象(默认)
     * @return  分页后的班级和小学生信息vo
     */
    public List<StudentClassVo> getStudentClassVoByClassName(String className,Pageable pageable);
}
