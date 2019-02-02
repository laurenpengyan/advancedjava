import java.math.BigDecimal;

public class CheckingAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(Account.Builder builder) {
        return new CheckingAccount((CheckingAccount.Builder) builder);
    }

}
