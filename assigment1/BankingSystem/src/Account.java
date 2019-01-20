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

        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + depositAmount + " deposit!");
        } else {
            System.out.println("Account: #" + accountId + " deposit amount must be positive!  Provided=$" + depositAmount + ".");
        }

    }

    public void withdrawal(double withdrawalAmount) {

        if (withdrawalAmount > 0) {
            balance -= withdrawalAmount;
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + withdrawalAmount + " withdraw!");
        } else {
            System.out.println("Account: #" + accountId + " withdraw amount must be positive!  Provided=$" + withdrawalAmount + ".");
        }

    }

    public void transfer(Account recipientAccount, double transferAmount) {
        if (this.getBalance() >= transferAmount) {
            System.out.println("Transferring: $" + transferAmount + " from account #" + accountId + " to account #" + recipientAccount.getAccountId());

            withdrawal(transferAmount);
            recipientAccount.deposit(transferAmount);
        } else {
            System.out.println("Current account: #" + accountId + " doesn't have enough amount!  Need amount=$" + transferAmount + ".");

        }

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
