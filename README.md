# ActiveMQTest
ActiveMQ练习项目<br/>

基础流程：<br/>
1. 获得JMS connection factory. 通过我们提供特定环境的连接信息来构造factory。<br/>
2. 利用factory构造JMS connection<br/>
3. 启动connection<br/>
4. 通过connection创建JMS session.<br/>
5. 指定JMS destination.<br/>
6. 创建JMS producer或者创建JMS message并提供destination.<br/>
7. 创建JMS consumer或注册JMS message listener.<br/>
8. 发送和接收JMS message.<br/>
9. 关闭所有JMS资源，包括connection, session, producer, consumer等。<br/>
