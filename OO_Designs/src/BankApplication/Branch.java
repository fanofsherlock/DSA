package BankApplication;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class Branch {

	private Logger logger = Logger.getLogger(Branch.class.getName());

	// Assigned by head office
	private String branchId;
	private List<BankAccount> bankAccounts;
	private List<Customer> customers;

	AtomicLong lastbankAccountCreated;

	public Branch() {
		lastbankAccountCreated = new AtomicLong(0L);
	}

	/* Account creation through factory method */
	public synchronized BankAccount createBankAccount(String panNumber, String type, Double amount)
			throws BankAccountException {
		BankAccount newAccount;

		try {
			newAccount = AccountCreationFactory.getInstance(panNumber, type, amount);
			// setting new accountId
			long newAccountId = lastbankAccountCreated.incrementAndGet();
			newAccount.setAccountNumber(String.valueOf(newAccountId));

		} catch (BankAccountException e) {
			// Re-throwing Account creation Exception
			throw new BankAccountException(logger, e.getMessage());
		}

		// if a customer with the same pan exists, then adding this bank account
		Customer newCustomer = null;
		try {
			newCustomer = getCustomerByPanNumber(panNumber);
			newCustomer.addBankAccount(newAccount);
			customers.add(newCustomer);
			return newAccount;
		} catch (CustomerException e) {
		}

		// Otherwise creating a new customer
		newCustomer = new Customer(panNumber);
		newCustomer.addBankAccount(newAccount);
		customers.add(newCustomer);
		return newAccount;

	}

	/* Searches through the customers registered at this branch using streams */
	public Customer getCustomerByPanNumber(String panNumber) throws CustomerException {
		String errorMsg = "Customer with given pan " + panNumber + " not found in db.";

		Optional<Customer> customer = customers.parallelStream()
				.filter(e -> e.getPanNumber().equalsIgnoreCase(panNumber)).findAny();

		// throw error that customer is not found
		customer.orElseThrow(() -> new CustomerException(logger, errorMsg));

		// else return the found customer
		return customer.get();
	}

	/* Searches through the bank accounts registered at this branch using streams */
	public BankAccount getAccountByAccountNumber(String accountNumber) throws BankAccountException {
		String errorMsg = "Bank Account with given acctNo: " + accountNumber + " not found in db.";

		Optional<BankAccount> account = bankAccounts.parallelStream()
				.filter(e -> e.getAccountNumber().equalsIgnoreCase(accountNumber)).findAny();

		// throw error that account is not found
		account.orElseThrow(() -> new BankAccountException(logger, errorMsg));

		// else return the found account
		return account.get();
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
}
