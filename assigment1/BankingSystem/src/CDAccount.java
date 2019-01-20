import java.util.Objects;

public class CDAccount extends Account {

    private int defaultMaturityPeriodMonths;

    public CDAccount(long customerId, long accountId, double balance, double interestRate, int defaultMaturityPeriodMonths) {
        super(customerId, accountId, balance, interestRate);
        this.defaultMaturityPeriodMonths = defaultMaturityPeriodMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CDAccount cdAccount = (CDAccount) o;

        return defaultMaturityPeriodMonths == cdAccount.defaultMaturityPeriodMonths;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defaultMaturityPeriodMonths);
    }


    // Getters and setters.
    public int getDefaultMaturityPeriodMonths() {
        return defaultMaturityPeriodMonths;
    }

    public void setDefaultMaturityPeriodMonths(int defaultMaturityPeriodMonths) {
        this.defaultMaturityPeriodMonths = defaultMaturityPeriodMonths;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CDAccount{");
        sb.append("defaultMaturityPeriodMonths=").append(defaultMaturityPeriodMonths);
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public void saveToCD(double amount, int maturityPeriodMonths) {
        System.out.println("You saved $ " + amount + " for " + maturityPeriodMonths + " months.");
    }
}
