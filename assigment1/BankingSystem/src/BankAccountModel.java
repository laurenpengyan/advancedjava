import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// M5 MVC Pattern
public class BankAccountModel {

    private final List<Account> accountList;

    public BankAccountModel(List<Account> accountList) {
        this.accountList = accountList;
    }

    public BankAccountModel() {
        this(new ArrayList<>());
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void createNewAccount(String accountType, int customerId, long accountId, BigDecimal initialBalance) {

        Account account = null;

        if ("Checking".equals(accountType)) {
            account = AccountFactory.createDefaultCheckingAccount(customerId, accountId, initialBalance);
        } else if ("Savings".equals(accountType)) {
            account = AccountFactory.createDefaultSavingAccount(customerId, accountId, initialBalance);
        } else if ("CD".equals(accountType)) {
            account = AccountFactory.createDefaultCDAccount(customerId, accountId, initialBalance);
        } else {
            throw new IllegalStateException("Undefined account type " + accountType);
        }

        this.accountList.add(account);

        dumpAccountList();

    }

    private void dumpAccountList() {

        System.out.println("Current account size=" + this.accountList.size());
        for (Account account : accountList) {
            System.out.println("\t" + account);
        }
        System.out.println();

    }
}