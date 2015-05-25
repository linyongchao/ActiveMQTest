package publish_subscribe;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public class ConsumerTest {
	public static void main(String[] args) throws JMSException {
		String[] arg={"1","2","3","4","5","6","7"};
		Consumer consumer = new Consumer();
		for (String stock : arg) {
			Destination destination = consumer.getSession().createTopic(
					"STOCKS." + stock);
			MessageConsumer messageConsumer = consumer.getSession()
					.createConsumer(destination);
			messageConsumer.setMessageListener(new Listener());
		}
	}
}
