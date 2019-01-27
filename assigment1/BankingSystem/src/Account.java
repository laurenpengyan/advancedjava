import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private static final int CURRENCY_PLACES = 2;

    // M2 HOMEWORK STATIC
    public static BigDecimal roundToCurrency(BigDecimal value) {
        return value.setScale(CURRENCY_PLACES, ROUNDING_MODE);
    }

    private long customerId;
    private long accountId;
    private BigDecimal interestRate = BigDecimal.ZERO;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(long customerId, long accountId, BigDecimal balance, BigDecimal interestRate) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = roundToCurrency(balance);
        this.interestRate = interestRate;
    }

    public void deposit(BigDecimal depositAmount) {

        if (depositAmount.doubleValue() > 0) {
            balance = balance.add(roundToCurrency(depositAmount));
            // balance += depositAmount;
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + depositAmount + " deposit!");
        } else {
            System.out.println("Account: #" + accountId + " deposit amount must be positive!  Provided=$" + depositAmount + ".");
        }

    }

    public void withdrawal(BigDecimal withdrawalAmount) {
        if (withdrawalAmount.doubleValue() > 0) {
            balance = balance.subtract(roundToCurrency(withdrawalAmount));
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + withdrawalAmount + " withdraw!");
        } else {
            System.out.println("Account: #" + accountId + " withdraw amount must be positive!  Provided=$" + withdrawalAmount + ".");
        }
    }

    public void transfer(Account recipientAccount, BigDecimal transferAmount) {
        if (balance.compareTo(roundToCurrency(transferAmount)) >= 0) {
            System.out.println("Transferring: $" + transferAmount + " from account #" + accountId + " to account #" + recipientAccount.getAccountId());
            withdrawal(transferAmount);
            recipientAccount.deposit(transferAmount);
        } else {
            System.out.println("Current account: #" + accountId + " doesn't have enough amount!  Need amount=$" + transferAmount + ".");
        }
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return customerId == account.customerId &&
                accountId == account.accountId &&
                Objects.equals(interestRate, account.interestRate) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, accountId, balance, interestRate);
    }


    @Override
    public int compareTo(Account that) {
        if (this.balance.compareTo(that.balance) < 0) {
            return -1;
        } else if (this.balance.compareTo(that.balance) > 0) {
            return 1;
        }

        if (this.accountId < that.accountId) {
            return -1;
        } else if (this.accountId > that.accountId) {
            return 1;
        }

        if (this.customerId < that.customerId) {
            return -1;
        } else if (this.customerId > that.customerId) {
            return 1;
        }
        return 0;
    }

}
