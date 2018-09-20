/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * { item_description }.
 */
import java.io.*;
/**
 * Class for solution.
 */
public class Solution {
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
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            File dir = new File(input);
            File[] files = dir.listFiles();
            if (files.length == 0) {
                System.out.println("empty directory");
            } else {
                Distance map1;
                Distance map2;
                double ans;
                long maxval = 0;
                String file1 = null;
                String file2 = null;
                System.out.print("\t\t");
                for (int i = 0; i < files.length - 1; i++) {
                    System.out.print(files[i].getName() + "\t");
                }
                System.out.print(files[files.length - 1].getName());
                System.out.println();
                for (File firstfile : files) {
                    System.out.print(firstfile.getName() + "\t");
                    map1 = new Distance(firstfile);
                    for (File secondfile : files) {
                        map2 = new Distance(secondfile);
                        ans = map1.angle(map2.getMap());
                        if (Math.round(ans * 100) > maxval
                                && !firstfile.getName().equals(
                                    secondfile.getName())) {
                            maxval = Math.round(ans * 100);
                            file1 = firstfile.getName();
                            file2 = secondfile.getName();
                        }
                        System.out.print(Math.round(ans * 100) + "\t\t");
                    }
                    System.out.print("\n");
                }
                System.out.println("Maximum similarity is between "
                                   + file1 + " and " + file2);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
}