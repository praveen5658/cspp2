/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Calculates GCD of 2 numbers
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution class.*/
public final class Solution {
/** Calculates GCD of 2 numbers.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int number = gcd(n1,n2);
        System.out.println(number);
    }
    /**
     * { Calculate GCD }.
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     { int as GCD }.
     */
    public static int gcd(int n1, int n2) {
        final int zero = 0;
        if (n1 % n2 == zero) {
            return n2;
        }
        else if (n2 % n1 == zero) {
            return n1;
        }
        else {
            int num1 = Math.min(n1, n2);
            int num2 = Math.max(n1, n2);
            return gcd(num1, num2 % num1);
        }
    }
}
