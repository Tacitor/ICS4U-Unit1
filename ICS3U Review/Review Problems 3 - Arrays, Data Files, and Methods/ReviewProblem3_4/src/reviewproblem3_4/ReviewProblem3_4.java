/*
 * Lukas Krampiz
 * Sep 22, 2020
 * Populate an array with 10 numbers from a data file. Output whether or not the array contains either 3 even or 3 odd numbers all next to one another. 
 */
package reviewproblem3_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukra1175
 */
public class ReviewProblem3_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        boolean triConsecPairity = false;
        int[] nums = new int[10];
        
        //load datafile
        try {
            //Input
            File file = new File("src\\reviewproblem3_4\\nums.txt");
            Scanner scanner = new Scanner(file);
            
            nums = populateArray(nums, scanner);
            
            //logic
            triConsecPairity = getConsecParity(nums);
            
            //output
            if (triConsecPairity) {
                System.out.println("Yes! The array contains either 3 even or 3 odd numbers all next to one another.");
            } else {
                System.out.println("No! The array does not contains either 3 even or 3 odd numbers all next to one another.");
            }
            
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Find triple consecutive integer parity
     * @param array
     * @return 
     */
    public static boolean getConsecParity(int[] array) {
        boolean foundPairity = false;
        int prevNum1 = 0; //the number directly after the current one
        int prevNum2 = 1; //the number directly after prevNum1
        
        //loop through the array
        for (int i = 0; i < array.length; i++) {
            //compare the current array item with the two before it for parity
            if ((array[i] % 2 == prevNum1 % 2) && (array[i] % 2 == prevNum2 % 2)) {
                foundPairity = true;
            }
            
            //store the previous numbers down the chain
            prevNum2 = prevNum1;
            prevNum1 = array[i];
        }
        
        return foundPairity;
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
