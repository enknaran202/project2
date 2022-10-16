import student.TestCase;
import student.testingsupport.PrintStreamWithHistory;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 *
 */
public class PrintCalculationsTest extends TestCase
{

    // use systemOut().getHistory()
    // look up "test main" in Piazza and find related posts on how to test main
    // Note: need to do sysoout.clearHistory() to clear it

    private PrintCalculations test;
    private LinkedList test1;
    private LinkedList test2;
    private LinkedList test3;
    private LinkedList test4;
    private LinkedList test5;
    private LinkedList test6;

    public void setUp()
    {

        test = new PrintCalculations("SampleInput");
        
        //1234
        test1 = new LinkedList();
        test1.addLow(1);
        test1.addLow(2);
        test1.addLow(3);
        test1.addLow(4);
        
        //4321
        test2 = new LinkedList();
        test2.addLow(4);
        test2.addLow(3);
        test2.addLow(2);
        test2.addLow(1);
        
        //9999
        test3 = new LinkedList();
        test3.addLow(9);
        test3.addLow(9);
        test3.addLow(9);
        test3.addLow(9);
        
        //599
        test4 = new LinkedList();
        test4.addLow(5);
        test4.addLow(9);
        test4.addLow(9);
        
        //4936000
        test5 = new LinkedList();
        test5.addLow(4);
        test5.addLow(9);
        test5.addLow(3);
        test5.addLow(6);
        test5.addLow(0);
        test5.addLow(0);
        test5.addLow(0);
        
        //370200
        test6 = new LinkedList();
        test6.addLow(3);
        test6.addLow(7);
        test6.addLow(0);
        test6.addLow(2);
        test6.addLow(0);
        test6.addLow(0);

    }
    
    public void testAddtion() {
        assertEquals("5555", test.addition(test1, test2).toString());
        assertEquals("5555", test.addition(test2, test1).toString());
        assertEquals("11233", test.addition(test1, test3).toString());
        assertEquals("11233", test.addition(test3, test1).toString());
        assertEquals("10598", test.addition(test3, test4).toString()); 
        assertEquals("10598", test.addition(test4, test3).toString());
        assertEquals("5306200", test.addition(test5, test6).toString());
    }
    
    public void testMultiply() {
        assertEquals("5332114", test.multiply(test1, test2).toString());
        assertEquals("5332114", test.multiply(test2, test1).toString());
    }
    
    public void testExponentiation() {
        
        
    }
    
    public void testIsValid() {
        
        
    }


   /* public void testPrintCalculations() throws FileNotFoundException
    {

        PrintStreamWithHistory sysout = systemOut();
        test.printCalculations();
        assertEquals(
            "000000056669777 99999911111 + 352324012 + 03 ^ 555557778 * = 562400792227677956625810678708149922000000"
                + "99999999 990001 * 01119111 55565 33333 + * + 88888888 + = 99099674628565"
                + "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^ = 2638486500477638652325851269760"
                + "9 1 + 5 * 00000000 + = 50" + "999999999 0 * = 0"
                + "9 0 ^ = 1"
                + "5555555 333333 5454353 999999 666666 01 ^ * * + ="
                + "3432 3333 9999 + * ^ * * 6666 + =", sysout.getHistory());
        sysout.clearHistory();

    } */

}
