import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * 
 */
public class PrintCalculations {
    private String fileName;

    /**
     * 
     * 
     */
    public PrintCalculations(String path) {

        fileName = path;

    }


    // Note: This is presuming that the Linked List data structure is putting in
    // the number nodes backwards like instead of 1234
    // it would be 4321
    public LinkedList addition(LinkedList fir, LinkedList sec) { // we check for
                                                                 // leading
                                                                 // zeros before
                                                                 // calling this
                                                                 // method
        LinkedList result = new LinkedList();
        LinkedList carry = new LinkedList();
        int counter = 0;
        int added = 0;

        if (!fir.isEmpty() && !sec.isEmpty()) { // Is this necessary and can
                                                // this be tested accordingly
                                                // without null issues?

            return null;

        }

        // Next part is to figure out how to traverse both lists at the same
        // time and identify when either or has "ran out" before the other
        // Should i create a seperate structure to "hold carries?"
        while (counter <= fir.getSize() || counter <= sec.getSize()) {

            added = 0; // reset for each single digit addition

            if (counter == fir.getSize()) {

                while (counter != sec.getSize()) {

                    added = sec.next();

                    if (!carry.isEmpty()) {

                        added = added + 1;
                        carry.clear();
                        if (added == 10) {

                            result.addLow(added - 10);
                            carry.addLow(1); // structure to carry ones, need a
                                             // way to add and delete as
                                             // necessary

                            // what about situation if both sizes equal????
                            // (think its covered but check?)
                        }
                    }

                    result.addLow(added);
                    counter++;
                }

            }

            else if (counter == sec.getSize()) {

                while (counter != fir.getSize()) {

                    added = fir.next();
                    
                    if (!carry.isEmpty()) {

                        added = added + 1;
                        carry.clear();
                        if (added == 10) {

                            result.addLow(added - 10);
                            carry.addLow(1); // structure to carry ones, need a
                                             // way to add and delete as
                                             // necessary

                            // what about situation if both sizes equal????
                            // (think its covered but check?)
                        }
                    }
                    result.addLow(added);
                    counter++;
                }

            }

            else {

                added = fir.next() + sec.next();
                if (!carry.isEmpty()) {

                    added = added + 1;
                    carry.clear();

                }

                if (added >= 10) {

                    result.addLow(added - 10);
                    carry.addLow(1); // structure to carry ones, need a way to
                                     // add and delete as necessary

                    // what about situation if both sizes equal???? (think its
                    // covered but check?)
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
    public void printCalculations() throws FileNotFoundException {

        Scanner scanIn = new Scanner(new File(fileName));
        LinkedList tempNum1 = null;
        LinkedList tempNum2 = null;
        LinkedStack stack = new LinkedStack();

        while (scanIn.hasNext()) {
            String line = scanIn.nextLine();
            if (!line.isEmpty() || !line.trim().equals("") || !line.trim()
                .equals("\n")) { // possible fix to lines with spaces being
                                 // included
                                 // takes out extra spaces between strings
                line = line.trim().replaceAll(" +", " ");
                String[] rpn = line.split(" ");
                // Send the array to a method to ensure correct # of numbers and
                if (isValid(rpn)) {
                    for (int i = 0; i < rpn.length; i++) {
                        // if the string is a number
                        // put in the linked list
                        // and push the LL onto the stack
                        if (Character.isDigit(rpn[i].charAt(0))) {
                            tempNum1 = new LinkedList(rpn[i]);
                            stack.push(tempNum1);
                        }
                        // if the string is a command
                        else {
                            tempNum1 = stack.pop();
                            tempNum2 = stack.pop();

                            switch (rpn[i]) {
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
                else { // if it does not fit RPN print with only =
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
    public boolean isValid(String[] input) {
        int stackSize = 0;
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))) {
                stackSize++;
            }
            else {
                stackSize--;
            }
            if (stackSize <= 0) {
                return false;
            }
        }
        if (stackSize == 1) {
            return true;
        }
        return false;
    }

}