import java.util.Objects;

public class CheckingAccount extends Account {

    public double getOverDraftFee() {
        return overDraftFee;
    }

    public void setOverDraftFee(double overDraftFee) {
        this.overDraftFee = overDraftFee;
    }

    private double overDraftFee;

    // M2 HOMEWORK STATIC
    private static final String CHECKING_ACCOUNT_TYPE = "checking";

    /*
    // M2 HOMEWORK ENUM
    public enum CheckingAccountCategory {
        PERSONAL, STUDENT, BUSINESS;

        public void getCheckingAccountCategory() {
            switch (this) {
                case PERSONAL: {
                    System.out.println("this is Personal category of checking account ");
                    break;
                }
                case STUDENT: {
                    System.out.println("this is Student category of checking account");
                    break;
                }
                case BUSINESS: {
                    System.out.println("this is Business category of checking account");
                    break;
                }
            }
        }
    }
    */

    public CheckingAccount(long customerId, long accountId, double balance, double interestRate, double overDraftFee) {
        super(customerId, accountId, balance, interestRate);
        this.overDraftFee = overDraftFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CheckingAccount that = (CheckingAccount) o;

        return Double.compare(that.overDraftFee, overDraftFee) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), overDraftFee);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckingAccount{");
        sb.append("overDraftFee=").append(overDraftFee);
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public void openCheck(String date, String receiver, double amount, String reason) {

        if (getBalance() >= amount) {
            System.out.println("The date is: " + date + " receiver is: " + receiver + " amount is " + amount + " the reason is: "
                    + reason);
        } else {
            System.out.println("You don't have enough money in this account #" + getAccountId());
        }
    }

    // M2 HOMEWORK STATIC
    public static String getCheckingAccountType() {
        return CHECKING_ACCOUNT_TYPE;
    }

}
