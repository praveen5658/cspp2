/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Array Implementation of Arrays
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Average class.*/
public final class Average {
    /**Main Method.*/
    private Average() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in array n ");
        final int num = scan.nextInt();
        double sumvalue = 0.0;
        int[] arr = new int[num];
        for (int loop = 0; loop < num; loop++) {
            arr[loop] = scan.nextInt();
            sumvalue += arr[loop];
        }
        System.out.println(sumvalue / num);
    }
}
