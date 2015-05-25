package optimize;

import javax.jms.JMSException;

public class ConsumerTest {
	public static void main(String[] args) throws JMSException {
		Consumer consumer = new Consumer();
		consumer.getMessageConsumer().setMessageListener(new Listener());
	}
}