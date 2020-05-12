package BankApplication.BankAccounts;

public class SavingsAccount extends BankAccount {

	double minimumBalance = 10000;
	double interestRate = 4.5;

	public SavingsAccount(double amount, double minimumBalance, double interestRate) {
		super(amount, minimumBalance, interestRate);
	}

	@Override
	String getType() {
		return "Saving";
	}
}
