import java.util.Comparator;

public class AccountComparator<Account extends Comparable<Account>> implements Comparator<Account> {

    @Override
    public int compare(Account a1, Account a2) {
        return a1.compareTo(a1);
    }

}
