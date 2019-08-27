
/**
 * @author dylan
 *
 */
public class Account {

	private int balance = 10000;

	/**
	 * @param amount
	 */
	public void deposit(int amount) {
		balance += amount;
	}

	/**
	 * @param amount
	 */
	public void withdraw(int amount) {
		balance -= amount;
	}

	/**
	 * @return
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param acct1
	 * @param acct2
	 * @param amount
	 */
	public static void transfer(Account acct1, Account acct2, int amount) {
		acct1.withdraw(amount);
		acct2.deposit(amount);
	}
}
