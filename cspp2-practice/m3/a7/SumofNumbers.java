/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Calculates Sum of n natural numbers
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is SumofNumbers class.*/
public final class SumofNumbers {
/**Main Method.*/
    private SumofNumbers() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number n ");
        long num = scan.nextLong();
        long sumvalue = 0;
        for (int loop = 1; loop <= num; loop++) {
            sumvalue += loop;
        }
        System.out.println("Sum of " + num + " natural numbers is "
            + sumvalue);
    }
}
