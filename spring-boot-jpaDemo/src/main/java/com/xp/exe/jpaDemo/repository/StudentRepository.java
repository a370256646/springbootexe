package com.xp.exe.jpaDemo.repository;

import com.xp.exe.jpaDemo.model.Student;
import com.xp.exe.jpaDemo.vo.StudentClassVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 10:02
 * Modified By:
 */
public interface StudentRepository extends JpaRepository<Student,Long>{
    public Student getStudentByStuNo(Long stuNo);

    public Student getStudentByStuName(String StuName);

    public List<Student> getStudentsByClassId(Long classId, Pageable pageable);

//    @Query("select s.stuNo,s.stuName,s.stuAge,s.stuProvince,s.classId,c.className from Student s inner join" +
//            " ClassInfo c on s.classId=c.classId")
    @Query("select new com.xp.exe.jpaDemo.vo.StudentClassVo(s.stuNo,s.stuName,s.stuAge,s.stuProvince," +
            "s.classId,c.className)" +
            " from Student s inner join" +
            " ClassInfo c on s.classId=c.classId")
    public List<StudentClassVo> getStudentClassVoByClassName(String className,Pageable pageAble);
}
