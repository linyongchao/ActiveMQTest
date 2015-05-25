package p2p;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	protected String brokerURL="tcp://localhost:61616";
	protected ActiveMQConnectionFactory factory;
	protected Connection connection;
	protected Session session;
	protected MessageProducer producer;
	protected String[] jobs={"a","b"};

	public Publisher() throws JMSException {
		factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = session.createProducer(null);
	}

	protected void sendMessage() throws JMSException {
		for(int i = 0; i < jobs.length; i++) {
	        String job = jobs[i];  
	        Destination destination = session.createQueue("JOBS." + job);  
	        Message message = session.createObjectMessage(i);  
	        System.out.println("Sending: id: " + ((ObjectMessage)message).getObject() + " on queue: " + destination);  
	        producer.send(destination, message);  
	    }  
	}

	public void close() throws JMSException {
		if (connection != null) {
			connection.close();
		}
	}
}