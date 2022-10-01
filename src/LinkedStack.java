
public class LinkedStack<T>
{
    private int size;
    private Node<T> top;

    public LinkedStack()
    {
        size = 0;
        top = new Node<T>(null, null);
    }


    public void push(T newNum)
    {
        // doublecheck to see if it works
        top.setNext(new Node<T>(newNum, top.getNext()));
        size++;

    }


    public T pop()
    {
        T toReturn = null;
        if (!isEmpty())
        {
            toReturn = (T)top.getNext().getData();
            top.setNext(top.getNext().getNext());
            size--;
        }
        return toReturn;
    }


    public T peek()
    {
        if (!isEmpty())
        {
            return (T)top.getNext().getData();
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
