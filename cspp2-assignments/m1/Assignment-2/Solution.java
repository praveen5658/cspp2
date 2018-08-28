/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Printing Name and Roll NUmber
*/
import java.util.Scanner;
/**
 * { Class Solution.}.
 */
public final class Solution {
/**Main Method.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        System.out.println(areaOfTriangle(base, height));
    }
    /**
     * { Claculates Area of a Triangle.}.
     * @return tag
     * @param base as input
     * @param height as input
     */
    public static double areaOfTriangle(final int base, final int height) {
        final double half = 0.5;
        return (half * base * height);
    }
}
