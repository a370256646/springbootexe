Spring boot mybatis Demo

#说明
* spring boot 集成mybatis demo

#解决目标
* mybatis单表简单查询
* mybatis多表关联分页查询

#请求url
* 增加职位信息:http://localhost:8080/addJob?name=经理description=管人的
* 查询职位信息:http://localhost:8080/getJob/1520504339243
* 删除职位信息:http://localhost:8080/delJob/1520504339243

* 增加员工信息:http://localhost:8080/addEmployee?name=张三&age=21&jobId=1520505993341
* 查询员工信息:http://localhost:8080/getEmployee/1520506502584
* 修改员工信息:http://localhost:8080/modifyEmployee?name=张三&age=25&jobId=1520505993341
* 删除员工信息:http://localhost:8080/delEmployee/1520506502584

* 根据职位信息得到员工信息(分页):http://localhost:8080/getEmployeesByJobName?jobName=员工&pageSize=2&curPage=1