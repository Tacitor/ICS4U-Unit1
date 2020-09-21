/*
 * Lukas Krampitz
 * Sep 20, 2020
 * The regular price of a pair of jeans is $24.99.  If the jeans are discounted 30%, what is the dollar amount of discount and how much will the jeans cost? 
 */
package reviewproblem1_5;

import java.text.DecimalFormat;

/**
 *
 * @author Lukas
 */
public class ReviewProblem1_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //formats
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("#,##0.00%");
        
        //vars
        double baseCost = 24.99;
        double discRate = 0.3;
        double amtDiscounted;
        double finalCost;
        
        //logic
        //find the amt discounted
        amtDiscounted = findPercent(discRate, baseCost);
        //add amtDiscounted to the base to find the final cost
        finalCost = baseCost - amtDiscounted;
        
        //Output
        System.out.println("Cost of jeans\t\t" + money.format(baseCost) + 
                "\nRate of discount\t" + percent.format(discRate) + 
                "\nAmount of discount\t" + money.format(amtDiscounted) + 
                "\nTotal cost of jeans\t" + money.format(finalCost));
        
    }
    
    /**
     * Calculates the percent num1 is of num2
     * @param num1 - The percent of the second value (this will be computed)
     * @param num2 - The number who's percentage will be found
     */
    public static double findPercent(double num1, double num2) {
        //find the percentage
        double ans = num2 * num1;
        //print it out
        return ans;
    }
    
}
