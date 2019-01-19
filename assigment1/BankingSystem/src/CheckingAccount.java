
public class CheckingAccount extends Account {

	public CheckingAccount(long customerId, long accountId, double balance, double interestRate) {
		super(customerId, accountId, balance, interestRate);
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		//  Check if o is an instance of CheckingAccount.
		if (!(obj instanceof CheckingAccount)) {
			return false;
		}

		// Typecast obj to CheckingAccount so that we can compare properties.
		CheckingAccount account = (CheckingAccount) obj;

		// Compare the properties.
		return Double.compare(getAccountId(), account.getAccountId()) == 0;
	}

	@Override
	public String toString() {
		return "Checking account information - AccountId: " + getAccountId() + " Balance: $" + getBalance() +
				" Interest Rate: " + getInterestRate() + "%";
	}

	@Override
	public void close() {
		
	}

}
