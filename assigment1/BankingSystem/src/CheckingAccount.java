import java.util.Objects;

public class CheckingAccount extends Account {

    public double getOverDraftFee() {
        return overDraftFee;
    }

    public void setOverDraftFee(double overDraftFee) {
        this.overDraftFee = overDraftFee;
    }

    private double overDraftFee;

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
}
