package BankApplication.Transactions;

public enum TransactionType {
	WITHDRAW, DEPOSIT;

	@Override
	public String toString() {
		return this.name();
	}

}
