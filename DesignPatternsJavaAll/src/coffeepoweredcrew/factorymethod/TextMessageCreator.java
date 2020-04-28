package coffeepoweredcrew.factorymethod;

import coffeepoweredcrew.factorymethod.message.Message;
import coffeepoweredcrew.factorymethod.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}



}
