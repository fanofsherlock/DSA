package BankApplication;

import java.util.logging.Logger;

public class AccountCreationFactory {

	private static Logger logger = Logger.getLogger(AccountCreationFactory.class.getName());

	public static BankAccount getInstance(String panNumber, String type, Double amount)
			throws BankAccountException {
		BankAccount newAccount = null;

		switch (type) {
		case "Current":
			newAccount = new CurrentAcount();
			break;
		case "Saving":
			newAccount = new SavingsAccount();
			break;
		default:
			throw new BankAccountException(logger, type + " account type is not supported!");
		}

		return newAccount;
	}

}
