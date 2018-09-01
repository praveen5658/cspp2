import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Praveen
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * { Checks whether number is prime or not }.
     *
     * @param      i     { number }.
     *
     * @return     { boolean value }.
     */
    public static boolean isprime(final int i) {
        final int zero = 0;
        int cou = 0;
        final int one = 1;
        for (int j = 2; j <= i; j++) {
            if (i % j == zero) {
                cou += 1;
            }
        }
        if (cou == one) {
            return false;
        }
        return true;
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        final int two = 2;
        final int zero = 0;
        for (int i = 2; i < n; i++) {
            boolean value = isprime(i);
            if (value) {
                if (i % two != zero) {
                    System.out.println(i);
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
