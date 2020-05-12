package BankApplication;

public class SavingsAccount extends BankAccount {

	double minimumBalance = 10000;
	double interestRate = 4.5;

	@Override
	String getType() {
		return "Saving";
	}
}
