/*
 * Lukas Krampitz
 * Sep 20, 2020
 * Calculate %s
 */
package reviewproblem1_4;

/**
 *
 * @author Lukas
 */
public class ReviewProblem1_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //call the method to calculate the percent and print it
        findPercent(10, 70);
        //call the method to calculate the percent and print it
        findPercent(20, 25);
        //call the method to calculate the percent and print it
        findPercent(5, 60);
    }
    
    /**
     * Calculates the percent num1 is of num2
     * @param num1 - The percent of the second value (this will be computed)
     * @param num2 - The number who's percentage will be found
     */
    public static void findPercent(double num1, double num2) {
        //find the percentage
        double ans = (num2 / 100) * num1;
        //print it out
        System.out.println(num1 + " percent of " + num2 + " is " + ans);
    }
    
}
