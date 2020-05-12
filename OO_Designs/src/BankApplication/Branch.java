package BankApplication;

import java.util.List;

public class Branch {
   private List<BankAccount> bankAccounts;
   private List<Customer> customers;
   private String branchId;
   
   public BankAccount createBankAccount() {
	   
   }
   
   public Customer getCustomerByPanNumber(String panNumber) {
	   
   }
   
   public String getAccountByAccountNumber(String accountNumber){
	   
   }
   
   public String getBranchId() {
	   return branchId;
   }
}
