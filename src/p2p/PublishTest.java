package p2p;

import javax.jms.JMSException;

public class PublishTest {
	public static void main(String[] args) throws JMSException {
		Publisher publisher = new Publisher();
		for (int i = 0; i < 10; i++) {
			publisher.sendMessage();
			System.out.println("Published " + i + " job messages");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		publisher.close();
	}
}
