Spring boot JPA Demo

#说明
* spring data jpa使用demo

#解决目标
* jpa单表简单查询
* jpa单表分页查询
* jpa多表关联查询
* jpa单表关联分页查询

#请求url
* 增加班级信息:http://localhost:8080/addClassInfo?className=一班
* 查询班级信息:http://localhost:8080/getClassInfo/1520491169296
* 删除班级信息:http://localhost:8080/delClassInfo/1520476200936

* 增加学生信息:http://localhost:8080/addStudent?stuName=张三&stuAge=21&stuProvince=广东省&classId=1520491169296
* 查询学生信息:http://localhost:8080/getStudent/1520476200936
* 修改学生信息:http://localhost:8080/modifyStudent?stuName=张三&stuAge=25&stuProvince=浙江省
* 删除学生信息:http://localhost:8080/delStudent/1520476200936

* 根据班级id得到学生信息(分页):http://localhost:8080/getStudentByClassId?classId=1520491169296&page=0
* 根据班级name多表关联得到学生信息(分页):http://localhost:8080/getStudentClassInfoByClassName?className=一班&page=0