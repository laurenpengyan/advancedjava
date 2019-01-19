
public class SavingsAccount extends Account {

	public SavingsAccount(long customerId, long accountId, double balance, double interestRate) {
		super(customerId, accountId, balance, interestRate);
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		//  Check if o is an instance of SavingsAccount.
		if (!(obj instanceof SavingsAccount)) {
			return false;
		}

		// Typecast obj to SavingsAccount so that we can compare properties.
		SavingsAccount account = (SavingsAccount) obj;

		// Compare the properties.
		return Double.compare(getAccountId(), account.getAccountId()) == 0;
	}

	@Override
	public String toString() {
		return "Savings account information - AccountId: " + getAccountId() + " Balance: $" + getBalance() +
				" Interest Rate: " + getInterestRate() + "%";
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
