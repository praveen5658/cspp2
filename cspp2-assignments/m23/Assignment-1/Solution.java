import java.util.Scanner;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
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
						if (Math.round(ans * 100) > maxval && !firstfile.getName().equals(secondfile.getName())) {
							maxval = Math.round(ans * 100);
							file1 = firstfile.getName();
							file2 = secondfile.getName();
						}
						System.out.print(Math.round(ans * 100) + "\t\t");
					}
					System.out.print("\n");
				}
				System.out.println("Maximum similarity is between "+file1+" and "+file2);
				// Distance map1 = new Distance("To be or not to be");
				// System.out.println(map1.getNumOfLines() + " lines  ");
				// System.out.println(map1.getNumOfWords() + " words  ");
				// System.out.println(map1.getNumOfDistinctWords() + " distinct words");
				// System.out.println(map1.norm() + " Euclidean norm\n");

				// Distance map2 = new Distance("Doubt truth to be a liar");
				// System.out.println(map2.getNumOfLines() + " lines  ");
				// System.out.println(map2.getNumOfWords() + " words  ");
				// System.out.println(map2.getNumOfDistinctWords() + " distinct words");
				// System.out.println(map2.norm() + " Euclidean norm\n");

				// System.out.println(map1.innerProduct(map2.getMap()) + " inner product");
				// System.out.println(map1.angle(map2.getMap()) + " angle");
			}
		} catch (Exception e) {
			System.out.println("empty directory");
		}
	}
}