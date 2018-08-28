/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Calculate Area of Circle
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Area of a Circle class.*/
public final class AreaofCircle {
/**Main Method.*/
    private AreaofCircle() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter radius :");
        double radius = scan.nextDouble();
        System.out.println(areaofcircle(radius));
    }
    /**
     * { pi value.}.
     *
     * @return     { returns pi value. }
     */
    public static double pi() {
        final double pi = 3.14;
        return pi;
    }
    /**
     * { Calculates Arwa of Circle. }
     *
     * @param      radius  The radius
     *
     * @return     { Area.}
     */
    public static double areaofcircle(final double radius) {
        return (pi() * radius * radius);
    }
}
