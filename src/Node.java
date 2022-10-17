// I DONT KNOW ENOUGH ABOUT THE ALGO TO DO THIS DATA STRUCTURE
/**
 * Classic generic node
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 10/17/2022
 * 
 */
public class Node<T>
{ // Used in both classes

    private T data;
    private Node<T> next;

    /**
     * Node constructor
     * 
     * @param T
     *            The data to be stored in the node
     * 
     * @param Node
     *            The node this one points to
     * 
     * 
     */
    public Node(T data, Node<T> nextNode)
    {
        // this is what's causing the problems
        this.data = data;
        next = nextNode;

    }


    /**
     * Node Constructor
     * 
     * @param Node
     *            The node this new node points to
     * 
     */
    public Node(Node<T> nextNode)
    {
        // seems unnecessary
        next = nextNode;
    }


    /**
     * What is inside the node
     * 
     * @return T
     *         The data inside the node
     * 
     */
    public T getData()
    {

        return data;

    }


    /**
     * Changes the data in the node
     * 
     * @param T
     *            The new data
     * 
     */
    public void setData(T newData)
    {

        data = newData;

    }


    /**
     * The node this node points to
     * 
     * @return Node
     *         The node this node points to
     */
    public Node<T> getNext()
    {

        return next;

    }


    /**
     * Changes the node this node points to
     * 
     * @param Node
     *            The new node to point to
     * 
     */
    public void setNext(Node<T> nextNode)
    {

        next = nextNode;

    }

}
