
public class LinkedStack {
    private int size;
    private Node<LinkedList> top;

    public LinkedStack() {
        size = 0;
        top = new Node<LinkedList>(null, null);
    }


    public void push(LinkedList newNum) {
        // doublecheck to see if it works
        newNum.removeHighZeros();

        top = new Node<LinkedList>(newNum, top);
        size++;

    }


    public LinkedList pop() {
        if (isEmpty()) {

            return null;
        }

        LinkedList toReturn = top.getData();
        top = top.getNext();
        size--;

        return toReturn;
    }


    public LinkedList peek() {
        if (!isEmpty()) {
            return (LinkedList)top.getNext().getData();
        }
        return null;
    }


    public boolean isEmpty() {
        return top.getNext() == null;
    }


    public int size() {
        return size;
    }
}
