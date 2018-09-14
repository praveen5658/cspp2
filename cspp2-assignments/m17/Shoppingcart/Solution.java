/**
 * { Item_description }.
 */
import java.util.Scanner;
/**
 * { Item_description }.
 */
import java.util.Arrays;
/**
 * Class for Item.
 */
class Item {
    /**
     * { var_description }.
     */
    private String itemName;
    /**
     * { var_description }.
     */
    protected int itemQuantity;
    /**
     * { var_description }.
     */
    public float itemUnitPrice;
    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      quantity  The quantity
     * @param      price     The price
     */
    Item(final String name, final int quantity, final float price) {
        itemName = name;
        itemQuantity = quantity;
        itemUnitPrice = price;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String getitemName() {
        return itemName;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int getitemQuantity() {
        return itemQuantity;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public float getitemUnitPrice() {
        return itemUnitPrice;
    }
    /**
     * { function_description }.
     *
     * @param      quan  The quan
     *
     * @return     { description_of_the_return_value }.
     */
    public String printString(final float quan) {
        String s = itemName + " " + String.valueOf(
                       itemQuantity) + " " + String.valueOf(quan);
        return s;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        final float zero = 0.0f;
        String s = "";
        if (itemUnitPrice != zero) {
            s = itemName + " " + String.valueOf(
                    itemQuantity) + " " + String.valueOf(itemUnitPrice);
        } else {
            s = itemName + " " + String.valueOf(
                    itemQuantity);
        }
        return s;
    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private Item[] catalog;
    /**
     * { var_description }.
     */
    private Item[] cart;
    /**
     * { var_description }.
     */
    private int catalogsize;
    /**
     * { var_description }.
     */
    private int cartsize;
    /**
     * { var_description }.
     */
    private int coupon;
    /**
     * Constructs the object.
     */
    protected ShoppingCart() {
        final int ten = 10;
        catalog = new Item[ten];
        cart = new Item[ten];
        catalogsize = 0;
        cartsize = 0;
        coupon = 0;
    }
    /**
     * { function_description }.
     */
    public void resize() {
        catalog = Arrays.copyOf(catalog, catalogsize + 1);
        cart = Arrays.copyOf(cart, cartsize + 1);
    }
    /**
     * { function_description }.
     *
     * @param      Item1  The Item 1
     */
    public void addtoCatalog(final Item Item1) {
        if (catalogsize == catalog.length) {
            resize();
        }
        catalog[catalogsize++] = Item1;
    }
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalogsize; i++) {
            System.out.println(catalog[i]);
        }
    }
    /**
     * { function_description }.
     *
     * @param      Item1  The Item 1
     */
    public void addtoCart(final Item Item1) {
        int k = 0;
        final int z = 0;
        if (cartsize == cart.length) {
            resize();
        }
        int l = 0;
        for (int j = 0; j < cartsize; j++) {
            if (cart[j].getitemName().equals(Item1.getitemName())) {
                cart[j].itemQuantity += Item1.itemQuantity;
                l++;
                break;
            }
        }
        if (l == z) {
            for (int i = 0; i < catalogsize; i++) {
                if (catalog[i].getitemName().equals(
                            Item1.getitemName()) &&
                        (catalog[i].itemQuantity >
                         Item1.itemQuantity)) {
                    cart[cartsize++] = Item1;
                    catalog[i].itemQuantity -= Item1.itemQuantity;
                    break;
                } else if (catalog[i].getitemName().equals(
                               Item1.getitemName()) &&
                           (catalog[i].itemQuantity ==
                            Item1.itemQuantity)) {
                    cart[cartsize++] = Item1;
                    removefromCatalog(catalog[i]);
                    break;
                } else {
                    k++;
                }
            }
        }
    }
    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartsize; i++) {
            System.out.println(cart[i]);
        }
    }
    /**
     * { function_description }.
     */
    public void printCart() {
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catalogsize; j++) {
                if (cart[i].getitemName().equals(
                            catalog[j].getitemName())) {
                    System.out.println(cart[i].printString(
                                           catalog[j].itemUnitPrice));
                }
            }
        }
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public float getTotalAmount() {
        float f = 0.0f;
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catalogsize; j++) {
                if (cart[i].getitemName().equals(
                            catalog[j].getitemName())) {
                    f += cart[i].itemQuantity * catalog[j].itemUnitPrice;
                    break;
                }
            }
        }
        return f;
    }
    /**
     * { function_description }.
     *
     * @param      Item1  The Item 1
     */
    public void removefromCart(final Item Item1) {
        // Item[] sample = new Item[cartsize-1];
        for (int i = 0; i < cartsize; i++) {
            if ((cart[i].getitemName().equals(Item1.getitemName()))) {
                if (cart[i].itemQuantity >= Item1.itemQuantity) {
                    cart[i].itemQuantity -= Item1.itemQuantity;
                    if (cart[i].itemQuantity == 0) {
                        removeelementfromCart(Item1);
                    }
                    break;
                }
            }
        }
        // cart = sample.clone();
        // cartsize -= 1;
        for (int k = 0; k < catalogsize; k++) {
            if (catalog[k].getitemName().equals(Item1.getitemName())) {
                catalog[k].itemQuantity += Item1.itemQuantity;
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      Item1  The Item 1
     */
    public void removeelementfromCart(Item Item1) {
        Item[] sample = new Item[cartsize - 1];
        for (int i = 0, j = 0; i < cartsize; i++) {
            if (!(cart[i].getitemName().equals(Item1.getitemName()))) {
                sample[j] = cart[i];
                j++;
            }
        }
        cart = sample.clone();
        cartsize -= 1;
    }
    /**
     * { function_description }.
     *
     * @param      Item1  The Item 1
     */
    public void removefromCatalog(Item Item1) {
        Item[] sample = new Item[catalogsize - 1];
        for (int i = 0, j = 0; i < catalogsize; i++) {
            if (!(catalog[i].equals(Item1))) {
                sample[j] = catalog[i];
                j++;
            }
        }
        catalog = sample.clone();
        catalogsize -= 1;
    }
    /**
     * { function_description }.
     *
     * @param      disc  The disc
     */
    public void applyCoupon(final int disc) {
        if (coupon < disc) {
            coupon = disc;
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public float getpaybleAmount() {
        final float hun = 100.0f;
        final float po = 1.15f;
        if (coupon == 0) {
            return (getTotalAmount() * po);
        }
        return ((getTotalAmount() - (getTotalAmount() * (
                                         coupon / hun))) * po);
    }
    /**
     * { function_description }.
     */
    public void printInvoice() {
        final float hun = 100.0f;
        final float po = 0.15f;
        final int ze = 0;
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        printCart();
        System.out.println("Total:" + getTotalAmount());
        if (coupon == ze) {
            System.out.println("Disc%:0.0");
        } else {
            System.out.println("Disc%:" + (getTotalAmount() * (
                                               coupon / hun)));
        }
        if (coupon == ze) {
            System.out.println("Tax:" + (getTotalAmount() * po));
        } else {
            System.out.printf("Tax:%.1f\n", ((
                                                 getTotalAmount() - (
                                                         getTotalAmount() * (
                                                                 coupon / hun)))
                                             * po));
        }
        System.out.println("Payable amount: " + getpaybleAmount());
    }
}
/**
 * { Item_description }.
 */
public final class Solution {
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
                if (disc == ten || disc == twenty ||
                        disc == thirty || disc == fifty) {
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
