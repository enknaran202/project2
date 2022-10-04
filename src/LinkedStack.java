
public class LinkedStack
{
    private int size;
    private Node<LinkedList> top;

    public LinkedStack()
    {
        size = 0;
        top = new Node<LinkedList>(null, null);
    }


    public void push(LinkedList newNum)
    {
        // doublecheck to see if it works
        top.setNext(new Node<LinkedList>(newNum, top.getNext()));
        size++;

    }


    public LinkedList pop()
    {
        LinkedList toReturn = null;
        if (!isEmpty())
        {
            toReturn = (LinkedList)top.getNext().getData();
            top.setNext(top.getNext().getNext());
            size--;
        }
        return toReturn;
    }


    public LinkedList peek()
    {
        if (!isEmpty())
        {
            return (LinkedList)top.getNext().getData();
        }
        return null;
    }


    public boolean isEmpty()
    {
        return top.getNext() == null;
    }


    public int size()
    {
        return size;
    }
}
