package BankApplication.Branches;

import java.util.logging.Logger;

public class BranchException extends Exception {

	public BranchException(Logger logger, String errorMsg) {
		logger.warning(errorMsg);
	}

}
