/**.
 * { For Buffered Input Stream }.
 */
import java.io.BufferedInputStream;
/**.
 * { Print Stream }.
 */
import java.io.PrintStream;
/**.
 * { Arrays }.
 */
import java.util.Arrays;
/**.
 * { Scanner }.
 */
import java.util.Scanner;
/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items

     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */
public class List<E> {
    /**.
     * { List }.
     */
    private E[] list;
    /**.
     * { Size }.
     */
    private int size;
    //Constructor
    public List() {
        // Create a variable of the type Object[]
        list = ((E[])new Object[10]);//Object is the base class for all the classes
        size = 0;
    }
    //Overloaded Constructor
    public List(final int param) {
        list = ((E[])new Object[param]);
        size = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */
    public void add(E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        // list[(size++)] = item;
        if (size == list.length) {
            resize();
        }
        list[(size++)] = item;
    }
    /*Inserts all the elements of specified int
    array to the end of list*/
    public void addAll(E[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    public void resize() {
        list = Arrays.copyOf(list, size * 2);
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    public int size() {
        return size;
    }
    /*
     * The remove method does what the name suggests.
     * Removes a String item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    public void remove(final int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    public E get(final int index) {
        if (index < size) {
            return list[index];
        } else {
            return null;
        }
    }
    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    public String toString() {
       if (size == 0)
            return "[]";
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
   public boolean contains(final E item) {
        return indexOf(item) >= 0;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */

    public int indexOf(final E item) {
       for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1; 
    }

    /* Removes all of its elements that
     * are contained in the specified int array.
     */
    public void removeAll(E[] items) {
        for (int i = 0; i < items.length; i++) {
            int index = indexOf(items[i]);
            while (index != -1) {
                remove(index);
                index = indexOf(items[i]);
            }
        }  
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */
    public List subList(int n, int n2) {
        if ( n > size || n2 > size) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        if (n < 0 || n2 < 0) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        if (n > n2) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        } 
        if (n == n2) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        List sublist = new List(n2 - n);
        for(int i = n; i < n2; i++) {
            sublist.add(this.get(i));
        }
        return sublist;
    }
    /*Returns a boolean indicating whether the parameter
      i.e a List object is exactly matching with the given list or not.
     */
    public boolean equals(List<E> listdata)
    {
        return this.toString().equals(listdata.toString());
    }
    /*Removes all the elements from list*/
    public void clear()
    {
        size = 0;
        list = (E[]) new Object[10];
    }
}
