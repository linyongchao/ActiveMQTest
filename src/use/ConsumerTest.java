package use;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;


public class ConsumerTest {
	public static void main(String[] args) throws JMSException {
		Consumer consumer = new Consumer();
		Destination destination = consumer.getSession().createQueue("command");
		MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);  
        messageConsumer.setMessageListener(new Listener());  
	}
}