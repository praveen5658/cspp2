/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Printing Converting Degrees to Fahrenheit
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
        double degreesCelsius = scan.nextDouble();
        System.out.println(
            calculateFromDegreesToFarenheit(degreesCelsius));
    }
    /**
     * { Converts Degree to Fahrenheit}.
     * @return tag
     * @param degreesCelsius as input
     */
    public static double calculateFromDegreesToFarenheit(
        final double degreesCelsius) {
        final double mulnum = 1.8;
        final int addnum = 32;
        return ((mulnum * degreesCelsius) + addnum);
    }
}
