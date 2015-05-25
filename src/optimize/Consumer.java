package optimize;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public class Consumer extends OPTObject {
	private MessageConsumer messageConsumer;

	public Consumer() throws JMSException {
		super();
		messageConsumer = session.createConsumer(destination);
	}

	public MessageConsumer getMessageConsumer() {
		return messageConsumer;
	}
}