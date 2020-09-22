/*
 * Lukas Krampiz
 * Sep 22, 2020
 * Read in a list of numbers from a data file. The first number in the file will be the value we are checking for “aloneness”. The rest of the data file will contain the array to be processed. This array may be of any size. Print out a new version of the array, where every instance of the given value which is alone has been replaced by whichever value to its left or right is larger. 
 */
package reviewproblem3_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukra1175
 */
public class ReviewProblem3_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        int[] numSet;
        int checkAlone;
        int arraySize = 0; //how big is the array in the data file
        
        //load the data file
        try {
            File file =  new File("src\\ReviewProblem3_5\\nums.txt");
            Scanner scanner =  new Scanner(file);
            
            //get the first line to find the number being checked
            checkAlone = Integer.parseInt(scanner.nextLine());
            
            //get the size of the array
            while (scanner.hasNextLine()) {
                arraySize++; //count an element
                scanner.nextLine(); //progress the scanner
            }
            
            //initialize the array to store the numbers
            numSet = new int[arraySize];
            
            //close the old scanner
            scanner.close();
            
            //create a new scanner for reading the file again
            Scanner secondRead = new Scanner(file);
            
            //populate the array
            numSet = populateArray(numSet, secondRead);
            
            for (int i = 0; i < numSet.length; i++) {
                System.out.println(numSet[i]);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Loop through a data file and populate an array of integers
     * @param array
     * @param scanner
     * @return 
     */
    public static int[] populateArray(int[] array, Scanner scanner) {
        //loop through the data file and populate the array
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        
        return array;
    }
    
}
