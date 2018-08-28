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
public final class BiggerEqualSmaller {
/**Main Method.*/
    private BiggerEqualSmaller() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two integers :");
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();
        if (number1 == number2) {
            System.out.println("Equal");
        } else if (number1 > number2) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller");
        }
    }
}
