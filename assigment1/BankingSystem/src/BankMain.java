
public class BankMain {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(2, 2, 200.0, .01, 35.0);
        SavingsAccount savingsAccount = new SavingsAccount(2, 3, 500.0, .5, 5);
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
        System.out.println("Checking account balance is: $" + checkingAccount.getBalance());
        System.out.println();

        for (Account a : accounts) {
            if (a instanceof CDAccount)
                System.out.println("Maturity period months: " + ((CDAccount) a).getMaturityPeriodMonths());
        }
    }

}
