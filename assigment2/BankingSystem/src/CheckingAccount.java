
public class CheckingAccount extends Account {

	// M2 HOMEWORK STATIC
	private static String ACCOUNT_TYPE = "checking";

	// M2 HOMEWORK ENUM
	public enum CheckingAccountCategory {
		PERSONAL, STUDENT, BUSINESS;

		public void getCategory(){
			switch (this){
				case PERSONAL: {
					System.out.println("this is Personal category");
					break;
				}
				case STUDENT: {
					System.out.println("this is Student category");
					break;
				}
				case BUSINESS:{
					System.out.println("this is Business category");
					break;
				}
			}
		}
	}

	public CheckingAccount(long customerId, long accountId, double balance, double interestRate) {
		super(customerId, accountId, balance, interestRate);
	}

	// Override methods.
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

	// M2 HOMEWORK STATIC
	public static String getAccountType(){ return ACCOUNT_TYPE; }

}
