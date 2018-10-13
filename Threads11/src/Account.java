
public class Account {

	private int balance = 10000;
	
	public void deposit(int amount) {
		balance+=amount;
	}
	
	public void withdraw(int amount) {
		balance-=amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account acct1, Account acct2, int amount) {
		acct1.withdraw(amount);
		acct2.deposit(amount);
	}
}
