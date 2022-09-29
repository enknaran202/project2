import list.LinkedList.Node;

public class LinkedList {

    private class Node { // Note: We only need int data, would we need to be
                         // generic at all like use string data

        private int data;
        private Node next; 

        private Node(int data, Node nextNode) {
            
            this.data = data;
            next = nextNode;
            
        }

        private int getData() {
            
            return data;
            
        } 


        private void setData(int newData) {
            
            data = newData;
            
        } 


        private Node getNext() {
            
            return next;
            
        }


        private void setNext(Node nextNode) {
            
            next = nextNode;
            
        }
    }
}
