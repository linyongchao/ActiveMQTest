package optimize;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class OPTObject {
	// 下面的路径要写到配置文件里去
	protected String brokerURL = "tcp://localhost:61616";
	protected ActiveMQConnectionFactory factory;
	protected Connection connection;
	protected Session session;
	protected Destination destination;

	public OPTObject() throws JMSException {
		factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createQueue("command");
	}

	public Session getSession() {
		return session;
	}

	public void close() throws JMSException {
		if (session != null) {
			session.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}