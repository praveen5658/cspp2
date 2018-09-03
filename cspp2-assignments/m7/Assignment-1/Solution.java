/**
 * { importing util package }.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { item_description }.
     */
    private String input;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        this.input = input;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean validateData() {
        final int six = 6;
        if (input.length() >= six) {
            return true;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { item_description }.
     */
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
