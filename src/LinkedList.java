// I DONT KNOW ENOUGH ABOUT THE ALGO TO DO THIS DATA STRUCTURE
public class LinkedList<Integer>
{
    private Node<Integer> low;
    private Node<Integer> high;

    public LinkedList()
    {
        high = null;
        low = new Node<Integer>(null, null);
    }


    public void addLow(Integer number)
    {
        if (isEmpty())
        {
                high = low = new Node<Integer>(number, null);
        }
    }


    public void addHigh(int number)
    {

    }


    public boolean isEmpty()
    {
        return low.getNext() == null;
    }
    // remove
    // isEmpty
    //

}
//
//import java.util.NoSuchElementException;
//
////Linked list implementation
//public class LinkedList<T>
//{
// private Node<T> head; // Pointer to list header
// private Node<T> tail; // Pointer to last element
// private Node<T> curr; // Access to current element
// private int listSize; // Size of list
//
// // Constructors
// LinkedList(int size)
// { // Constructor -- Ignore size
//     this();
// }
//
//
// LinkedList()
// {
//     clear();
// }
//
//
// // Remove all elements
// public void clear()
// {
//     curr = tail = new Node<T>(null); // Create trailer
//     head = new Node<T>(tail); // Create header
//     listSize = 0;
// }
//
//
// // Insert "it" at current position
// public boolean insert(E it)
// {
//     curr.setNext(new Node<T>(curr.getData(), curr.getNext()));
//     curr.setData(it);
//     if (tail == curr)
//     {
//         tail = curr.getNext(); // New tail
//     }
//     listSize++;
//     return true;
// }
//
//
// // Append "it" to list
// public boolean append(T it)
// {
//     tail.setNext(new Node<T>(null));
//     tail.setData(it);
//     tail = tail.getNext();
//     listSize++;
//     return true;
// }
//
//
// // Remove and return current element
// public T remove() throws NoSuchElementException
// {
//     if (curr == tail)
//     {// Nothing to remove
//         throw new NoSuchElementException("remove() in LList has current of "
//             + curr + " and size of " + listSize
//             + " that is not a a valid element");
//     }
//     T it = curr.getData(); // Remember value
//     curr.setData((T)curr.getNext().getData()); // Pull forward the next element
//     if (curr.getNext() == tail)
//     {
//         tail = curr; // Removed last, move tail
//     }
//     curr.setNext(curr.getNext().getNext()); // Point around unneeded link
//     listSize--; // Decrement element count
//     return it; // Return value
// }
//
//
// public void moveToStart()
// {
//     curr = head.getNext(); // Set curr at list start
// }
//
//
// public void moveToEnd()
// {
//     curr = tail; // Set curr at list end
// }
//
//
// // Move curr one step left; no change if now at front
// public void prev()
// {
//     if (head.getNext() == curr)
//     {
//         return; // No previous element
//     }
//     Node<T> temp = head;
//     // March down list until we find the previous element
//     while (temp.getNext() != curr)
//     {
//         temp = temp.getNext();
//     }
//     curr = temp;
// }
//
//
// // Move curr one step right; no change if now at end
// public void getNext()
// {
//     if (curr != tail)
//     {
//         curr = curr.getNext();
//     }
// }
//
//
// public int length()
// {
//     return listSize;
// } // Return list length
//
//
// // Return the position of the current element
// public int currPos()
// {
//     Node<T> temp = head.getNext();
//     int i;
//     for (i = 0; curr != temp; i++)
//     {
//         temp = temp.getNext();
//     }
//     return i;
// }
//
//
// // Move down list to "pos" position
// public boolean moveToPos(int pos)
// {
//     if ((pos < 0) || (pos > listSize))
//     {
//         return false;
//     }
//     curr = head.getNext();
//     for (int i = 0; i < pos; i++)
//     {
//         curr = curr.getNext();
//     }
//     return true;
// }
//
//
// // Return true if current position is at end of the list
// public boolean isAtEnd()
// {
//     return curr == tail;
// }
//
//
// // Return current element value. Note that null gets returned if curr is at
// // the tail
// public T getValue() throws NoSuchElementException
// {
//     if (curr == tail) // No current element
//     {
//         throw new NoSuchElementException(
//             "getvalue() in LList has current of " + curr + " and size of "
//                 + listSize + " that is not a a valid element");
//     }
//     return curr.getData();
// }
//
//
// // Tell if the list is empty or not
// public boolean isEmpty()
// {
//     return listSize == 0;
// }
//}

