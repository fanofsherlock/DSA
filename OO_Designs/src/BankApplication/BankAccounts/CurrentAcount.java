package BankApplication.BankAccounts;

public class CurrentAcount extends BankAccount {

	double minimumBalance = 20000;
	double interestRate = 0;

	public CurrentAcount() {
		super();
	}

	@Override
	String getType() {
		return "Current";
	}

}
