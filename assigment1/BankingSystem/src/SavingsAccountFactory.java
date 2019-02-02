public class SavingsAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(Account.Builder builder) {
        return new SavingsAccount((SavingsAccount.Builder) builder);
    }

}
