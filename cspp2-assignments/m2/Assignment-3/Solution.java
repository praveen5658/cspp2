/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Calculate power
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution.*/
public final class Solution {
/**Calling Constructor.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
     * { Calculate power }.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { power value as double }
     */
    public static long power(final int base, final int exponent) {
        final int num = 1;
        if (exponent == 0) {
            return num;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}


