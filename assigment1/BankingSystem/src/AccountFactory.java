import java.math.BigDecimal;

public abstract class AccountFactory {

    public abstract Account buildAccount(long customerId, long accountId, BigDecimal balance,
                                         BigDecimal interestRate, BigDecimal overDraftFee);

    public Account createAccount(long customerId, long accountId, BigDecimal balance,
                                 BigDecimal interestRate, BigDecimal overDraftFee) {
        Account account = buildAccount(customerId, accountId, balance, interestRate, overDraftFee);
        return account;
    }

}
