import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    Private Value.
    */
    private int size;
    /**
    Private Value.
    */
    private int[] set;
    /**
    Constructs Set.
    */
    protected Set() {
        final int ten = 10;
        size = 0;
        set = new int[ten];
    }
    /**
     * { Size function }.
     *
     * @return     { Integer }.
     */
    public int size() {
        return size;
    }
    /**
     * { Checks whether item contains or not }.
     *
     * @param      item  The item
     *
     * @return     { Boolean }.
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        } else {
            String st = new String("{");
            int i = 0;
            for (i = 0; i < size - 1; i++) {
                st += Integer.toString(set[i]) + ", ";
            }
            st += Integer.toString(set[i]) + "}";
            return st;
        }
    }
    /**
     * { Adds Single item to the set }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
    }
    /**
     * { Adds array of elements to set }.
     *
     * @param      arr   The arr
     */
    public void add(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }
    /**
     * { Converting to string }.
     *
     * @param      sample  The sample
     * @param      k       { Size }.
     *
     * @return     { String }.
     */
    public String converttostring(final int[] sample, final int k) {
        String st = new String("{");
        int i = 0;
        for (i = 0; i < k - 1; i++) {
            st += Integer.toString(sample[i]) + ", ";
        }
        st += Integer.toString(sample[i]) + "}";
        return st;
    }
    /**
     * { Intersection }.
     *
     * @param      other  The other
     *
     * @return     { String }.
     */
    public String intersection(final Set other) {
        if (size == 0 || other.size == 0) {
            return "{}";
        } else {
            final int ten = 10;
            int[] sample = new int[ten];
            int k = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < other.size; j++) {
                    if (set[i] == other.set[j]) {
                        sample[k] = set[i];
                        k++;
                        break;
                    }
                }
            }
            if (k == 0) {
                return "{}";
            } else {
                String st = converttostring(sample, k);
                return st;
            }
        }
    }
    /**
     * { RetainAll }.
     *
     * @param      arr   The arr
     *
     * @return     { String }.
     */
    public String retainAll(final int[] arr) {
        if (size == 0 || arr.length == 0) {
            return "{}";
        } else {
            final int ten = 10;
            int[] sample = new int[ten];
            int k = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (set[i] == arr[j]) {
                        sample[k] = set[i];
                        k++;
                        break;
                    }
                }
            }
            if (k == 0) {
                return "{}";
            } else {
                String st = converttostring(sample, k);
                return st;
            }
        }
    }
    /**
     * { Cartesian Product }.
     *
     * @param      other  The other
     *
     * @return     { IntegerArray }.
     */
    public int[][] cartesianProduct(final Set other) {
        if (size == 0 || other.size == 0) {
            return null;
        } else {
            int[][] arr = new int[size * other.size][2];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < other.size; j++) {
                    arr[(other.size * i) + j][0] = set[i];
                    arr[(other.size * i) + j][1] = other.set[j];
                }
            }
            return arr;
        }
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(
            new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            //invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(
                    s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(
                    Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}

