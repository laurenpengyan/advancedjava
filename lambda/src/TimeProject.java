import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class TimeProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your day of birth:");
        int day = sc.nextInt();

        System.out.println("Enter your month of birth:");
        int month = sc.nextInt();

        System.out.println("Enter your year of birth:");
        int year = sc.nextInt();

        //stores the user input in LocalDate
        LocalDate l = LocalDate.of(year, month, day);
        System.out.println("Your birth date is : " + l);

        LocalDate now = LocalDate.now();        // Gets localDate

        Period diff = Period.between(l, now);    // Difference between the dates is calculated

        // Displays the current age using getYears,getMonths and getDays
        System.out.print("Your current age is : ");
        System.out.println(diff.getYears() + " years " + diff.getMonths() + " months " + diff.getDays() + " days ");


        LocalDate nextBDay = l.withYear(now.getYear()); //gets the current year

        // Calculates the difference between current date and the next birthday
        Period diffFornextBday = Period.between(now, nextBDay.plusYears(0));

        // Displays the days remaining for next birthday
        System.out.print("Days remaining until your next birthday : ");
        System.out.println(diffFornextBday.getMonths() + " months " + diffFornextBday.getDays() + " days ");

    }
}