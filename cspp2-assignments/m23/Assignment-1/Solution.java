import java.util.Scanner;
import java.io.*;
public class Solution
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		File dir = new File(input);
		File[] files = dir.listFiles();
		if (files.length == 0) {
			System.out.println("empty directory");
		}
		else {
			Distance map1;
			Distance map2;
			double ans;
			for (File firstfile : files) {
				map1 = new Distance(firstfile);
				for (File secondfile : files) {
					map2 = new Distance(secondfile);
					ans = map1.angle(map2.getMap());
					System.out.print(ans + "\t");
				}
				System.out.print("\n");
			}
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
	}
}