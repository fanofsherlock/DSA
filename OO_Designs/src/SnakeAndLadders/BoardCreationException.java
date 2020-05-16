package SnakeAndLadders;

import java.util.logging.Logger;

public class BoardCreationException extends Exception {

	public BoardCreationException(Logger logger, String string) {
		logger.warning(string);
	}

}
