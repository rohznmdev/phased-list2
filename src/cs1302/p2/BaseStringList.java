package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**
 * This class represents a base string list which is an implementation of the fancy string list
 * class.
 */

public abstract class BaseStringList implements FancyStringList {

    // initialize the instance variables.
    protected int size;

    /**
     * This is the constructor for the class which sets the size instance variables to 0.
     */
    public BaseStringList() {
        // set the size to 0.
        size = 0;
    } // BaseStringList

    /**
     * Method that appends an item to the node at the size index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        //creating a temp variable.
        boolean temp = false;
        //checking for exceptions.
        if (item.equals("")) {
            throw new IllegalArgumentException("Append: Item cannot be empty.");
        } else if (item == null) {
            throw new NullPointerException("Append: Item cannot be null.");
        } // if
        // using the add method to append the item to the size index.
        add(size(), item);
        temp = true;
        // returning the result.
        return temp;
    } // append

    /**
     * Method that checks if the size is 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        //creating a temp variable.
        boolean temp = false;
        //checking if the size method is 0.
        if (size() == 0) {
            temp = true;
        } // if
        // returning the result.
        return temp;
    } // isEmpty

    /**
     * Method that returns the string starting with the start string,
     * seperated by the sep string and ending with the end string.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String makeStringTemp = start;
        // if it is empty then it will return an empty list.
        if (isEmpty() == true) {
            makeStringTemp = start + end;
        } else {
            //creating the correct string based on index values.
            for (int i = 0; i < size() - 1; i++) {
                makeStringTemp = makeStringTemp + this.get(i) + sep;
            } // for
            makeStringTemp = makeStringTemp + this.get(size() - 1) + end;
        } // else - if
        //returning the string.
        return makeStringTemp;
    } // makeString

    /**
     * Method that inserts the item at the index 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        // checking for exceptions
        if (item.equals("")) {
            throw new IllegalArgumentException("Prepend: Item cannot be empty.");
        } else if (item == null) {
            throw new NullPointerException("Prepend: Item cannot be null.");
        } // else - if
        // calling the add method
        add(0, item);
        return true;
    } // prepend

    /**
     * Method that returns the size.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int size() {
        // return the size of the object.
        return size;
    } // size

    /**
     * Method that returns the string with the specified contents.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        // calls the make string method
        return makeString("[", ", ", "]");
    } // toString

    /**
     * Method that adds items into the string list at the index specified.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, StringList items) {
        // returns !items.isEmpty();
        //checking for exceptions
        if (items == null) {
            throw new NullPointerException("Add: Items cananot be null.");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: Index is out of bounds");
        } // else if
        int i = index;
        int j = 0;
        int temp = index + items.size();
        while (i < temp) {
            add(i, items.get(j));
            i++;
            j++;
        } // while
        return !items.isEmpty();
    } // add

    /**
     * Method that appends items to the stringlist at index size.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(StringList items) {
        // return !items.isEmpty()
        //checking for exceptions
        if (items == null) {
            throw new NullPointerException("Append: Items cannot be null.");
        } // if
        int i = 0;
        while (i < items.size()) {
            append(items.get(i));
            i++;
        } // while
        return !items.isEmpty();
    } // append

    /**
     * Method that checks if there is a value after the start index that
     * is the same as the target value.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int start, String target) {
        // creating temp variables with the specified data.
        boolean inList = false;
        int i = start;
        // checking if the value at index i is equal to the target
        while (i < size()) {
            if (get(i).equals(target)) {
                inList = true;
            } // if
            i++;
        } // while
        // returning whether the value is in the list.
        return inList;
    } // contains

    /**
     * Method that returns the first index of the item that equals the target.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int indexOf(int start, String target) {
        int index = -1;
        int i = start;
        // checking if the value at index i is equal to the target.
        while (i < size()) {
            if (get(i).equals(target)) {
                index = i;
                return index;
            }
            i++;
        } // while
        return index;
    } // indexOf

    /**
     * Method that prepends an item to the string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(StringList items) {
        // checking for exceptions
        //return !items.isEmpty()
        if (items == null) {
            throw new NullPointerException("Prepend: Items cannot be null.");
        } // if
        int i = 0;
        while (i < items.size()) {
            add(i, items.get(i));
            i++;
        } // while
        return !items.isEmpty();
    } // prepend
} // BaseStringList
