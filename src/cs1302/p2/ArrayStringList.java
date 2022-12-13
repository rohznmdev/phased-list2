package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**
 * This class represents the ArrayList implementation of a FancyStringList.
 */

public class ArrayStringList extends BaseStringList {

    // initializes the instance variables needed for this class.
    private String[] items;

    /**
     * This is the constructor for the class which creates a String array with 10 empty items.
     */
    public ArrayStringList() {
        items = new String[100];
    } // ArrayStringList

    /**
     * This is the copy constructor for the class.
     * @param other which is another String List.
     */
    public ArrayStringList(StringList other) {
        this.items = new String[100];
        for (int i = 0; i < other.size(); i++) {
            this.items[i] = other.get(i);
            this.size++;
        } // for
    } // ArrayStringList

    /**
     * Adds an item to the specified index of the array.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // checking for exceptions
        boolean temp = false;
        if (item == null) {
            throw new NullPointerException("Add: Item cannot be null.");
        } else if (item.equals("")) {
            throw new IllegalArgumentException("Add: Item cannot be empty.");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: Index is out of bounds.");
        } else {
            //creating temp variables and array.
            int newArrSize = (int)(items.length * 0.3);
            //setting the items of the temp array to the original one.
            String[] addTemp = new String[size()];
            for (int i = 0; i < size(); i++) {
                addTemp[i] = get(i);
            } // for
            // checking to see if a bigger array needs to be made.
            if (size() == items.length - 1) {
                items = new String[size() + newArrSize];
            } // if
            int j = 0;
            // adding the index
            for (int i = 0; i < size() + 1; i++) {
                if (i == index) {
                    items[i] = item;
                    j = 1;
                } else {
                    items[i] = addTemp[i - j];
                } // if - else
            } // for
        } // else
        // setting temp to true, incrementing size and returning the result.
        temp = true;
        size++;
        return temp;
    } // add

    /**
     * Sets all the items in the array to null and the size to 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        // looping through all the index
        for (int i = 0; i < items.length - 1; i++) {
            //setting all index to null
            items[i] = null;
            //setting size to 0.
            this.size = 0;
        } // for
    } // clear

    /**
     * Method that gets the item of the specified index of the array.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        //checking for exceptions
        String getTemp = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Get: Index is out of bounds.");
        } else {
        // making a temp variable.
            getTemp = items[index];
        }
        // returning the result.
        return getTemp;
    } // get

    /**
     * Method that removes the item of the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        //checking for exceptions
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Remove: Index is out of bounds.");
        }
        // making a temp variable
        String temp = get(index);
        //looping through the array.
        for (int i = index; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }
        // decrementing size and returning the result.
        size--;
        return temp;
    } // remove

    /**
     * Method that returns the string list with all the items from the start to stop index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index is out of bounds.");
        } // if
        // creating a new ArrayStringList object.
        BaseStringList slicedArea = new ArrayStringList();
        // returning the new list with the required elements.
        if (start == stop) {
            slicedArea.makeString("[", ", ", "]");
        } else if (start != stop) {
            for (int i = start; i < stop; i++) {
                slicedArea.append(items[i]);
            } // for
        } // else - if
        return slicedArea;
    } // slice

    /**
     * Returns a fancy string list with all the items from start to stop with
     * step in between.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop || step < 1) {
            throw new IndexOutOfBoundsException("Slice (FSL): Index is out of bounds.");
        } // if
        // creating a fancystring list object and temp variables.
        FancyStringList fancySlicedArea = new ArrayStringList();
        int i = start;
        // creating the area to return
        while (i < stop) {
            fancySlicedArea.append(get(i));
            i = i + step;
        } // while
        return fancySlicedArea;
    } // slice

    /**
     * Method that returns a fancy string list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList reverse() {
        // creating a fancy string list object and temp variables.
        FancyStringList reverseList = new ArrayStringList();
        int j = 0;
        while (j < size()) {
            reverseList.prepend(get(j));
            j++;
        } // while
        return reverseList;
    } // reverse
} // ArrayStringList
