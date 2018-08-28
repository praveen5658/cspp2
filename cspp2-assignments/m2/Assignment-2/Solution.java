/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Calculate roots for Quadratic Equation
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
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
     * { Compute roots for Quadratic equation }.
     *
     * @param      a     { an input }
     * @param      b     { an input }
     * @param      c     { an input }
     */
    public static void rootsOfQuadraticEquation(final int a,
        final int b, final int c) {
        final int num = 4;
        final int num1 = 2;
        double result1 = (-b + Math.sqrt((b * b) - num * a * c))
            / (num1 * a);
        double result2 = (-b - Math.sqrt((b * b) - num * a * c))
            / (num1 * a);
        System.out.println(result1 + " " + result2);
    }
}
