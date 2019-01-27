import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private static final int CURRENCY_PLACES = 2;

    private long customerId;
    private long accountId;
    // private double balance;
    private double interestRate;
    private BigDecimal balance;

    public Account(long customerId, long accountId, BigDecimal balance, double interestRate) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = convertToCurrencyFormat(balance);
        this.interestRate = interestRate;
    }

    public void deposit(BigDecimal depositAmount) {

        if (depositAmount.doubleValue() > 0) {
            balance = balance.add(convertToCurrencyFormat(depositAmount));
            // balance += depositAmount;
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + depositAmount + " deposit!");
        } else {
            System.out.println("Account: #" + accountId + " deposit amount must be positive!  Provided=$" + depositAmount + ".");
        }

    }

    public void withdrawal(BigDecimal withdrawalAmount) {
        if (withdrawalAmount.doubleValue() > 0) {
            balance = balance.subtract(convertToCurrencyFormat(withdrawalAmount));
            System.out.println("Account: #" + accountId + " new balance is $" + balance + " after $" + withdrawalAmount + " withdraw!");
        } else {
            System.out.println("Account: #" + accountId + " withdraw amount must be positive!  Provided=$" + withdrawalAmount + ".");
        }
    }

    public void transfer(Account recipientAccount, BigDecimal transferAmount) {
        if (balance.compareTo(convertToCurrencyFormat(transferAmount)) >= 0) {
            System.out.println("Transferring: $" + transferAmount + " from account #" + accountId + " to account #" + recipientAccount.getAccountId());
            withdrawal(transferAmount);
            recipientAccount.deposit(transferAmount);
        } else {
            System.out.println("Current account: #" + accountId + " doesn't have enough amount!  Need amount=$" + transferAmount + ".");
        }
    }

    public static BigDecimal convertToCurrencyFormat(BigDecimal value) {
        return value.setScale(CURRENCY_PLACES, ROUNDING_MODE);
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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
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
                balance.compareTo(account.balance) == 0 &&
                Double.compare(account.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, accountId, balance, interestRate);
    }

    public int compareTo(Account o) {

        // change this to use balance

        // First account is less than second account.
        if (this.accountId < o.accountId) {
            return -1;
        }

        // First account is greater than second account.
        else if(this.accountId > o.accountId){
            return 1;
        }

        // The accounts are equal.
        return 0;
    }
}
