import java.util.Arrays;

public class BankMain {

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(000002, 000002, 200.0, .01);
        SavingsAccount savingsAccount = new SavingsAccount(000002, 000003, 500.0, .5);
        CDAccount cdAccount = new CDAccount(000002, 000004, 1000.0, 1.5, 12);

        Account[] accounts = {checkingAccount, cdAccount, savingsAccount};
        for (Account a : accounts){
            System.out.println(a.toString());
        }
        System.out.println();

        savingsAccount.deposit(150);
        System.out.println();

        System.out.println("Checking account balance is: $" + checkingAccount.getBalance());
        checkingAccount.withdrawal(75);
        checkingAccount.transfer(000002, 25);
        System.out.println("Checking account balance is: $" + checkingAccount.getBalance());
        System.out.println();

        for (Account a : accounts){
            if (a instanceof CDAccount)
                System.out.println("Maturity period months: " + ((CDAccount) a).getMaturityPeriodMonths());
        }
        System.out.println();

        for (Account a : accounts){
            System.out.println(a.toString());
        }
        System.out.println();

        Arrays.sort(accounts);

        for (Account a : accounts){
            System.out.println(a.toString());
        }
        System.out.println();

        // M2 HOMEWORK ENUM USE
        CheckingAccount.CheckingAccountCategory checkingAccountCategory = CheckingAccount.CheckingAccountCategory.PERSONAL;
        checkingAccountCategory.getCategory();
    }

}
