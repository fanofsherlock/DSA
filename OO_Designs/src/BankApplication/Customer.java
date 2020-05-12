package BankApplication;

import java.util.List;

public class Customer {

	private String panNumber;
	private List<BankAccount> accounts;

	public Customer(String panNumber) {
		this.panNumber = panNumber;
	}

	public List<BankAccount> getBankAccounts() {
		return accounts;
	}

	public void addBankAccount(BankAccount account) {
		accounts.add(account);
	}

	public String getPanNumber() {
		return panNumber;
	}

	@Override
	public String toString() {
		return panNumber;
	}

}
