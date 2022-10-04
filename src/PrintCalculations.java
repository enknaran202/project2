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

        while (scanIn.hasNext()) {
            String line = scanIn.nextLine();
            if(line.length() != 0 && (!line.equals("\\s+"))) { // need a way to avoid whitepspacing?
                System.out.println("Input Line: " + line);
           
                
               String[] rpn = line.split(" ");
                for (int i = 0; i < rpn.length; i++) {
                    
                    String val = rpn[i];
                    if(!val.equals("")) {
                        
                        System.out.println("Input val: " + val);
                        
                    }
                   
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
