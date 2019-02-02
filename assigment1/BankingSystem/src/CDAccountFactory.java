public class CDAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(Account.Builder builder) {
        return new CDAccount((CDAccount.Builder) builder);
    }

}
