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
        int[] alonePos; //the positions in the numSet array where there is an alone number for the checked number
        int checkAlone;
        int arraySize = 0; //how big is the array in the data file
        int numOfAlone; // how many lone numbers are there?
        String output = "";
        
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
            //set the scanner to exclude the number to check
            secondRead.nextLine();
            
            //populate the array
            numSet = populateArray(numSet, secondRead);
            
            //find out how many are lone
            numOfAlone = getAloneNum(numSet, checkAlone);
            
            //gather all the indexes of number that are alone and need to be fixed
            alonePos = new int[numOfAlone];
            alonePos = getAlonePos(alonePos, numSet, checkAlone);
            
            //fix the array
            numSet = fixAlone(numSet, alonePos);
            
            //output
            output += "{";
            for (int i = 0; i < numSet.length; i++) {
                output += numSet[i];
                //check to add a comma
                if (i < (numSet.length - 1)) {
                    output += ",";
                }
            }
            
            output += "}";
            
            System.out.println(output);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static int[] fixAlone(int[] arrayNums, int[] aloneNums) {
        int numLeft;
        int numRight;
        int bigNum;
        
        //go though all alone numbers
        for (int i = 0; i < aloneNums.length; i++) {
            //get the value of the numbers to each side
            numLeft = arrayNums[aloneNums[i]-1];
            numRight = arrayNums[aloneNums[i]+1];
            
            //find the bigger one
            if (numLeft > numRight) {
                bigNum = numLeft;
            } else {
                bigNum = numRight;
            }
            
            //replace it
            arrayNums[aloneNums[i]] = bigNum;
            
        }
        
        return  arrayNums;
    }
    
    /**
     * Find out how many alone numbers there are
     * @param arrayNums the array containing the set that might have alone numbers (this is that the program will fix)
     * @param checkForAlone the value to check to see if it anywhere alone
     * @return 
     */
    public static int getAloneNum(int[] arrayNums, int checkForAlone) {
        int numOfAlone = 0; //counts how many are alone
        
        //loop through the array to check if an index is alone (Ignor the first and last one as they are never alone)
        for (int i = 1; i < (arrayNums.length - 1); i++) {
            //compare it with the ones before and after
            if ((arrayNums[i] != arrayNums[i-1]) && (arrayNums[i] != arrayNums[i+1]) && arrayNums[i] == checkForAlone) {
                numOfAlone++;
            }
        }
        return numOfAlone;
    }
    
    /**
     * Gather all the indexes of number that are alone and need to be fixed
     * @param aloneNums an array that keeps the positon of alone numbers from arrayNums
     * @param arrayNums the array containing the set that might have alone numbers (this is that the program will fix)
     * @param checkForAlone the value to check to see if it anywhere alone
     * @return 
     */
    public static int[] getAlonePos(int[] aloneNums, int[] arrayNums, int checkForAlone) {
        //reset the counter
        int numOfAlone = 0;
        
        //loop through the array again to check if an index is alone this time record it's position
        for (int i = 1; i < (arrayNums.length - 1); i++) {
            //compare it with the ones before and after
            if ((arrayNums[i] != arrayNums[i-1]) && (arrayNums[i] != arrayNums[i+1]) && arrayNums[i] == checkForAlone) {
                //store the position of the alone number
                aloneNums[numOfAlone] = i;
                numOfAlone++;
            }
        }
        
        return aloneNums;
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
