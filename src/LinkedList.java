import java.util.NoSuchElementException;

// I DONT KNOW ENOUGH ABOUT THE ALGO TO DO THIS DATA STRUCTURE
/**
 * Linked list with access to end.
 * Able to input at the beginning and end of list.
 * Low -> node -> node -> node -> null
 * ....................High-^
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 10/1/2022
 * 
 */
public class LinkedList
{
    private Node<Integer> low;
    private Node<Integer> high;
    private Node<Integer> cur;

    /**
     * LinkedList constructor
     * 
     */
    public LinkedList()
    {
        high = null;
        low = null;
        cur = null;
    }


    /**
     * Enter a new number into the beginning of the list
     * The current pointer is set to the new entry
     * 
     * @param number
     *            The number to be entered into the list
     */
    public void addLow(Integer number)
    {
        if (isEmpty())
        {
            cur = high = low = new Node<Integer>(number, null);

        }

        else
        {
            Node<Integer> newNode = new Node<Integer>(number, low);
            cur = low = newNode;
        }
    }


    /**
     * Enter a new number into the END of the list
     * Note: Current pointer is not reset
     * 
     * @param number
     *            The number to be entered into the list
     */
    public void addHigh(Integer number)
    {
        if (isEmpty())
        {
            high = low = new Node<Integer>(number, null);
            cur = low;
        }
        else
        {
            high.setNext(new Node<Integer>(number, null));
            high = high.getNext();
        }
    }


    /**
     * Returns the value in the current node and moves current to the next node
     * 
     * @return boolean
     *         True if empty, False if not
     * 
     */
    @SuppressWarnings("unchecked")
    public Integer next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException("No nodes left in the list.");
        }
        Integer toReturn = cur.getData();
        cur = cur.getNext();
        return toReturn;
    }


    /**
     * Checks to see if the current pointer is at the end of the list
     * 
     * @return boolean
     *         True if not at end. False if at end
     * 
     */
    public boolean hasNext()
    {
        return cur != null;
    }


    /**
     * Puts current to the beginning of the list
     * 
     */
    public void resetCurrent()
    {
        cur = low;
    }


    /**
     * Checks to see if the list is empty
     * 
     * @return boolean
     *         True if empty, False if not
     * 
     */
    public boolean isEmpty()
    {
        return low == null;
    }


    /**
     * Clears the list
     * 
     */
    public void clear()
    {
        low = null;
        high = null;
    }


    /**
     * Prints the list in the correct order.
     * Note: resets the current pointer to low
     * 
     * @return String
     *         the list
     */
    public String toString()
    {
        String toReturn = "";
        resetCurrent();
        while (hasNext())
        {
            toReturn = next().toString() + toReturn;
        }
        return toReturn;
    }

}
//
// import java.util.NoSuchElementException;
//
//// Linked list implementation
// public class LinkedList<T>
// {
// private Node<T> head; // Pointer to list header
// private Node<T> tail; // Pointer to last element
// private Node<T> curr; // Access to current element
// private int listSize; // Size of list
//
// // Constructors
// LinkedList(int size)
// { // Constructor -- Ignore size
// this();
// }
//
//
// LinkedList()
// {
// clear();
// }
//
//
// // Remove all elements
// public void clear()
// {
// curr = tail = new Node<T>(null); // Create trailer
// head = new Node<T>(tail); // Create header
// listSize = 0;
// }
//
//
// // Insert "it" at current position
// public boolean insert(E it)
// {
// curr.setNext(new Node<T>(curr.getData(), curr.getNext()));
// curr.setData(it);
// if (tail == curr)
// {
// tail = curr.getNext(); // New tail
// }
// listSize++;
// return true;
// }
//
//
// // Append "it" to list
// public boolean append(T it)
// {
// tail.setNext(new Node<T>(null));
// tail.setData(it);
// tail = tail.getNext();
// listSize++;
// return true;
// }
//
//
// // Remove and return current element
// public T remove() throws NoSuchElementException
// {
// if (curr == tail)
// {// Nothing to remove
// throw new NoSuchElementException("remove() in LList has current of "
// + curr + " and size of " + listSize
// + " that is not a a valid element");
// }
// T it = curr.getData(); // Remember value
// curr.setData((T)curr.getNext().getData()); // Pull forward the next element
// if (curr.getNext() == tail)
// {
// tail = curr; // Removed last, move tail
// }
// curr.setNext(curr.getNext().getNext()); // Point around unneeded link
// listSize--; // Decrement element count
// return it; // Return value
// }
//
//
// public void moveToStart()
// {
// curr = head.getNext(); // Set curr at list start
// }
//
//
// public void moveToEnd()
// {
// curr = tail; // Set curr at list end
// }
//
//
// // Move curr one step left; no change if now at front
// public void prev()
// {
// if (head.getNext() == curr)
// {
// return; // No previous element
// }
// Node<T> temp = head;
// // March down list until we find the previous element
// while (temp.getNext() != curr)
// {
// temp = temp.getNext();
// }
// curr = temp;
// }
//
//
// // Move curr one step right; no change if now at end
// public void getNext()
// {
// if (curr != tail)
// {
// curr = curr.getNext();
// }
// }
//
//
// public int length()
// {
// return listSize;
// } // Return list length
//
//
// // Return the position of the current element
// public int currPos()
// {
// Node<T> temp = head.getNext();
// int i;
// for (i = 0; curr != temp; i++)
// {
// temp = temp.getNext();
// }
// return i;
// }
//
//
// // Move down list to "pos" position
// public boolean moveToPos(int pos)
// {
// if ((pos < 0) || (pos > listSize))
// {
// return false;
// }
// curr = head.getNext();
// for (int i = 0; i < pos; i++)
// {
// curr = curr.getNext();
// }
// return true;
// }
//
//
// // Return true if current position is at end of the list
// public boolean isAtEnd()
// {
// return curr == tail;
// }
//
//
// // Return current element value. Note that null gets returned if curr is at
// // the tail
// public T getValue() throws NoSuchElementException
// {
// if (curr == tail) // No current element
// {
// throw new NoSuchElementException(
// "getvalue() in LList has current of " + curr + " and size of "
// + listSize + " that is not a a valid element");
// }
// return curr.getData();
// }
//
//
// // Tell if the list is empty or not
// public boolean isEmpty()
// {
// return listSize == 0;
// }
// }
