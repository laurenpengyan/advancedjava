public class CDAccountFactory extends AccountFactory<CDAccount.Builder> {

    @Override
    public Account createAccount(CDAccount.Builder builder) {
        return builder.build();
    }

}
