import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = scan.nextLine();

        try {
            //reinitializing scan to read from file
            scan = new Scanner(new File(filename));
            //initializing sum to 0
            int sum = 0;

            while (scan.hasNextInt()) {
                //reading integer
                int numbers = scan.nextInt();
                //checking if numbers is negative
                if (numbers < 0) {
                    //throwing negative number exception
                    throw new NegativeNumberException("Negative number found: " + numbers);
                }
                sum += numbers;
            }
            scan.close();
            System.out.println("Sum of all numbers is " + sum);
        } catch (FileNotFoundException e) {
            //file not found
            System.err.println(e.getMessage());
        } catch (NegativeNumberException e) {
            //negative number found in the file
            System.err.println(e.getMessage());
        }
    }
}

/**
 * class to represent an Exception when a negative value is found
 */

class NegativeNumberException extends Exception {
    public NegativeNumberException(String str) {
        //passing error message to super class constructor
        super(str);
    }
}

