package p2p;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public class ConsumerTest {
	protected static String[] jobs={"a","b"};
	public static void main(String[] args) throws JMSException {  
        Consumer consumer = new Consumer();  
        for (String job : jobs) {  
            Destination destination = consumer.getSession().createQueue("JOBS." + job);  
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);  
            messageConsumer.setMessageListener(new Listener(job));  
        }  
    }  
}