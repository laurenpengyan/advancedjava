
public abstract class Account {
	
	private long customerId;
	private long accountId;
	private double balance;
	private double interestRate;

	public Account(long customerId, long accountId, double balance, double interestRate) {
		this.customerId = customerId;
		this.accountId = accountId;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	// Override methods.
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

        //  Check if o is an instance of Account.
		if (!(obj instanceof Account)) {
			return false;
		}

		// Typecast obj to Account so that we can compare properties.
		Account account = (Account) obj;

		// Compare the properties.
		return Double.compare(accountId, account.accountId) == 0;
	}

	@Override
	public String toString() {
		return "Account information - AccountId: " + accountId + " Balance: $" + balance + " Interest Rate: " +
				interestRate  + "%";
	}

	// Getters and setters.
	public long getCustomerId() {
		return customerId;
	}

	public long getAccountId() {
		return accountId;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// Instance methods.
	public void deposit(double depositAmount){
		balance += depositAmount;
		System.out.println("New balance after deposit is: $" + balance);
	}

	public void withdrawal(double withdrawalAmount){
		balance -= withdrawalAmount;
		System.out.println("New balance after withdrawal is: $" + balance);
	}

	public void transfer(long recipientAccountId, double transferAmount){
		System.out.println("Transfering: $" + transferAmount + " to account: " + recipientAccountId);
		balance -= transferAmount;
	}
}
