package com.xp.exe.jpaDemo.controller;

import com.xp.exe.jpaDemo.enums.ClassInfoOptionalEnum;
import com.xp.exe.jpaDemo.interfaces.IClassInfoOptional;
import com.xp.exe.jpaDemo.model.ClassInfo;
import com.xp.exe.jpaDemo.repository.ClassInfoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description: 班级接口
 * Date:Create in 2018/3/8 14:22
 * Modified By:
 */
@RestController
public class ClassInfoController implements IClassInfoOptional{
    private ClassInfoRepository classInfoRepository;
    public ClassInfoController(ClassInfoRepository classInfoRepository){
        this.classInfoRepository=classInfoRepository;
    }
    @Override
    @RequestMapping("/addClassInfo")
    public String addClassInfo(ClassInfo classInfo) {
        classInfo.setClassId(System.currentTimeMillis());
        classInfoRepository.save(classInfo);
        return ClassInfoOptionalEnum.OPTIONAL_SUCCESS.getInfo();
    }

    @Override
    @RequestMapping("/delClassInfo/{classId}")
    public String delClassInfo(@PathVariable("classId") Long classId) {
        classInfoRepository.deleteById(classId);
        return ClassInfoOptionalEnum.OPTIONAL_SUCCESS.getInfo();
    }

    @Override
    @RequestMapping("/getClassInfo/{classId}")
    public String getClassInfo(@PathVariable("classId") Long classId) {
        return classInfoRepository.getClassInfoByClassId(classId).toString();
    }

}
