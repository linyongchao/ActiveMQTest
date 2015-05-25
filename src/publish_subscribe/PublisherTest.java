package publish_subscribe;

import javax.jms.JMSException;

public class PublisherTest {
	public static void main(String[] args) throws JMSException {
		String[] arg={"1","2","3","4","5","6","7"};
		if (arg.length < 1)
			throw new IllegalArgumentException();
		// Create publisher
		Publisher publisher = new Publisher();
		// Set topics
		publisher.setTopics(arg);

		for (int i = 0; i < 1; i++) {
			publisher.sendMessage(arg);
			System.out.println("Publisher '" + i + " price messages");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Close all resources
		publisher.close();
	}
}
