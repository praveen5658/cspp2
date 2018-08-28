/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Converts Degrees to Fahrenheit
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is HelloWorld Class.*/
public final class DegreesToFahrenheit {
/**Main Method.*/
    // final static int addnum = 32;
    // /** Static Constant.*/
    // final static double mulnum = 1.8;
    // /** Construcor call.*/
    private DegreesToFahrenheit() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        try {
            final int addnum = 32;
            final double mulnum = 1.8;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter one value to Convert");
            System.out.println(" Degree to Fahrenheit: ");
            float degree = scan.nextFloat();
            double fahrenheit = (mulnum * degree) + addnum;
            System.out.println("After covertion : " + fahrenheit);
        } catch (Exception e) {
            System.out.println("Should Enter Integers or Floats only");
        }
    }
}
