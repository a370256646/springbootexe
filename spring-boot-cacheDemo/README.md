Spring boot cache Demo

#说明
* spring boot集成cache来简化redis代码逻辑
* spring boot 默认会采用cache默认采用ConcurrentMapCacheManager作为底层缓存实现
* 当配置了redis后,spring boot会自动帮我们使用Redis来作为底层缓存实现

#解决目标
* 基于spring boot集成mybatis,redis项目上再练习cache操作
* 增加数据:先往数据库插入数据,插入成功之后将数据放入redis作为缓存数据
* 删除数据:删除数据库的数据,同时删除redis里的缓存数据
* 修改数据:修改数据库里的数据,同时修改redis中的缓存数据
* 查询数据:判断数据是否在缓存里存在,存在则直接从缓存中获取,不存在再去数据库查询

#请求url
* 增加员工信息:http://localhost:8080/addEmployee?name=张三&age=21&jobId=1520505993341
* 查询员工信息:http://localhost:8080/getEmployee?id=1520506484761
* 修改员工信息:http://localhost:8080/modifyEmployee?name=张三&age=25&jobId=1520505993341
* 删除员工信息:http://localhost:8080/delEmployee/1520506502584
