package use;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private String brokerURL = "tcp://localhost:61616";
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageProducer producer;

	public Publisher() throws JMSException {
		factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = session.createProducer(null);
	}

	protected void sendMessage(String command) throws JMSException {
		Destination destination = session.createQueue("command");
		Message message = createStockMessage(command, session);
		producer.send(destination, message);
	}

	protected Message createStockMessage(String command, Session session)
			throws JMSException {
		MapMessage message = session.createMapMessage();
		message.setString("command", command);
		return message;
	}

	public void close() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}
}