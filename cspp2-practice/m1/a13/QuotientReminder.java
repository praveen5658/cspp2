/**
    * Autor : Praveen
    * Date : 28-08-2018
    * Calculate Reminder and Quotient
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is HelloWorld Class.*/
public final class QuotientReminder {
/**Main Method.*/
    private QuotientReminder() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter two number to Calculate");
            System.out.println(" Quotient and Reminder: ");
            int number1 = scan.nextInt();
            int number2 = scan.nextInt();
            int quotient = number1 / number2;
            System.out.println("Quotient : " + quotient);
            int reminder = number1 % number2;
            System.out.println("Reminder: " + reminder);
        } catch (Exception e) {
            System.out.println("Should Enter Integers only");
        }
    }
}
