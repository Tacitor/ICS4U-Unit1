/*
 * Lukas Krampiz
 * Sep 22, 2020
 * Use JOptionPane to prompt the user for 10 numbers between 50 and 75.  They may enter the same number more than once.  Then write the code necessary to do the following tasks:
 *   - Total the numbers in your array
 *   - Find the average of the numbers in your array
 *   - Determine whether the number 50 was found
 *   - Count the number of times the number 50 appears
 */
package reviewproblem3_3;

import javax.swing.JOptionPane;

/**
 *
 * @author lukra1175
 */
public class ReviewProblem3_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        int numCollectFreq = 10; //how many nums to collect
        int[] nums = new int[numCollectFreq];
        
        //Input
        //get the nums from the user
        for (int i = 0; i < nums.length; i++) {
            try {
                nums[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 50 and 75 (" + (numCollectFreq - i) + " to go):"));
                
                //check to see if the number is even in the valid range
                if (nums[i] < 50 || nums[i] > 75) {
                    //decriment i as there was no valid input and it does not count
                    i--;
                    JOptionPane.showMessageDialog(null, "Sorry that is not with the range", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Sorry that is not an integer", "Error", JOptionPane.ERROR_MESSAGE);
                //decriment i as there was no valid input and it does not count
                i--;
            }
        }
        
        //Output
        //Display the numbers entered
        System.out.println("These are the numbers you entered:\n" + listItems(nums));
        //Display the total
        System.out.println("The total of the numbers you entered is: " + getSum(nums));
        //Display the average
        System.out.println("The average of the numbers you entered is: " + getMean(nums));
        //Display the frequency of 50
        System.out.println("The total number of times you entered 50 is: " + count50(nums));
    }
    
    public static String listItems(int numArray[]) {
        String items = "";
        
        //loop through the tring adding each element
        for (int i = 0; i < numArray.length; i++) {
            items += "|" + numArray[i] + "|";
        }
        
        return items;
    }
    
    /**
     * Count the number of times the number 50 appears
     * @param numArray
     * @return 
     */
    public static int count50(int numArray[]) {
        int sum50 = 0;
        
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == 50) {
                sum50++;
            }
        }
        
        return sum50;
    }
    
    /**
     * Loop through an array of ints and total them together
     * @param numArray
     * @return 
     */
    public static int getSum(int numArray[]) {
        int sum = 0;
        
        for (int i = 0; i < numArray.length; i++) {
            sum += numArray[i];
        }
        
        return sum;
    }
    
    /**
     * Loop through an array of ints and total them together then average them out
     * @param numArray
     * @return 
     */
    public static double getMean(int numArray[]) {
        double mean = 0;
        
        //find the average
        mean = getSum(numArray) / numArray.length;
        
        return mean;
    }
    
}
