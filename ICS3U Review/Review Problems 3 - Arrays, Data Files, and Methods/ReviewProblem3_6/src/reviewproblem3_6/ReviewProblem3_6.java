/*
 * Lukas Krampitz
 * Sep 22, 2020
 * Read a list of numbers from a data file and store them in an array. Print out a new version of the array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. 5's may appear anywhere in the original array.
 */
package reviewproblem3_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class ReviewProblem3_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        int[] numSet;
        int[] fourPos; //the positions in the numSet array where there is a four without a five
        int[] fivePos; //the positions in the numSet array where there is a five that is not already by a four
        int arraySize = 0; //how big is the array in the data file
        int numOfAlone; // how many lone fours are there?
        String output = "";
        
        //load the data file
        try {
            File file =  new File("src\\ReviewProblem3_6\\nums.txt");
            Scanner scanner =  new Scanner(file);
            
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
            
            //find out how many are without a 5
            numOfAlone = getAloneNum(numSet);
            
            //gather all the indexes of fours that are alone and need to be fixed
            fourPos = new int[numOfAlone];
            fourPos = getAlonePos(fourPos, numSet);
            
            //gather all the indexes of fives that are alone and need to be fixed
            fivePos = new int[numOfAlone];
            fivePos = getFivesPos(fivePos, numSet);
            
            //fix the array
            numSet = fixAlone(numSet, fourPos, fivePos);
            
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
    
    /**
     * Fix the array by rearranging so that every 4 is immediately followed by a 5 without moving the 4's
     * @param arrayNums
     * @param aloneNums
     * @param fixerNums
     * @return 
     */
    public static int[] fixAlone(int[] arrayNums, int[] aloneNums, int[] fixerNums) {
        int numBehind;
        
        //go though all alone numbers
        for (int i = 0; i < aloneNums.length; i++) {
            //get the value of the number behind the four
            numBehind = arrayNums[aloneNums[i]+1];
            
            //move that value to where a fixer five is
            arrayNums[fixerNums[i]] = numBehind;
            
            //move the fixer five to behind the four
            arrayNums[aloneNums[i]+1] = 5;            
        }
        
        return  arrayNums;
    }
    
    /**
     * Find out how many alone fours there are
     * @param arrayNums the array containing the set that might have alone numbers (this is that the program will fix)
     * @return 
     */
    public static int getAloneNum(int[] arrayNums) {
        int numOfAlone = 0; //counts how many are alone
        
        //loop through the array to check if a four is followed by a five
        for (int i = 0; i < (arrayNums.length); i++) {
            //compare it with the ones before and after
            if (arrayNums[i] == 4 && arrayNums[i+1] != 5) {
                numOfAlone++;
            }
        }
        return numOfAlone;
    }
    
    /**
     * Gather all the indexes of fours that are alone and need to be fixed
     * @param aloneNums an array that keeps the positon of alone numbers from arrayNums
     * @param arrayNums the array containing the set that might have alone numbers (this is that the program will fix)
     * @return the index of every four without a five
     */
    public static int[] getAlonePos(int[] aloneNums, int[] arrayNums) {
        //reset the counter
        int numOfAlone = 0;
        
        //loop through the array again to check if an index is alone this time record it's position
        for (int i = 0; i < (arrayNums.length); i++) {
            //compare it with the ones before and after
            if (arrayNums[i] == 4 && arrayNums[i+1] != 5) {
                //store the position of the alone number
                aloneNums[numOfAlone] = i;
                numOfAlone++;
            }
        }
        
        return aloneNums;
    }
    
    /**
     * Gather all the indexes of fives that are alone and need to be fixed
     * @param aloneFives
     * @param arrayNums
     * @return 
     */
    public static int[] getFivesPos(int[] aloneFives, int[] arrayNums) {
        //reset the counter
        int numOfAlone = 0;
        
        if (arrayNums[0] == 5) {
            aloneFives[0] = 0;
            numOfAlone++;
        }
        
        //loop through the array to find any fives that are not behind a four. Start at 1 so that the array never checks -1 and craches. Check pos 0 seperatly for a 5
        for (int i = 1; i < (arrayNums.length); i++) {
            //check if there is a four infront
            if (arrayNums[i] == 5 && (arrayNums[i-1] != 4 || i == 0)) {
                //store the position of the alone number
                aloneFives[numOfAlone] = i;
                numOfAlone++;
            }
        }
        
        return aloneFives;
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
