import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrintCalculations 
{
    String fileName;
    
    public PrintCalculations(String path) {
        
        fileName = path;
        
    }
    
 
    public void printCalculations() throws FileNotFoundException {
        
        Scanner scanIn = new Scanner(new File(fileName));

        while (scanIn.hasNextLine()) {
            String line = scanIn.nextLine();
            System.out.println("Input Line: " + line);

            if(line.length() == 0) { // will this check for empty blank lines since length is 0?
                
                String[] words = line.split(" +*^");
                for (int i = 0; i < words.length; i++) {

                    String word = words[i];
                    System.out.println("Input word: " + word);
                    // Something's not right here when the input has some tabs ...
                    // Maybe we should change the Regular Expression that's used
                    // for splitting the line into words? 
                    // And what happens when I have a blank line?
                }
                
            }
            
        }
        scanIn.close();

    }

    
}
