package ChatServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Client {

	long selfPhoneNumber;
	List<Long> contacts;
	HashMap<Long, List<String>> chats;
	Server s;

	public void readAllMessages(long phoneNo) {
		List<String> messages = chats.get(phoneNo);
		for (String s : messages) {
			System.out.println(s);
		}
	}

	public void receive(String msg, long phoneNo) {
		List<String> messages = chats.get(phoneNo);
		if (messages == null) {
			messages = new ArrayList<String>();
			messages.add(msg);
			chats.put(phoneNo, messages);
		} else {
			messages.add(msg);
		}
	}

	public boolean send(String message, long phoneNo) {
		return s.sendMessagge(message, phoneNo);
	}
}
