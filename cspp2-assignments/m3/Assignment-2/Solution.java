/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Prints number of 7;s upto yhe given number
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution class.*/
public final class Solution {
/** Fill the main function to print the number of 7's between 1 to n.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int num = scan.nextInt();
        final int ten = 10;
        final int zero = 0;
        final int seven = 7;
        int count = 0;
        for (int loop = 1; loop <= num; loop++) {
            int number = loop;
            while (number != zero) {
                if (number % ten == seven) {
                    count += 1;
                }
                number /= ten;
            }
        }
        System.out.println(count);
    }
}

