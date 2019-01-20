
public class BankMain {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(2, 2, 200.0, .01, 35.0);
        SavingsAccount savingsAccount = new SavingsAccount(2, 3, 500.0, .5, 2);
        CDAccount cdAccount = new CDAccount(2, 4, 1000.0, 1.5, 12);

        Account[] accounts = {checkingAccount, savingsAccount, cdAccount};
        for (Account a : accounts) {
            System.out.println(a.toString());
        }
        System.out.println();

        savingsAccount.deposit(150);
        System.out.println();

        System.out.println("Checking account balance is: $" + checkingAccount.getBalance());
        checkingAccount.withdrawal(75);
        checkingAccount.transfer(2, 25);
        checkingAccount.openCheck("2018-2-1", "Jane", 10000, "bought used car");
        checkingAccount.openCheck("2018-2-2", "Tommy", 10, "bought food");
        savingsAccount.withdrawal(5.00);
        savingsAccount.withdrawal(1.00);
        savingsAccount.withdrawal(2.00);
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
    }

}
