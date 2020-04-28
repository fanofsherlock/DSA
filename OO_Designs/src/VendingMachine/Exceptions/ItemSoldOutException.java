package VendingMachine.Exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemSoldOutException extends Exception {

	public ItemSoldOutException(String message, Logger logger) {
		logger.log(Level.INFO, message);
	}
}