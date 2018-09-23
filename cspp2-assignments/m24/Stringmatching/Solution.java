/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * { item_description }.
 */
import java.io.File;
/**
 * Class for hello solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan1 = new Scanner(System.in);
            String input = scan1.nextLine();
            File dir = new File(input);
            File[] files = dir.listFiles();
            int space = 0;
            final int hundred = 100;
            if (files.length == 0) {
                System.out.println("Empty Directory");
            } else {
                double maxval = 0.0;
                String file1 = null;
                String file2 = null;
                System.out.print("             ");
                for (int i = 0; i < files.length - 1; i++) {
                    System.out.print(files[i].getName()
                                     + "    ");
                }
                System.out.print(
                    files[files.length - 1].getName()
                    + " \n");
                String input1 = "";
                String input2 = "";
                String sub = "";
                String finalsub = "";
                double ans = 0.0;
                Scanner scan;
                int nr = 0;
                int dr = 0;
                double[][] arr =
                    new double[files.length][files.length];
                for (int i = 0; i < files.length; i++) {
                    scan = new Scanner(files[i]);
                    input1 = "";
                    while (scan.hasNext()) {
                        input1 += scan.nextLine();
                    }
                    for (int j = 0; j < files.length; j++) {
                        scan = new Scanner(files[j]);
                        input2 = "";
                        while (scan.hasNext()) {
                            input2 += scan.nextLine();
                        }
                        finalsub = "";
                        for (int d = 0; d < input1.length(); d++) {
                            for (int f = d + 1; f <= input1.length(); f++) {
                                sub = input1.substring(d, f);
                                if (input2.contains(sub)) {
                                    if (finalsub.length() < sub.length()) {
                                        finalsub = sub;
                                    }
                                }
                            }
                        }
                        nr = finalsub.length() * 2;
                        dr = input1.length() + input2.length();
                        if (i != j) {
                            arr[i][j] = (double)
                                        Math.round((nr/(double)dr) * hundred);
                            if (maxval < arr[i][j]) {
                                maxval = arr[i][j];
                                file1 = files[i].getName();
                                file2 = files[j].getName();
                            }
                        } else {
                            final double hun = 100.0;
                            arr[i][j] = hun;
                        }
                    }
                }
                final int nine = 9;
                for (int i = 0; i < files.length - 1; i++) {
                    System.out.print(files[i].getName() + "    ");
                    for (int k = 0; k < files.length - 1; k++) {
                        space = String.valueOf(arr[i][k]).length();
                        space = nine - space;
                        for (int m = 0; m < space; m++) {
                            System.out.print(" ");
                        }
                        System.out.print(arr[i][k] + "    ");
                    }
                    space = String.valueOf(arr[i][files.length - 1]).length();
                    space = nine - space;
                    for (int m = 0; m < space; m++) {
                        System.out.print(" ");
                    }
                    System.out.print(arr[i][files.length - 1] + " \n");
                }
                System.out.print(files[files.length - 1].getName() + "    ");
                for (int k = 0; k < files.length - 1; k++) {
                    space = String.valueOf(arr[files.length - 1][k]).length();
                    space = nine - space;
                    for (int m = 0; m < space; m++) {
                        System.out.print(" ");
                    }
                    System.out.print(arr[files.length - 1][k] + "    ");
                }
                space = String.valueOf(
                            arr[files.length - 1][files.length - 1]).length();
                space = nine - space;
                for (int m = 0; m < space; m++) {
                    System.out.print(" ");
                }
                System.out.print(
                    arr[files.length - 1][files.length - 1] + " \n");
                System.out.println("Maximum similarity is between "
                                   + file1 + " and " + file2);
            }
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
    }
}
