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
    public int itemQuantity;
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
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

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