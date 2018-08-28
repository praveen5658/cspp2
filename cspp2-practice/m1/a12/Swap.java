/**Importing Scanner Class.*/
import java.util.Scanner;
/**This is HelloWorld Class.*/
public final class Swap {
/**Main Method.*/
    private Swap() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two number to Swap: ");
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();
        System.out.println("Before Swapping : " + number1 + " " + number2);
        number2 = number1 + number2;
        number1 = number2 - number1;
        number2 = number2 - number1;
        System.out.println("After Swapping : " + number1 + " " + number2);
    }
}
