package optimize;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;

public class Publisher extends OPTObject {
	private MessageProducer producer;

	public Publisher() throws JMSException {
		super();
		producer = session.createProducer(destination);
	}

	protected void sendMessage(String command) throws JMSException {
		MapMessage message = session.createMapMessage();
		message.setString("command", command);
		producer.send(message);
	}
}