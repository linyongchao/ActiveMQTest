package use;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	//下面的路径要写到配置文件里去
	private String brokerURL = "tcp://localhost:61616";
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;

	public Consumer() throws JMSException {
		factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public Session getSession() {
		return session;
	}
}