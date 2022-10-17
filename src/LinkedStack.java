
/**
 * Classic stack implemented with linked lists
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 10/17/2022
 * 
 */
public class LinkedStack
{
    private int size;
    private Node<LinkedList> top;

    /**
     * LinkedStack constructor
     * Sets size to 0 and top pointer to null;
     * 
     */
    public LinkedStack()
    {
        size = 0;
        top = null;
    }


    /**
     * Creates a new node and pushes onto stack
     * Increments size of stack
     * 
     * @param newNum
     *            The LinkedList to be pushed onto the stack
     */
    public void push(LinkedList newNum)
    {
        // doublecheck to see if it works
        newNum.removeHighZeros();
        top = new Node<LinkedList>(newNum, top);
        size++;

    }


    /**
     * Pops the top of the stack and returns what was removed
     * 
     * @return LinkedList
     *         The LL that was popped from the stack
     */
    public LinkedList pop()
    {
        LinkedList toReturn = null;
        if (!isEmpty())
        {
            toReturn = (LinkedList)top.getData();
            top = (top.getNext());
            size--;

        return toReturn;
    }


    /**
     * Peek at the top of the stack
     * 
     * @return LinkedList
     *         The LL at the top of the stack
     */
    public LinkedList peek()
    {
        if (!isEmpty())
        {
            return (LinkedList)top.getData();
        }
        return null;
    }


    /**
     * Checks to see if the stack is empty
     * 
     * @return boolean
     *         The stack is empty or not
     */
    public boolean isEmpty()
    {
        return top == null;
    }


    /**
     * Checks the size of the stack
     * 
     * @return int
     *         the current size of the stack
     */
    public int size()
    {
        return size;
    }
}
