package optimize;

import javax.jms.JMSException;

public class PublishTest2 {
	public static void main(String[] args) throws JMSException {
		Publisher publisher = new Publisher();
		for (int i = 0; i < 5; i++) {
			publisher.sendMessage("2-----command:"+i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		publisher.close();
	}
}
