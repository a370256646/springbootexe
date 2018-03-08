package com.xp.exe.jpaDemo.controller;

import com.xp.exe.jpaDemo.enums.StudentOptionalEnum;
import com.xp.exe.jpaDemo.interfaces.IStudentOptional;
import com.xp.exe.jpaDemo.model.Student;
import com.xp.exe.jpaDemo.repository.StudentRepository;
import com.xp.exe.jpaDemo.vo.StudentClassVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 10:01
 * Modified By:
 */
@RestController
public class StudentController implements IStudentOptional{
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    @RequestMapping("/addStudent")
    public String addStudent(Student student) {
        student.setStuNo(System.currentTimeMillis());
        studentRepository.save(student);
        return StudentOptionalEnum.OPTIONAL_SUCCESS.getInfo();
    }

    @Override
    @RequestMapping("/getStudent/{id}")
    public String getStudent(@PathVariable("id") long id) {
        return studentRepository.getStudentByStuNo(id).toString();
    }

    @Override
    @RequestMapping("/modifyStudent")
    public String modifyStudent(Student student) {
        Student oldStudent=studentRepository.getStudentByStuName(student.getStuName());
        if(null==oldStudent){
            return StudentOptionalEnum.STUDENT_NOT_EXIST.getInfo();
        }
        student.setStuNo(oldStudent.getStuNo());
        studentRepository.save(student);
        return StudentOptionalEnum.OPTIONAL_SUCCESS.getInfo();
    }

    @Override
    @RequestMapping("/delStudent/{id}")
    public String delStudent(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return StudentOptionalEnum.OPTIONAL_SUCCESS.getInfo();
    }

    @Override
    @RequestMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @RequestMapping("/getStudentByClassId")
    public List<Student> getStudentByClassId(Long classId, @PageableDefault(value = 5,sort = {"stuAge"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        return studentRepository.getStudentsByClassId(classId,pageable);
    }

    @Override
    @RequestMapping("/getStudentClassInfoByClassName")
    public List<StudentClassVo> getStudentClassVoByClassName(String className,@PageableDefault(value = 5,
            sort = {"stuAge"},direction = Sort.Direction.DESC) Pageable pageable) {
        return studentRepository.getStudentClassVoByClassName(className,pageable);
    }
}
