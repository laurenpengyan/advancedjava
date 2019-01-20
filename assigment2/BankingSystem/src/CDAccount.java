
public class CDAccount extends Account {

	private int defaultMaturityPeriodMonths;

	public CDAccount(long customerId, long accountId, double balance, double interestRate, int defaultMaturityPeriodMonths) {
		super(customerId, accountId, balance, interestRate);
		this.defaultMaturityPeriodMonths = defaultMaturityPeriodMonths;
	}

	// Override methods.
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		//  Check if o is an instance of CDAccount.
		if (!(obj instanceof CDAccount)) {
			return false;
		}

		// Typecast obj to CDAccount so that we can compare properties.
		CDAccount account = (CDAccount) obj;

		// Compare the properties.
		return Double.compare(getAccountId(), account.getAccountId()) == 0;
	}

	@Override
	public String toString() {
		return "CD account information - Account ID: " + getAccountId() + " Balance: $" + getBalance() + " Interest Rate: "
				+ getInterestRate() + "%" + " Maturity Period Months: " + defaultMaturityPeriodMonths;
	}

	// Getters and setters.
	public int getMaturityPeriodMonths() {
		return defaultMaturityPeriodMonths;
	}

	public void setMaturityPeriodMonths(int defaultMaturityPeriodMonths) {
		this.defaultMaturityPeriodMonths = defaultMaturityPeriodMonths;
	}

}
