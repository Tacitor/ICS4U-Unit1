/*
 * Lukas Krampitz
 * Sep 20, 2020
 * 
 */
package reviewproblem1_6;

import java.text.DecimalFormat;

/**
 *
 * @author Lukas
 */
public class ReviewProblem1_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //formats
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("#,##0.0%");
        
        //vars
        double baseCost = 62.99;
        double taxRate;
        double amtTaxed;
        double finalCost = 71.81;
        
        //logic
        //find the amt taxed
        amtTaxed = finalCost - baseCost;
        //find the rate of tax
        taxRate = findPercent(amtTaxed, baseCost);
        
        //Output
        System.out.println("Original Cost\t\t" + money.format(baseCost) + 
                "\nFinal cost\t\t" + money.format(finalCost) +
                "\nAmount of Tax\t\t" + money.format(amtTaxed) +
                "\nRate of Tax\t\t" + percent.format(taxRate)
                );
    }
    
    /**
     * Calculates how much num1 is of num2
     * @param num1 - The percent of the second value (this will be computed)
     * @param num2 - The number who's percentage will be found
     */
    public static double findPercent(double num1, double num2) {
        //find the percentage
        double ans = num1 / (num2 /10000);
        //print it out
        return ans/10000;
    }
    
}
