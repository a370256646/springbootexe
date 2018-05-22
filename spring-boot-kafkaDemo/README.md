**Spring boot kafka Demo**

#说明
* spring boot集成kafka来完成消息推送和通知
* kafkaConsume项目用来订阅和消费消息
* kafkaProduce项目用来生产消息

#解决目标
* 练习spring boot集成kafka完成消息推送
* kafkaProduce项目提供一个接口/sendMessage,每次调用向kafka server发起一条主题为myTopic的消息
* kafkaConsume项目配置监听,订阅和消费myTopic消息并将消息入库

#请求url
* 发起一条消息:http://localhost:8000/sendMessage
