/**
    * Autor : Praveen
    * Date : 29-08-2018
    * Convert to While loop
*/
/**This is ConvertoWhile class.*/
public final class ConvertoWhile {
/**Main Method.*/
    private ConvertoWhile() {
        super();
    }
    /**
    @param args
    Main .*/
    public static void main(final String[] args) {
        int loop = 2;
        final int num = 10;
        while (loop <= num) {
            System.out.println(loop);
            loop += 2;
        }
        System.out.println("GoodBye!");
    }
}
