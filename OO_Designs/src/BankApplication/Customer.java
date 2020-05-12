package BankApplication;

import java.util.List;

public class Customer {

	private String panNumber;
	private List<BankAccount> accounts;

	public List<BankAccount> getBankAccount() {
		return accounts;
	}

	public String getPanNumber() {
		return panNumber;
	}

}
