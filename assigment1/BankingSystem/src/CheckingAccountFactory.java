import java.math.BigDecimal;

public class CheckingAccountFactory extends AccountFactory {

    @Override
    public Account buildAccount(long customerId, long accountId, BigDecimal balance, BigDecimal interestRate, BigDecimal overDraftFee) {
        return new CheckingAccount(customerId, accountId, balance, interestRate, overDraftFee);
    }
}
