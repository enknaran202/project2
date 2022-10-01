import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Better put the honor code here...
// On my honor:
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
//   with anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
//  Name: Deep Datta, PID: ddeep21
//  Name: Enk Naran, PID: enknaran
public class BigNumArithmetic {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                "Exactly one argument needed: file-input");
        }
        String inputFilePath = args[0];

        // We could do all this in a static way, but then we would
        // need to reset our static variables for every test!
        // Let's avoid that by using the object approach like so: 

        BigNumArithmetic superCalc = new BigNumArithmetic();
        superCalc.printCalculations(inputFilePath);
    }


    public BigNumArithmetic() {
        // If I had any fields, I'd initialize them here
    }


    // Delete this eventually 
    public void printCalculations(String filepath) throws FileNotFoundException {
        Scanner scanIn = new Scanner(new File(filepath));

        while (scanIn.hasNextLine()) {
            String line = scanIn.nextLine();
            System.out.println("Input Line: " + line);

            String[] words = line.split(" +");
            for (int i = 0; i < words.length; i++) {

                String word = words[i];
                System.out.println("Input word: " + word);
                // Something's not right here when the input has some tabs ...
                // Maybe we should change the Regular Expression that's used
                // for splitting the line into words? 
                // And what happens when I have a blank line?
            }
        }
        scanIn.close();

    }

}
