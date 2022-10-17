import java.util.NoSuchElementException;

// I DONT KNOW ENOUGH ABOUT THE ALGO TO DO THIS DATA STRUCTURE
/**
 * Linked list with access to end.
 * Able to input at the beginning and end of list.
 * Low -> node -> node -> node -> null
 * 
 * High points to the last node in the list.
 * 
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
    private int size;

    /**
     * LinkedList constructor
     * 
     */
    public LinkedList()
    {
        high = null;
        low = null;
        cur = null;
        size = 0;
    }


    /**
     * Creates a LinkedList from a string of a number
     * 
     * @param input
     *            The number in string form to be converted to LL
     */
    public LinkedList(String input)
    {
        high = null;
        low = null;
        cur = null;
        size = 0;
        inputString(input);
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

            low = new Node<Integer>(number, null);
            cur = low;
            high = low;
            size++;

        }

        else
        {
            Node<Integer> newNode = new Node<Integer>(number, low);
            low = newNode;
            cur = low;
            size++;
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
            low = new Node<Integer>(number, null);
            high = low;
            cur = low;
            size++;
        }
        else
        {
            high.setNext(new Node<Integer>(number, null));
            high = high.getNext();
            size++;
        }
    }


    /**
     * Helper method to input a String
     * Pre: The string must only contain numbers
     * 
     * @param number
     *            The number to be entered into the list
     */
    // Change to cut out excess zero's 00001234321 = 1234321
    private void inputString(String input)
    {
        for (int i = 0; i < input.length(); i++)
        {
            addLow(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
    }


    /**
     * Removes excess zero's. 0000 => 0
     * 
     */
    public void removeHighZeros()
    {
        Node<Integer> tempCur = low;
        while (high != low && high.getData() == 0)
        {
            tempCur = low;
            while (tempCur.getNext() != high)
            {
                tempCur = tempCur.getNext();
            }
            high = tempCur;
            tempCur.setNext(null);
            size--;
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
     * The size of the list
     * 
     * @return int
     *         The size of the LinkedList
     * 
     */
    public int getSize()
    {
        return size;
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
     *         the list in proper string form
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
