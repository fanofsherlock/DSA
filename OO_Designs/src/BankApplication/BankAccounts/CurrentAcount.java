package BankApplication.BankAccounts;

public class CurrentAcount extends BankAccount {

	double minimumBalance = 20000;
	double interestRate = 0;

	public CurrentAcount(double amount,double minimumBalance, double interestRate) {
		super(amount,minimumBalance,interestRate);
	}

	@Override
	String getType() {
		return "Current";
	}

}
