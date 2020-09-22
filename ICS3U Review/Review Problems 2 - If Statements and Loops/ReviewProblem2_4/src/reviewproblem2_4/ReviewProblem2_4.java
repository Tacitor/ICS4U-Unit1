/*
 * Lukas Krampitz
 * Sep 21, 2020
 * Create a program called the DiceGame to simulate the playing of a simple dice game (played with one die). Roll the die to get a value from 1 to 6 (this will be called your point). Now allow the computer to keep rolling until it can match your point. Keep track of the number of rolls the computer takes to match your point and output this value. The user should have the option to play again.
 */
package reviewproblem2_4;

import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class ReviewProblem2_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vars
        boolean gameActive = true;
        boolean pointMatch;
        String usrInput;
        int usrPoint;
        int randPoint;
        int attemptCount;
        
        //the game
        while (gameActive) {
            //get the imput point
            usrInput = JOptionPane.showInputDialog("Would you like to roll the die? (Yes/No)");
            
            //chek for exit cond
            if (usrInput.equalsIgnoreCase("no") || usrInput.equalsIgnoreCase("n")) {
                gameActive = false;
            } else { //run the game
                //reset the vars
                attemptCount = 0;
                pointMatch = false;
                
                //get the usr's point
                usrPoint = (int)(Math.random() * 6) + 1;
                
                //show the usr their point
                System.out.println("Your point is: " + usrPoint);
                
                //try and guess the point
                while (!pointMatch) {
                    randPoint = (int)(Math.random() * 6) + 1;
                    //count a roll
                    attemptCount++;
                    
                    //check for a match
                    if (randPoint == usrPoint) {
                        pointMatch = true;
                    }
                }
                
                //now that the point was found tell the usr how long it took
                System.out.println("It took me " + attemptCount + " roll(s) to match your point of " + usrPoint);
            }
        }
    }
    
}
