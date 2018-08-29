/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Prints pattern
  * 1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Pattern class.*/
public final class Pattern {
/**Main Method.*/
    private Pattern() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number n ");
        final int num = scan.nextInt();
        for (int loop = 1; loop <= num; loop++) {
            for (int loop1 = 1; loop1 <= loop; loop1++) {
                System.out.print(loop1 + " ");
            }
            System.out.println();
        }
    }
}
