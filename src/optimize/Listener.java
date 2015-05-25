package optimize;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			MapMessage map = (MapMessage) message;
			String command = map.getString("command");
			System.out.println(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}