/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Calculate Factorial using Recursion
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Factorial.*/
public final class Factorial {
/**Main Method.*/
    private Factorial() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number:");
        int number1 = scan.nextInt();
        System.out.println("Factorial : " + fact(number1));
    }
    /**
     * { Calculates Factorial in recursive way. }
     *
     * @param      number  The number
     *
     * @return     { long value }
     */
    public static long fact(final int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * fact(number - 1);
        }
    }
}
