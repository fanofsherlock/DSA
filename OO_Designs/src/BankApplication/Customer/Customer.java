package BankApplication.Customer;

import java.util.ArrayList;
import java.util.List;

import BankApplication.BankAccounts.BankAccount;

public class Customer {

	private String panNumber;
	private List<BankAccount> accounts;

	public Customer(String panNumber) {
		accounts = new ArrayList<BankAccount>();
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
