package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**
 * This class is the LinkedList implementation of a string list.
 */

public class LinkedStringList extends BaseStringList {

    //instance variable for this class
    private Node head;

    /**
     *
     * This is the constructor for the class which sets the head node to null.
     */
    public LinkedStringList() {
        head = null;
    } // LinkedStringList

    /**
     * This is the copy constructor for the class.
     * @param other which is another String List
     */
    public LinkedStringList(StringList other) {
        for (int i = 0; i < other.size(); i++) {
            append(other.get(i));
        } // for
    } // LinkedStringList

    /**
     * Method that adds a node to the specified index with the contents of the item.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // checking for exceptions
        if (item.equals("")) {
            throw new IllegalArgumentException("Add: Item cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("Add: Item cannot be Null");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: Invalid Index");
        } // else - if
        // setting temp variables
        boolean addTemp = false;
        Node temp = new Node(item, head);
        // if the index is 0 it will add the item to the head node.
        if (index == 0 && size() == 0) {
            head = new Node(item);
            if (index == size() && addTemp == true) {
                head = new Node(item, head.getNext());
            }
            // set the head to the temp node created
        } else if (index == 0 && size() > 0) {
            head = temp;
        } else {
            Node start = head;
            Node tempNode = new Node(item);
            // traversing the node to the desired index
            for (int i = 0; i < index - 1; i++) {
                start = start.getNext();
            } // for
            //setting the node
            tempNode.setNext(start.getNext());
            start.setNext(tempNode);
        }
        //incrementing size and returning true.
        addTemp = true;
        size++;
        return addTemp;
    } // add

    /**
     * Method that clears the contents of the array be setting the head to null.
     * Also sets the size to 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        // setting the head to null and size to 0.
        head = null;
        size = 0;
    } // clear


    /**
     * Method that gets the item of a node at a specified index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        //checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Get: Index is out of bounds");
        }
        // making temp variables and node.
        String getTemp;
        Node getTempNode = head;
        //traversing nodes to the desired index.
        for (int i = 0; i < index; i++) {
            getTempNode = getTempNode.getNext();
        }
        // returning the value at that index.
        getTemp = getTempNode.getItem();
        return getTemp;
    } // get

    /**
     * Method that removes a node at a specified index.
     *
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        // checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Remove: Index Out of Bounds");
        } // if
        // making temp variables and nodes.
        String getTemp = get(index);
        Node removeTempNode = head;
        // if the index is 0 it will just return that node and remove it.
        if (index == 0) {
            head = removeTempNode.getNext();
        } else {
            // traversing the nodes.
            for (int i = 0; i < index - 1; i++) {
                removeTempNode = removeTempNode.getNext();
            } // for
            // setting the nodes.
            removeTempNode.setNext(removeTempNode.getNext().getNext());
        } // else
        size--;
        return getTemp;
    } // remove

    /**
     * Method that will return a new stringlist with all the items from start to stop.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index Ouf of bounds");
        } // if
        // creating a new LinkedString List object.
        BaseStringList slicedArea = new LinkedStringList();
        int j = 0;
        // for loop to return the list with the required elements.
        for (int i = start; i < stop; i++) {
            String sliceTemp = get(i);
            slicedArea.add(j, sliceTemp);
            j++;
        } // for
        //returning the sliced portion
        return slicedArea;
    } // slice

    /**
     * Method that returns a fancy string list with all the items from
     * start to stop with step in between.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > size() || start > stop || step < 1) {
            throw new IndexOutOfBoundsException("Slice (FSL): Index is out of bounds.");
        } // if
        // creating a fancy string list object and temp variables.
        FancyStringList fancySlicedArea = new LinkedStringList();
        int i = start;
        // creating the area to return.
        while (i < stop) {
            fancySlicedArea.append(get(i));
            i = i + step;
        } // while
        return fancySlicedArea;
    } // slice

    /**
     * Method that returns a fancy string list in reverse order.
     *
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList reverse() {
        // creating a fancy string list object and temp variables.
        FancyStringList reverseList = new LinkedStringList();
        int i = 0;
        // reversing the list using prepend.
        while (i < size()) {
            reverseList.prepend(get(i));
            i++;
        } // while
        return reverseList;
    } // reverse
} // LinkedStringList
