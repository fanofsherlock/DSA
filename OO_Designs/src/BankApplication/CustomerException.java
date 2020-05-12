package BankApplication;

import java.util.logging.Logger;

public class CustomerException extends Exception {

	public CustomerException(Logger logger, String errorMsg) {
		logger.warning(errorMsg);
	}

}
