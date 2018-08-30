/**
    * Autor : Praveen
    * Date : 30-08-2018
    * Array Implementation of Strings
*/
/**
 * { Importing Arrays class }.
 */
import java.util.Arrays;
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution class.*/
public final class Solution {
    /**function to print maximum of given array.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[n - 1]);
    }
}

