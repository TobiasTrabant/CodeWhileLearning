
public class BankAccount {
	
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber,double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	double getBalance() {
		return balance;
	}
	
	String getAccountNumber() {
		return accountNumber;
	}
	
	void addBalance(double amount) {
		balance += amount;
	}
	
	void subtractBalance(double amount) {
		balance -= amount;
	}
}
