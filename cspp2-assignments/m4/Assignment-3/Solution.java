/**
    * Autor : Praveen
    * Date : 30-08-2018
    * Converts Binary to Decimal
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Solution class.*/
public final class Solution {
	/**Converts Binary to Decimal.*/
	private Solution() {
		super();
	}
	/**
	@param args
	Main .*/
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			long res = binaryToDecimal(s); 
			System.out.println(res);
		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      s     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public static long binaryToDecimal(final String s) {
		int len = s.length();
		int sumvalue = 0;
		int j = 0;
		for (int i = len - 1; i >= 0; i--) {
			sumvalue += Character.getNumericValue(s.charAt(i)) * (Math.pow(2, j));
			j++;
		}
		return sumvalue;
	}
}
