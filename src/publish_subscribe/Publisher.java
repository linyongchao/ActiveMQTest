package publish_subscribe;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

public class Publisher {
	protected ActiveMQConnectionFactory factory;
	protected String brokerURL="tcp://localhost:61616";
	protected Connection connection;
	protected Session session;
	protected MessageProducer producer;
	protected Destination[] destinations;

	public Publisher() throws JMSException {
		factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		try {
			connection.start();
		} catch (JMSException jmse) {
			connection.close();
			throw jmse;
		}
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = session.createProducer(null);
	}

	protected void setTopics(String[] stocks) throws JMSException {
		destinations = new Destination[stocks.length];
		for (int i = 0; i < stocks.length; i++) {
			destinations[i] = session.createTopic("STOCKS." + stocks[i]);
		}
	}

	protected void sendMessage(String[] stocks) throws JMSException {
		for (int i = 0; i < stocks.length; i++) {
			Message message = createStockMessage(stocks[i], session);
			System.out.println("Sending: "
					+ ((ActiveMQMapMessage) message).getContentMap()
					+ " on destination: " + destinations[i]);
			producer.send(destinations[i], message);
		}
	}

	protected Message createStockMessage(String stock, Session session)
			throws JMSException {
		MapMessage message = session.createMapMessage();
		message.setString("stock", stock);
		message.setDouble("price", 1.00);
		message.setDouble("offer", 0.01);
		message.setBoolean("up", true);
		return message;
	}

	public void close() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}
}