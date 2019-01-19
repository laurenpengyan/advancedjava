import java.util.Objects;

public class CDAccount extends Account {

    private int maturityPeriodMonths;

    public CDAccount(long customerId, long accountId, double balance, double interestRate, int maturityPeriodMonths) {
        super(customerId, accountId, balance, interestRate);
        this.maturityPeriodMonths = maturityPeriodMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CDAccount cdAccount = (CDAccount) o;

        return maturityPeriodMonths == cdAccount.maturityPeriodMonths;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maturityPeriodMonths);
    }


    // Getters and setters.
    public int getMaturityPeriodMonths() {
        return maturityPeriodMonths;
    }

    public void setMaturityPeriodMonths(int maturityPeriodMonths) {
        this.maturityPeriodMonths = maturityPeriodMonths;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CDAccount{");
        sb.append("maturityPeriodMonths=").append(maturityPeriodMonths);
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
