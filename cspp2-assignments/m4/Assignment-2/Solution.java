/**
    * Autor : Praveen
    * Date : 30-08-2018
    * Array addition of Matrices
*/
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
     * {Scanner}.
     */
    private static Scanner sc = new Scanner(System.in);
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        String str1 = sc.nextLine();
        String[] firstinput = str1.split(" ", 2);
        int m1 = Integer.parseInt(firstinput[0]);
        int n1 = Integer.parseInt(firstinput[1]);
        int[][] arr1 = readinput(m1, n1);
        String str2 = sc.nextLine();
        String[] firstinput1 = str2.split(" ", 2);
        int m2 = Integer.parseInt(firstinput1[0]);
        int n2 = Integer.parseInt(firstinput1[1]);
        if (m1 == m1 && n1 == n2) {
            int[][] arr2 = readinput(m2, n2);
            int[][] farr = addition(arr1, arr2, m1, n1);
            printing(farr, m1, n1);
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * { For reading input }.
     *
     * @param      m1    The m 1
     * @param      n1    The n 1
     *
     * @return     { array }.
     */
    public static int[][] readinput(final int m1, final int n1) {
        int[][] arr = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            String st = sc.nextLine();
            String[] firstinput = st.split(" ", n1);
            for (int j = 0; j < n1; j++) {
                arr[i][j] = Integer.parseInt(firstinput[j]);
            }
        }
        return arr;
    }
    /**
     * { addition }.
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     * @param      m1    The m 1
     * @param      n1    The n 1
     *
     * @return     { array }.
     */
    public static int[][] addition(final int[][] arr1,
        final int[][] arr2, final int m1, final int n1) {
        int[][] farr = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                farr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return farr;
    }
    /**
     * { Printing }.
     *
     * @param      farr  The farr
     * @param      m1    The m 1
     * @param      n1    The n 1
     */
    public static void printing(final int[][] farr, final int m1,
        final int n1) {
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1 - 1; j++) {
                System.out.print(farr[i][j] + " ");
            }
            System.out.print(farr[i][n1 - 1]);
            System.out.print("\n");
        }
    }
}

