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

    public void setUp()
    {

        test = new PrintCalculations("SampleInput");

    }
    
    public void testAddtion() {
        
        
    }
    
    public void testMultiply() {
        
        
    }
    
    public void testIsValid() {
        
        
    }


    public void testPrintCalculations() throws FileNotFoundException
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

    }

}
