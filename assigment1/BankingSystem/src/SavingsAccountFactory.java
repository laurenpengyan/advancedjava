public class SavingsAccountFactory extends AccountFactory<SavingsAccount.Builder> {

    @Override
    public Account createAccount(SavingsAccount.Builder builder) {
        return builder.build();
    }

}
