import java.util.Objects;

public class SavingsAccount extends Account {

    private int monthlyWithdrawalLimits;

    public int getMonthlyWithdrawalLimits() {
        return monthlyWithdrawalLimits;
    }

    public void setMonthlyWithdrawalLimits(int monthlyWithdrawalLimits) {
        this.monthlyWithdrawalLimits = monthlyWithdrawalLimits;
    }

    public SavingsAccount(long customerId, long accountId, double balance, double interestRate, int monthlyWithdrawalLimits) {
        super(customerId, accountId, balance, interestRate);
        this.monthlyWithdrawalLimits = monthlyWithdrawalLimits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SavingsAccount that = (SavingsAccount) o;
        return monthlyWithdrawalLimits == that.monthlyWithdrawalLimits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthlyWithdrawalLimits);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SavingsAccount{");
        sb.append("monthlyWithdrawalLimits=").append(monthlyWithdrawalLimits);
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
