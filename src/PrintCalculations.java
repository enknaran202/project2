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


    // Note: This is presuming that the Linked List data structure is putting in
    // the number nodes backwards like instead of 1234
    // it would be 4321
    public LinkedList addition(LinkedList fir, LinkedList sec) {

        LinkedList result = new LinkedList();

        int carry = 0;

        while(fir.hasNext() || sec.hasNext()) {

            int summation = carry;

            if(fir.hasNext()) {

                summation += fir.next();

            }

            if(sec.hasNext()) {

                summation += sec.next();

            }

            result.addHigh(summation % 10);

            carry = summation/10;


        }

        if(carry > 0) {

            result.addHigh(carry);
        }

        fir.resetCurrent();
        sec.resetCurrent();
        return result;
    }
    /**
     * 
     * 
     */
    public LinkedList multiply(LinkedList num1, LinkedList num2)
    {
        // !QUESTION! Does the order matter? If one is longer than the other
        // Would it be faster if one was on top and the other was on the bottom?
        LinkedList toReturn = null;
        num1.resetCurrent();
        num2.resetCurrent();
        int curNum2;
        int curNum1;
        int multiplied = 0;
        int carry = 0;
        LinkedList addTemp1 = null;
        LinkedList addTemp2 = null;
        LinkedStack saveMults = new LinkedStack();
        // gets the current number to multiply with the first list
        for (int i = 0; i < num2.getSize(); i++)
        {
            // Create a new List to save each multiplication
            toReturn = new LinkedList();
            // reset the pointer of the first list
            num1.resetCurrent();
            carry = 0;
            // saves the cur number
            curNum2 = num2.next();
            // Adds zeros if we are using higher power numbers
            for (int k = 0; k < i; k++)
            {
                toReturn.addHigh(0);
            }
            for (int j = 0; j < num1.getSize(); j++)
            {

                curNum1 = num1.next();
                multiplied = (curNum1 * curNum2) + carry;
                carry = 0;
                // if the multiplication results in a number that needs to be
                // carried
                if (multiplied > 9)
                {
                    // add the first digit to the list
                    toReturn.addHigh(multiplied % 10);
                    // save the carry for the next multiplication
                    carry = multiplied / 10;
                    // if we are about to go beyond the size of the first num
                    if (j == num1.getSize() - 1)
                    {
                        toReturn.addHigh(carry);
                    }
                }
                else
                {
                    toReturn.addHigh(multiplied);
                }
            }
            // save the resulting list in a stack to be added later
            saveMults.push(toReturn);

        }

        while (saveMults.size() > 1)
        {
            addTemp1 = saveMults.pop();
            addTemp2 = saveMults.pop();
            saveMults.push(addition(addTemp1, addTemp2));
        }
        // add all the numbers in this stack together
        toReturn = saveMults.pop();
        return toReturn;
    }


    public LinkedList exponentiation(LinkedList x, LinkedList n)
    {
        x.resetCurrent();
        n.resetCurrent();
        int power = Integer.parseInt(n.toString());
        return exponentiationHelper(x, power);
    }


    private LinkedList exponentiationHelper(LinkedList x, int power)
    {
        if (power == 1)
        {
            return x;
        }
        if (power == 0)
        {
            LinkedList returnOne = new LinkedList();
            returnOne.addLow(1);
            return returnOne;
        }
        if (power % 2 == 0)
        {
            // x(x^2) ^(n/2)
            return exponentiationHelper(multiply(x, new LinkedList(x.toString())), power / 2);
        }
        // if the lowest integer is odd

        // x(x^2) ^((n-1)/2)
        return multiply(x, exponentiationHelper(multiply(x, new LinkedList(x.toString())), (power - 1) / 2));
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
            { // possible fix to lines with spaces being
              // included
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
                                    stack.push(addition(tempNum1, tempNum2));
                                    // push onto stack
                                    break;
                                case "*":
                                    // multiply tempNum1 and 2
                                    stack.push(multiply(tempNum1, tempNum2));
                                    // push onto stack
                                    break;
                                case "^":
                                    // do power thing 1 and 2
                                    stack.push(exponentiation(tempNum1, tempNum2));
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
