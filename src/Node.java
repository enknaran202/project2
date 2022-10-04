
class Node<T>
{   //Used in both classes

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> nextNode)
    {

        this.data = data;
        next = nextNode;

    }
    
    public Node(Node<T> nextNode)
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


    public Node<T> getNext()
    {

        return next;

    }


    public void setNext(Node<T> nextNode)
    {

        next = nextNode;

    }

}
