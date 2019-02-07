public class CheckingAccountFactory extends AccountFactory<CheckingAccount.Builder>{

    @Override
    public CheckingAccount createAccount(CheckingAccount.Builder builder) {
        return builder.build();
    }

}
