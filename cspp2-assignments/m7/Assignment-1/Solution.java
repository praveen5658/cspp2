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
     * @param      input1  The input 1
     */
    InputValidator(final String input1) {
        this.input = input1;
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
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
