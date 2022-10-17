import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test for linked list
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 10/3/2022
 * 
 */
public class LinkedListTest extends TestCase
{
    private LinkedList list;

    /**
     * Sets up the test
     * The list should be
     * 1,2,3,4,5,6,7,8
     */
    public void setUp()
    {
        list = new LinkedList();
        list.addLow(1);
        list.addLow(2);
        list.addLow(3);
        list.addLow(4);
        list.addLow(5);
        list.addLow(6);
        list.addLow(7);
        list.addLow(8);
    }


    /**
     * Test addLow
     */
    public void testAddLow()
    {
        assertEquals("12345678", list.toString());
        list.addLow(0);
        assertEquals("123456780", list.toString());
    }


    /**
     * Test addHigh
     */
    public void testAddHigh()
    {
        assertEquals("12345678", list.toString());
        list.addHigh(0);
        assertEquals("012345678", list.toString());
    }


    /**
     * test Next
     */
    public void testNext()
    {

        assertEquals(8, (int)list.next());
        assertEquals(7, (int)list.next());
        assertEquals(6, (int)list.next());
        assertEquals(5, (int)list.next());
        assertEquals(4, (int)list.next());
        assertEquals(3, (int)list.next());
        assertEquals(2, (int)list.next());
        assertEquals(1, (int)list.next());

        Exception exception = null;
        try
        {
            list.next();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("No nodes left in the list.",
            exception instanceof NoSuchElementException);
    }


    /**
     * Test hasNext
     */
    public void testHasNext()
    {
        assertTrue(list.hasNext());
        list.next();
        list.next();
        list.next();
        list.next();
        list.next();
        list.next();
        list.next();
        list.next();
        assertFalse(list.hasNext());
    }


    /**
     * test resetCurrent
     */
    public void testResetCurrent()
    {
        assertEquals(8, (int)list.next());
        assertEquals(7, (int)list.next());
        assertEquals(6, (int)list.next());
        list.resetCurrent();
        assertEquals(8, (int)list.next());
    }


    /**
     * test isEmpty
     */
    public void testIsEmpty()
    {
        assertFalse(list.isEmpty());

        LinkedList emptyList = new LinkedList();
        assertTrue(emptyList.isEmpty());

    }


    /**
     * test Clear
     */
    public void testClear()
    {
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * test toString
     */
    public void testToString()
    {
        assertEquals("12345678", list.toString());
        list.addLow(0);
        assertEquals("123456780", list.toString());
        list.addHigh(9);
        assertEquals("9123456780", list.toString());
        list.clear();
        assertEquals("", list.toString());
    }
}
