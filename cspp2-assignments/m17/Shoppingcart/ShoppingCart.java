/**
 * { Item_description }.
 */
import java.util.Scanner;
/**
 * { Item_description }.
 */
import java.util.Arrays;
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
     * @param      item1  The Item 1
     */
    public void addtoCatalog(final Item item1) {
        if (catalogsize == catalog.length) {
            resize();
        }
        catalog[catalogsize++] = item1;
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
     * @param      item1  The Item 1
     */
    public void addtoCart(final Item item1) {
        int k = 0;
        final int z = 0;
        if (cartsize == cart.length) {
            resize();
        }
        int l = 0;
        for (int j = 0; j < cartsize; j++) {
            if (cart[j].getitemName().equals(item1.getitemName())) {
                cart[j].itemQuantity += item1.itemQuantity;
                l++;
                break;
            }
        }
        if (l == z) {
            for (int i = 0; i < catalogsize; i++) {
                if (catalog[i].getitemName().equals(
                            item1.getitemName())
                        && (catalog[i].itemQuantity
                            > item1.itemQuantity)) {
                    cart[cartsize++] = item1;
                    catalog[i].itemQuantity -= item1.itemQuantity;
                    break;
                } else if (catalog[i].getitemName().equals(
                               item1.getitemName())
                           && (catalog[i].itemQuantity
                               == item1.itemQuantity)) {
                    cart[cartsize++] = item1;
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
     * @param      item1  The Item 1
     */
    public void removefromCart(final Item item1) {
        // Item[] sample = new Item[cartsize-1];
        for (int i = 0; i < cartsize; i++) {
            if ((cart[i].getitemName().equals(item1.getitemName()))) {
                if (cart[i].itemQuantity >= item1.itemQuantity) {
                    cart[i].itemQuantity -= item1.itemQuantity;
                    if (cart[i].itemQuantity == 0) {
                        removeelementfromCart(item1);
                    }
                    break;
                }
            }
        }
        // cart = sample.clone();
        // cartsize -= 1;
        for (int k = 0; k < catalogsize; k++) {
            if (catalog[k].getitemName().equals(item1.getitemName())) {
                catalog[k].itemQuantity += item1.itemQuantity;
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      item1  The Item 1
     */
    public void removeelementfromCart(final Item item1) {
        Item[] sample = new Item[cartsize - 1];
        for (int i = 0, j = 0; i < cartsize; i++) {
            if (!(cart[i].getitemName().equals(item1.getitemName()))) {
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
     * @param      item1  The Item 1
     */
    public void removefromCatalog(final Item item1) {
        Item[] sample = new Item[catalogsize - 1];
        for (int i = 0, j = 0; i < catalogsize; i++) {
            if (!(catalog[i].equals(item1))) {
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
