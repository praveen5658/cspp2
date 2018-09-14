/**
 * { Item_description }.
 */
import java.util.Scanner;
/**
 * { Item_description }.
 */
import java.util.Arrays;
/**
 * { Item_description }.
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
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        ShoppingCart sc = new ShoppingCart();
        for (int i = 0; i < testcases; i++) {
            String[] token = (scan.nextLine()).split(" ");
            switch (token[0]) {
            case "Item":
                String[] values = token[1].split(",");
                int quantity = Integer.parseInt(values[1]);
                float price = Float.parseFloat(values[2]);
                sc.addtoCatalog(new Item(values[0], quantity, price));
                break;
            case "catalog":
                sc.showCatalog();
                break;
            case "add":
                final float zero = 0.0f;
                values = token[1].split(",");
                quantity = Integer.parseInt(values[1]);
                sc.addtoCart(new Item(values[0], quantity, zero));
                break;
            case "show":
                sc.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + sc.getTotalAmount());
                break;
            case "remove":
                final float zero1 = 0.0f;
                values = token[1].split(",");
                quantity = Integer.parseInt(values[1]);
                sc.removefromCart(new Item(values[0], quantity, zero1));
                break;
            case "coupon":
                final int ten = 10;
                final int twenty = 20;
                final int thirty = 30;
                final int fifty = 50;
                final int three = 3;
                final int five = 5;
                int disc = Integer.parseInt(token[1].substring(three, five));
                if (disc == ten || disc == twenty
                        || disc == thirty || disc == fifty) {
                    sc.applyCoupon(disc);
                } else {
                    System.out.println("Invalid coupon");
                }
                break;
            case "payableAmount":
                System.out.println(
                    "Payable amount: " + sc.getpaybleAmount());
                break;
            case "print":
                sc.printInvoice();
                break;
            default :
                break;
            }
        }
    }
}
