import java.math.BigDecimal;
import java.util.Objects;

public class SavingsAccount extends Account {

    // M3 USING BUILDER
    public static class Builder extends Account.Builder {

        public Builder setMonthlyWithdrawalLimits(int monthlyWithdrawalLimits) {
            this.monthlyWithdrawalLimits = monthlyWithdrawalLimits;
            return this;
        }

        private int monthlyWithdrawalLimits;

    }

    private int monthlyWithdrawalLimits;

    private int currentMonthWithdrawalCount;

    public int getCurrentMonthWithdrawalCount() {
        return currentMonthWithdrawalCount;
    }

    public void setCurrentMonthWithdrawalCount(int currentMonthWithdrawalCount) {
        this.currentMonthWithdrawalCount = currentMonthWithdrawalCount;
    }

    public int getMonthlyWithdrawalLimits() {
        return monthlyWithdrawalLimits;
    }

    public void setMonthlyWithdrawalLimits(int monthlyWithdrawalLimits) {
        this.monthlyWithdrawalLimits = monthlyWithdrawalLimits;
    }

    // M3 USING BUILDER
    public SavingsAccount(Builder builder) {
        super(builder);
        this.monthlyWithdrawalLimits = builder.monthlyWithdrawalLimits;
        this.currentMonthWithdrawalCount = 0;
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

    public boolean isMontlyWithdrawalLimitReached() {
        return currentMonthWithdrawalCount >= monthlyWithdrawalLimits;
    }

    @Override
    public void withdrawal(BigDecimal withdrawalAmount) {

        if (!isMontlyWithdrawalLimitReached()) {
            System.out.println("You try to withdraw: $" + withdrawalAmount);
            super.withdrawal(withdrawalAmount);
            currentMonthWithdrawalCount++;
        } else {
            System.out.println("You already used limited for withdrawal for account #" + getAccountId());
        }

    }
}
