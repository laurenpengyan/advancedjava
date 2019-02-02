import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BankMain {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(2, 2, new BigDecimal(200.0), new BigDecimal("0.01"), new BigDecimal(35.0));

        // M3 USING BUILDER
        // Direct SavingAccountBuilder how to build SavingAccount
        SavingsAccount.Builder savingAccountBuilder = new SavingsAccount.Builder();
        savingAccountBuilder.setCustomerId(2).setAccountId(3).setBalance(new BigDecimal("500")).setInterestRate(new BigDecimal("0.03"));
        savingAccountBuilder.setMonthlyWithdrawalLimits(2);

        // M3 USING BUILDER
        // Build a saving account
        SavingsAccount savingsAccount = new SavingsAccount(savingAccountBuilder);

        CDAccount cdAccount = new CDAccount(2, 4, new BigDecimal(1000.0), new BigDecimal("0.05"), 12);

        List<Account> accounts = new ArrayList<>();

        accounts.add(checkingAccount);
        accounts.add(savingsAccount);
        accounts.add(cdAccount);

        for (Account a : accounts) {
            System.out.println(a.toString());
        }

        System.out.println();

        savingsAccount.deposit(new BigDecimal(150));

        System.out.println();

        System.out.println("Checking account #" + checkingAccount.getAccountId() + " balance is: $" + checkingAccount.getBalance());
        checkingAccount.withdrawal(new BigDecimal(75));
        checkingAccount.transfer(savingsAccount, new BigDecimal(25));
        checkingAccount.openCheck("2018-2-1", "Jane", new BigDecimal(10000), "bought used car");
        checkingAccount.openCheck("2018-2-2", "Tommy", new BigDecimal(10), "bought food");
        savingsAccount.withdrawal(new BigDecimal(5.00));
        savingsAccount.withdrawal(new BigDecimal(1.00));
        savingsAccount.withdrawal(new BigDecimal(2.00));
        cdAccount.saveToCD(2000, 12);

        System.out.println("Checking account balance is: $" + checkingAccount.getBalance());
        System.out.println();

        for (Account a : accounts) {
            if (a instanceof CDAccount) {
                System.out.println("CDAccount: " + a.getAccountId() + " Default maturity period months: " + ((CDAccount) a).getDefaultMaturityPeriodMonths());
            } else if (a instanceof SavingsAccount) {
                System.out.println("SavingsAccount: " + a.getAccountId() + " Is Monthly Withdrawal Limit Reached: " + ((SavingsAccount) a).isMontlyWithdrawalLimitReached());
            }
        }

        System.out.println();


        // Sort accounts
        Collections.sort(accounts);
        for (Account a : accounts) {
            System.out.println(a.toString());
        }

        System.out.println();


        // M2 HOMEWORK ENUM USE
        for (Account a : accounts) {
            if (a instanceof CheckingAccount) {
                CheckingAccount c = (CheckingAccount) a;
                CheckingAccountType checkingAccountType = c.getCheckingAccountType();
                System.out.println("Checking account #" + c.getAccountId() + " accountType=" + checkingAccountType + " defaultMonthlyFee=" + checkingAccountType.getDefaultMonthlyFee());
            }
        }

    }

    // move this code to main method
    private static void factoryExample() {
        // M3 USING FACTORY METHOD
        AccountFactory checkingAccountFactory = new CheckingAccountFactory();

        Account checkingAccount1 = checkingAccountFactory.createAccount(5, 9, new BigDecimal(200.0), new BigDecimal("0.01"), new BigDecimal(35.0));
        Account checkingAccount2 = checkingAccountFactory.createAccount(6, 10, new BigDecimal(200.0), new BigDecimal("0.01"), new BigDecimal(35.0));

    }
}
