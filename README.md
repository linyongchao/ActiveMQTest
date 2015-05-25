# ActiveMQTest
ActiveMQ练习项目

基础流程：
1. 获得JMS connection factory. 通过我们提供特定环境的连接信息来构造factory。
2. 利用factory构造JMS connection
3. 启动connection
4. 通过connection创建JMS session.
5. 指定JMS destination.
6. 创建JMS producer或者创建JMS message并提供destination.
7. 创建JMS consumer或注册JMS message listener.
8. 发送和接收JMS message.
9. 关闭所有JMS资源，包括connection, session, producer, consumer等。