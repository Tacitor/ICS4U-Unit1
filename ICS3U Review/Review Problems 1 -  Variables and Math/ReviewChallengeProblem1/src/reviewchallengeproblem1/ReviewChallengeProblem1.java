/*
 * Lukas Krampiz
 * Sep 21, 2020
 * Considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
package reviewchallengeproblem1;

import java.text.DecimalFormat;

/**
 *
 * @author lukra1175
 */
public class ReviewChallengeProblem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //formats
        DecimalFormat num = new DecimalFormat("#,##0");
        
        //vars
        int fibNum = 1; //the current number in the seqence
        int prevFibNum = 0; //the previous number used to add to the current one
        int fibNumStoreage; //a var to hold a number while working with the other 2 vars
        int evenSum = 0; //an acumulator to sum all the even fib numbers
        int maxFibNum = 15000000; //what is the largest the number can be, easy to change it here for the whole program
        
        //logic
        //loop through all fib numbers less than 4 mill, and check if it is even, then add it to an acumulator
        while (fibNum < maxFibNum) {
            //find the next fibonacci number
            fibNumStoreage = fibNum; //store the current one while computing the next one
            fibNum = fibNum + prevFibNum; //compute the next one
            prevFibNum = fibNumStoreage; //the currnt one now becomes the previous one
            //System.out.println(fibNum); //debug the seqence genorator
            
            //check if it's even
            if (fibNum % 2 == 0) {
                //add it
                evenSum += fibNum;
            }
        }
        
        //print out the sum
        System.out.println("The sum of the even-valued terms of the Fibonacci sequence less than " + num.format(maxFibNum) + " is: " + num.format(evenSum));
    }
    
}
