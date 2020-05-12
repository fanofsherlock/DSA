package BankApplication;

public class Transaction {
	
	//Assigned by bank account
	private String transactionId;
	//Transaction amount
	private double amount;
	//"withdraw" or "deposit"
	private String type;

	public String getTransactionId() {

		return transactionId;
	}

	public double getAmount() {

		return amount;
	}

	public String getType() {

		return type;
	}

}
