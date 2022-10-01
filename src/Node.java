
public class Node<T>
{   //Used in both classes

    private T data;
    private Node next;

    public Node(T data, Node nextNode)
    {

        this.data = data;
        next = nextNode;

    }
    
    public Node(Node nextNode)
    {
        next = nextNode;
    }


    public T getData()
    {

        return data;

    }


    public void setData(T newData)
    {

        data = newData;

    }


    public Node getNext()
    {

        return next;

    }


    public void setNext(Node nextNode)
    {

        next = nextNode;

    }

}
