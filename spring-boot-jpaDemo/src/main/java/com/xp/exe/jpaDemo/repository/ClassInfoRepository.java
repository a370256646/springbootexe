package com.xp.exe.jpaDemo.repository;

import com.xp.exe.jpaDemo.model.ClassInfo;
import com.xp.exe.jpaDemo.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/8 10:02
 * Modified By:
 */
public interface ClassInfoRepository extends JpaRepository<ClassInfo,Long>{

    public ClassInfo getClassInfoByClassId(Long classId);
}
