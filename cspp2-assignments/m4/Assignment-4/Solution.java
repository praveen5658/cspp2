/**
    * Autor : Praveen
    * Date : 30-08-2018
    * Array Reverse of String
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution class.*/
public final class Solution {
    /**Reverse of string.*/
    private Solution() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { reverse string }.
     *
     * @param      s     { string }.
     *
     * @return     { string }.
     */
    public static String reverseString(final String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        str = str.reverse();
        return str.toString();
    }
}
