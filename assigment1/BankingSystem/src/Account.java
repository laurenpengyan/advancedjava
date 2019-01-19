import java.util.Objects;

public abstract class Account {

    private long customerId;
    private long accountId;
    private double balance;
    private double interestRate;

    public Account(long customerId, long accountId, double balance, double interestRate) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // Getters and setters.
    public long getCustomerId() {
        return customerId;
    }

    public long getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("customerId=").append(customerId);
        sb.append(", accountId=").append(accountId);
        sb.append(", balance=").append(balance);
        sb.append(", interestRate=").append(interestRate);
        sb.append('}');
        return sb.toString();
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Instance methods.
    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("New balance after deposit is: $" + balance);
    }

    public void withdrawal(double withdrawalAmount) {
        balance -= withdrawalAmount;
        System.out.println("New balance after withdrawal is: $" + balance);
    }

    public void transfer(long recipientAccountId, double transferAmount) {
        System.out.println("Transfering: $" + transferAmount + " to account: " + recipientAccountId);
        balance -= transferAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return customerId == account.customerId &&
                accountId == account.accountId &&
                Double.compare(account.balance, balance) == 0 &&
                Double.compare(account.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, accountId, balance, interestRate);
    }

}
