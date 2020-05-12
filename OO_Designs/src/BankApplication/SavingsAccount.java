package BankApplication;

public class SavingsAccount extends BankAccount {

	double minimumBalance = 10000;
	double interestRate = 4.5;

	public SavingsAccount() {
		super();
	}

	@Override
	String getType() {
		return "Saving";
	}
}
