
public class CheckingAccount extends BankAccount {
	
	double limit;
	
	public CheckingAccount(String accountNumber, double balance, double limit) {
		super(accountNumber, balance);
		this.limit = limit;
	}
	
	double getLimit() {
		return limit;
	}
	
	void setLimit(double limit) {
		this.limit = limit;
	}
	
	@Override
	void subtractBalance(double amount) {
		if(getBalance() + limit >= amount) {
			super.subtractBalance(amount);
		}else {
			System.out.println("Amount not available");
		}
	}
}
