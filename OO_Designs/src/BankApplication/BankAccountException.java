package BankApplication;

import java.util.logging.Logger;

public class BankAccountException extends Exception {

	public BankAccountException(Logger logger, String string) {
		logger.warning(string);
	}

}
