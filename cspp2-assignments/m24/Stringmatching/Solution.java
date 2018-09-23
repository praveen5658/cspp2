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
            final int hundred = 100;
            if (files.length == 0) {
                System.out.println("empty directory");
            } else {
                long maxval = 0;
                String file1 = null;
                String file2 = null;
                System.out.print("         ");
                for (int i = 0; i < files.length - 1; i++) {
                    System.out.print(files[i].getName() + "    ");
                }
                System.out.print(files[files.length - 1].getName() + " \n");
                // for (File firstfile : files) {
                //     System.out.print(firstfile.getName() + "\t");
                //     map1 = new Distance(firstfile);
                //     for (File secondfile : files) {
                //         map2 = new Distance(secondfile);
                //         ans = map1.angle(map2.getMap());
                //         if (Math.round(ans * hundred) > maxval
                //                 && !firstfile.getName().equals(
                //                     secondfile.getName())) {
                //             maxval = Math.round(ans * hundred);
                //             file1 = firstfile.getName();
                //             file2 = secondfile.getName();
                //         }
                //         System.out.print(Math.round(ans * hundred) + "\t\t");
                //     }
                //     System.out.print("\n");
                // }
                String input1 = "";
                String input2 = "";
                String sub = "";
                String finalsub = "";
                double ans = 0.0;
                Scanner scan;
                double[][] arr = new double[files.length][files.length];
                for (int i = 0; i< files.length;i++) {
                	scan = new Scanner(files[i]);
                	input1 = "";
                	while (scan.hasNext()) {
                		input1 += scan.nextLine(); 
                	}
                	for (int j = 0; j < files.length; j ++) {
                		scan = new Scanner(files[j]);
                		input2 = "";
                		while (scan.hasNext()) {
                			input2 += scan.nextLine();
                		}
                		finalsub = "";
                		for (int d = 0;d<input1.length();d++) {
                			for (int f = d+1; f <= input1.length(); f++) {
                				sub = input1.substring(d, f);
                				// System.out.println(sub);
                				if (input2.contains(sub)) {
                					if (finalsub.length() < sub.length()) {
                						finalsub = sub;
                						// System.out.println(finalsub);
                					}
                				}
                			}
                		}
                		arr[i][j] = (double)(((finalsub.length() * 2)/(input1.length() + input2.length())) * 100);
                		// System.out.println(finalsub);
                		// System.out.println(input1);
                		// System.out.println(finalsub.length());
                		// System.out.println(input1.length());
                		// System.out.println(input2.length());
                		System.out.println(arr[i][j]);
                	}
                }
                // System.out.println("Maximum similarity is between "
                //                    + file1 + " and " + file2);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
}
