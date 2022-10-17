
public class LinkedStack
{
    private int size;
    private Node<LinkedList> top;

    public LinkedStack()
    {
        size = 0;
        top = null;
    }


    public void push(LinkedList newNum)
    {
        // doublecheck to see if it works
        newNum.removeHighZeros();
        top = new Node<LinkedList>(newNum, top);
        size++;

    }


    public LinkedList pop()
    {
        LinkedList toReturn = null;
        if (!isEmpty())
        {
            toReturn = (LinkedList)top.getData();
            top = (top.getNext());
            size--;
        }
        return toReturn;
    }


    public LinkedList peek()
    {
        if (!isEmpty())
        {
            return (LinkedList)top.getData();
        }
        return null;
    }


    public boolean isEmpty()
    {
        return top == null;
    }


    public int size()
    {
        return size;
    }
}
