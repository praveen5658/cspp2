/**
    * Autor : Praveen
    * Date : 30-08-2018
    * Array Implementation of Strings
*/
/**
    * Importing Scanner Class.
*/
import java.util.Scanner;
/**This is Concatinate class.*/
public final class Concatinate {
    /**Main Method.*/
    private Concatinate() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("Hello " + str + "!");
    }
}
