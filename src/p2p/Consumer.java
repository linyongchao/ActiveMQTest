package p2p;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	protected ActiveMQConnectionFactory factory;
	protected String brokerURL="tcp://localhost:61616";
	protected Connection connection;
	protected Session session;

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