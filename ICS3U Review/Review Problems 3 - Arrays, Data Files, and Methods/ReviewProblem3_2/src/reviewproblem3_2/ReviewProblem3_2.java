/*
 * Lukas Krampitz
 * Sep 22, 2020
 * Read 20 names from a file and as you get the names, store them in an array.  Make sure to include your own name at least twice. Then preform tasks with the names.
 */
package reviewproblem3_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class ReviewProblem3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        String[] names = new String[20];
        int numMyName = 0;
        int myNamePos = -1; //set to -1 as deflausf if none found yet
        boolean foundCutten = false;
        
        //read in the data file and create chart
        try {
            //load the data file
            File file = new File("src\\reviewproblem3_2\\names.txt");
            //create the scanner
            Scanner scanner = new Scanner(file);
            
            //read in the 20 names
            for (int i = 0; i < 20; i++) {
                //collect the record
                names[i] = scanner.nextLine();                
            }
            
            //go through the array an preform some analysis
            for (int i = 0; i < 20; i++) {
                //check for my name
                if (names[i].equalsIgnoreCase("lukas")) {
                    numMyName++;
                    if (myNamePos == -1) {
                        myNamePos = i;
                    }
                } else if (names[i].equals("Cutten") && !foundCutten) { //Determine whether or not the name “Cutten” is found
                    foundCutten = true;
                }
            }
            
            //List the names entered
            System.out.println("The following were the names entered:");
            for (int i = 0; i < 20; i++) {
                System.out.println(" - " + names[i]);
            }
            
            //display the analysis
            System.out.println("\nMy name of Lukas was found: " + numMyName + " times"
                    + "\nThe first occurence of my name was in array position: " + myNamePos + "\n"
                    + "Found the name \"Cutten\": " + foundCutten);
            
        } catch (FileNotFoundException e) {
            //display the error
            System.out.println("Error: " + e);
        }
    }
    
}
