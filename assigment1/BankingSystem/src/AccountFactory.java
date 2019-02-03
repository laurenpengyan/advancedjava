
public abstract class AccountFactory<T extends Account.Builder> {

    public abstract Account createAccount(T builder);

}
