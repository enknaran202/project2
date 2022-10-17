import student.TestCase;

// ----------------------------------------------------------
/**
 * NodeTest Class
 * Description: Test class for NodeTest object
 * 
 * @version 10/17/2022
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * 
 */
public class NodeTest extends TestCase
{

    private Node<Integer> test1;
    private Node<Integer> test2;
    private Node<Integer> test3;
    private Node<Integer> test4;

    // ----------------------------------------------------------
    /**
     * 
     * Sets up test Node objects to be used
     * 
     */
    public void setUp()
    {

        test1 = new Node<Integer>(1, null);
        test3 = new Node<Integer>(3, null);
        test2 = new Node<Integer>(2, test3);
        test4 = new Node<Integer>(test1);

    }


    /**
     * Tests getData
     */
    public void testGetData()
    {

        assertEquals(1, ((int)test1.getData()));
        assertEquals(2, ((int)test2.getData()));
        assertEquals(3, ((int)test3.getData()));
        test4.setData(4);
        assertEquals(4, ((int)test4.getData()));
        Node<Integer> zero = new Node<Integer>(0, null);
        assertEquals(0, ((int)zero.getData()));

    }


    /**
     * tests setData
     */
    public void testSetData()
    {

        assertEquals(1, ((int)test1.getData()));
        test1.setData(0);
        assertEquals(0, ((int)test1.getData()));
        test1.setData(2);
        assertEquals(2, ((int)test1.getData()));
        Node<Integer> nope = new Node<Integer>(null, null);
        nope.setData(0);
        assertEquals(0, ((int)nope.getData()));

    }


    /**
     * tests getNext
     */
    public void testGetNext()
    {

        assertNull(test1.getNext());
        assertEquals(test1, test4.getNext());
        assertEquals(test3, test2.getNext());

    }


    /**
     * tests setNext
     */
    public void testSetNext()
    {

        assertNull(test1.getNext());
        test1.setNext(test2);
        assertEquals(test2, test1.getNext());
        test2.setNext(test4);
        assertEquals(test4, test2.getNext());
        Node<Integer> neww = new Node<Integer>(7, null);
        test4.setNext(neww);
        assertEquals(neww, test4.getNext());

    }
}
