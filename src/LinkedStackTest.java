import student.TestCase;

/**
 * Test for linked list
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 10/3/2022
 * 
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack test;

    /**
     * Description: Set up the test cases
     */
    public void setUp() {
        test = new LinkedStack();
        test.push(new LinkedList("4"));
        test.push(new LinkedList("3"));
        test.push(new LinkedList("2"));
        test.push(new LinkedList("1"));
    }


    /**
     * Description: Test the push method
     */
    public void testPush() {
        assertEquals("1", test.peek().toString());
        test.push(new LinkedList("5"));
        assertEquals("5", test.peek().toString());
    }


    /**
     * Description: Test the pop method
     */
    public void testPop() {
        assertEquals("1", test.pop().toString());
        assertEquals("2", test.pop().toString());
        assertEquals("3", test.pop().toString());
        assertEquals("4", test.pop().toString());
        // How do I make sure it doesn't pop something bad
        // assertEquals("", test.pop().toString());

    }


    /**
     * Description: Test the peek method
     */
    public void testPeek() {
        assertEquals("1", test.peek().toString());
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        assertEquals(null, test.peek());
    }


    /**
     * Description: Test the isEmpty method
     */
    public void testIsEmpty() {
        assertEquals(false, test.isEmpty());
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        assertEquals(true, test.isEmpty());

    }


    /**
     * Description: Test the size method
     */
    public void testSize() {
        assertEquals(4, test.size());
        test.pop();
        assertEquals(3, test.size());
        test.pop();
        assertEquals(2, test.size());
        test.pop();
        assertEquals(1, test.size());
        test.pop();
        assertEquals(0, test.size());
    }
}
