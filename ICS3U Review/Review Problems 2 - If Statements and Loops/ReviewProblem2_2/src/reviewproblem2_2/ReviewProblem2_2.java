/*
 * Lukas Krampitz
 * Sep 21, 2020
 * Design a short program that uses a “for” loop to add the 5 numbers starting from a number that the user enters and displays the result. If the user entered a 5, the program will add 5,6,7,8,9. Also have a “while” loop that adds the 6 numbers starting from the user’s input number and displays the result. 
 */
package reviewproblem2_2;

import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class ReviewProblem2_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        int startNum;
        int sum = 0;
        int countingVar = 0;
        
        //input
        startNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a starting number (for loop):"));
        
        //logic
        for (int i = 0; i < 5; i++) {
            sum += startNum;
            startNum++;
        }
        
        //output the for loop one
        System.out.println("The sum of the 5 numbers is: " + sum);
        
        //go again with a while loop
        sum = 0;
        //input
        startNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a starting number (while loop):"));
        
        //logic
        while (countingVar < 6) {
            sum += startNum;
            startNum++;
            
            countingVar++;
        }
        
        //output the while loop one
        System.out.println("The sum of the 6 numbers is: " + sum);
    }
    
}
