/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Array Implementation of Arrays
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is FirstLast6 class.*/
public final class FirstLast6 {
    /**Main Method.*/
    private FirstLast6() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in array n ");
        final int num = scan.nextInt();
        final int six = 6;
        int[] arr = new int[num];
        for (int loop = 0; loop < num; loop++) {
            arr[loop] = scan.nextInt();
        }
        if (arr[0] == six || arr[num - 1] == six) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
