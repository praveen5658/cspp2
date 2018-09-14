import java.util.Scanner;
import java.util.Arrays;
class item {
    private String itemName;
    public int itemQuantity;
    public float itemUnitPrice;
    item(String name, int quantity, float price) {
        itemName = name;
        itemQuantity = quantity;
        itemUnitPrice = price;
    }
    public String getitemName() {
        return itemName;
    }
    public int getitemQuantity() {
        return itemQuantity;
    }
    public float getitemUnitPrice() {
        return itemUnitPrice;
    }
    public String printString(final float quan) {
        String s = itemName + " " + String.valueOf(
                       itemQuantity) + " " + String.valueOf(quan);
        return s;
    }
    public String toString() {
        String s = "";
        if (itemUnitPrice != 0.0) {
            s = itemName + " " + String.valueOf(
                    itemQuantity) + " " + String.valueOf(itemUnitPrice);
        } else {
            s = itemName + " " + String.valueOf(
                    itemQuantity);
        }
        return s;
    }
}


class ShoppingCart {
    private item[] catalog;
    private item[] cart;
    private int catalogsize;
    private int cartsize;
    private int coupon;
    ShoppingCart() {
        catalog = new item[10];
        cart = new item[10];
        catalogsize = 0;
        cartsize = 0;
        coupon = 0;
    }
    public void resize() {
        catalog = Arrays.copyOf(catalog, catalogsize + 1);
        cart = Arrays.copyOf(cart, cartsize + 1);
    }
    public void addtoCatalog(item item1) {
        if (catalogsize == catalog.length) {
            resize();
        }
        catalog[catalogsize++] = item1;
    }
    public void showCatalog() {
        for (int i = 0; i < catalogsize; i++) {
            System.out.println(catalog[i]);
        }
    }
    public void addtoCart(item item1) {
        int k = 0;
        if (cartsize == cart.length) {
            resize();
        }
        for (int i = 0; i < catalogsize; i++) {
            if (catalog[i].getitemName().equals(item1.getitemName()) &&
                    (catalog[i].itemQuantity > item1.itemQuantity)) {
                cart[cartsize++] = item1;
                catalog[i].itemQuantity -= item1.itemQuantity;
                break;
            } else if (catalog[i].getitemName().equals(item1.getitemName()) &&
                       (catalog[i].itemQuantity == item1.itemQuantity)) {
                cart[cartsize++] = item1;
                removefromCatalog(catalog[i]);
                break;
            } else {
                k++;
            }
        }
    }
    public void showCart() {
        for (int i = 0; i < cartsize; i++) {
            System.out.println(cart[i]);
        }
    }
    public void printCart() {
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catalogsize; j++) {
                if (cart[i].getitemName().equals(catalog[j].getitemName())) {
                    System.out.println(cart[i].printString(catalog[j].itemUnitPrice));
                }
            }
        }
    }
    public float getTotalAmount() {
        float f = 0.0f;
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catalogsize; j++) {
                if (cart[i].getitemName().equals(catalog[j].getitemName())) {
                    f += cart[i].itemQuantity * catalog[j].itemUnitPrice;
                    break;
                }
            }
        }
        return f;
    }
    public void removefromCart(item item1) {
        // item[] sample = new item[cartsize-1];
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
    public void removeelementfromCart(item item1) {
        item[] sample = new item[cartsize - 1];
        for (int i = 0, j = 0; i < cartsize; i++) {
            if (!(cart[i].getitemName().equals(item1.getitemName()))) {
                sample[j] = cart[i];
                j++;
            }
        }
        cart = sample.clone();
        cartsize -= 1;
    }
    public void removefromCatalog(item item1) {
        item[] sample = new item[catalogsize - 1];
        for (int i = 0, j = 0; i < catalogsize; i++) {
            if (!(catalog[i].equals(item1))) {
                sample[j] = catalog[i];
                j++;
            }
        }
        catalog = sample.clone();
        catalogsize -= 1;
    }
    public void applyCoupon(final int disc) {
        if (coupon < disc) {
            coupon = disc;
        }
    }
    public float getpaybleAmount() {
        if (coupon == 0) {
            return (getTotalAmount() * 1.15f);
        }
        return ((getTotalAmount() - (getTotalAmount() * (coupon / 100.0f))) * 1.15f);
    }
    public void printInvoice() {
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        printCart();
        System.out.println("Total:" + getTotalAmount());
        if (coupon == 0) {
            System.out.println("Disc%:0.0");
        } else {
            System.out.println("Disc%:" + (getTotalAmount() * (coupon / 100.0f)));
        }
        if (coupon == 0) {
            System.out.println("Tax:" + (getTotalAmount() * 0.15f));
        } else {
            System.out.printf("Tax:%.1f\n",((getTotalAmount() - (getTotalAmount() * (coupon / 100.0f))) * 1.15f));
        }
        System.out.println("Payable amount: " + getpaybleAmount());
    }
}


public final class Solution {
    public static void main(String[] args) {
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
                sc.addtoCatalog(new item(values[0], quantity, price));
                break;
            case "catalog":
                sc.showCatalog();
                break;
            case "add":
                values = token[1].split(",");
                quantity = Integer.parseInt(values[1]);
                sc.addtoCart(new item(values[0], quantity, 0.0f));
                break;
            case "show":
                sc.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + sc.getTotalAmount());
                break;
            case "remove":
                values = token[1].split(",");
                quantity = Integer.parseInt(values[1]);
                sc.removefromCart(new item(values[0], quantity, 0.0f));
                break;
            case "coupon":
                int disc = Integer.parseInt(token[1].substring(3, 5));
                if (disc == 10 || disc == 20 || disc == 30 || disc == 50) {
                    sc.applyCoupon(disc);
                } else {
                    System.out.println("Not a valid coupon");
                }
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + sc.getpaybleAmount());
                break;
            case "print":
                sc.printInvoice();
                break;
            }
        }
    }
}