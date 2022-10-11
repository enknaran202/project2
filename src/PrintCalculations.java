import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * 
 */
public class PrintCalculations
{
    private String fileName;

    /**
     * 
     * 
     */
    public PrintCalculations(String path)
    {

        fileName = path;

    }
    
    public LinkedList addition(LinkedList fir, LinkedList sec) {
        
        LinkedList result = new LinkedList();
        int counter = 0;
        
        while(counter != fir.getSize() || counter != sec.getSize()) { //fir.getSize() <= sec.getSize() || sec.getSize() <= fir.getSize()
            
            if(counter == fir.getSize()) {
                
                while(counter != sec.getSize()) {
                    
                    int singleOne = sec.next();
                    result.addLow(singleOne);
                }
                
            
            }
            
            else if(counter == sec.getSize()) {
                
                while(counter != fir.getSize()) {
                    
                    int singleTwo = fir.next();
                    result.addLow(singleTwo);
                }
                
            
            }
            
            else {
                
                int added = fir.next() + sec.next();
                if(added >= 10) {
                    
                   
                    result.addLow(added-10);
                }
                
                else {
                    
                    result.addLow(added);
                    
                }
            }
            
            
            counter++;
            
        }
        
        return result;
        
        
    }


    /**
     * 
     * 
     */
    public void printCalculations() throws FileNotFoundException
    {

        Scanner scanIn = new Scanner(new File(fileName));
        LinkedList tempNum1 = null;
        LinkedList tempNum2 = null;
        LinkedStack stack = new LinkedStack();

        while (scanIn.hasNext())
        {
            String line = scanIn.nextLine();
            if (!line.isEmpty() || !line.trim().equals("") || !line.trim()
                .equals("\n"))
            { // possible fix to lines with spaces being included
              // takes out extra spaces between strings
                line = line.trim().replaceAll(" +", " ");
                String[] rpn = line.split(" ");
                // Send the array to a method to ensure correct # of numbers and
                if (isValid(rpn))
                {
                    for (int i = 0; i < rpn.length; i++)
                    {
                        // if the string is a number
                        // put in the linked list
                        // and push the LL onto the stack
                        if (Character.isDigit(rpn[i].charAt(0)))
                        {
                            tempNum1 = new LinkedList(rpn[i]);
                            stack.push(tempNum1);
                        }
                        // if the string is a command
                        else
                        {
                            tempNum1 = stack.pop();
                            tempNum2 = stack.pop();
                            
                            switch (rpn[i])
                            {
                                case "+":
                                    // add tempNum1 and tempNum2
                                    // push onto stack
                                    break;
                                case "*":
                                    // multiply tempNum1 and 2
                                    // push onto stack
                                    break;
                                case "^":
                                    // do power thing 1 and 2
                                    // push onto stack
                                    break;
                                default:
                                    break;
                            }
                            // pop two LL's and send to the corresponding
                            // command
                            // push the resulting number into the stack

                        }
                    }
                }
                else
                { // if it does not fit RPN print with only =
                    System.out.println(line + " =");
                }
            }

        }
        scanIn.close();
    }


    /**
     * Checks to see if the expressions is in proper Reverse polish Notation
     * 
     * @return boolean
     *         is or is not proper
     * 
     */
    public boolean isValid(String[] input)
    {
        int stackSize = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (Character.isDigit(input[i].charAt(0)))
            {
                stackSize++;
            }
            else
            {
                stackSize--;
            }
            if (stackSize <= 0)
            {
                return false;
            }
        }
        if (stackSize == 1)
        {
            return true;
        }
        return false;
    }

}
