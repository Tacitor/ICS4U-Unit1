/*
 * Lukas Krampiz
 * Sep 23, 2020
 * ICS4U Unit 1 Test Part D
 */
package krampitzunit1test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author lukra1175
 */
public class KrampitzUnit1Test {

    //formats
    static DecimalFormat money = new DecimalFormat("$#,##0.00");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        

        //vars
        double totalGlobalPay; //how much did all of the employees make combined?
        String lowestEarner;
        int numEmployees; //How many employees are there (1st line of file)
        String[][] inputData; //name, hourly rate, hours worked, and bonus % of all employees
        double[][] calcData; //calculated values: reg pay, bunus pay, and total pay per employee

        String tableHeader = "Name\t\tHours\tPay Rate\tRegular Pay\tBonus\t\tTotal Pay";
        String output;

        //load in the data file
        try {
            File file = new File("src\\krampitzunit1test\\accounts.txt");
            Scanner scanner = new Scanner(file);

            //get the number of records
            numEmployees = Integer.parseInt(scanner.nextLine());

            //initialize the arrays
            inputData = new String[numEmployees][4]; //create as many arrays are there are employees each with the three data fields

            //populate the array with the data
            inputData = populateArray(inputData, scanner);

            //initialize the array to hold the calculated values
            calcData = new double[numEmployees][3];

            //calculate the pay 
            calcData = getPay(calcData, inputData);

            /* Debug loop
            for (int i = 0; i < calcData.length; i++) {
                System.out.println(money.format(calcData[i][2]));
            }
             */
            //create output table
            output = getTable(inputData, calcData, tableHeader);

            //display the table
            System.out.println(output);

            //add the line for total global pay
            totalGlobalPay = getGlobalTotal(calcData);
            System.out.println("In total " + money.format(totalGlobalPay) + " was paid to our employees");

            //add the line for the lowest earner
            lowestEarner = getLowestEarner(calcData, inputData);
            System.out.println(lowestEarner + " was the lowest earner this year");

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * Find the employee that made the least money so that they can be singled
     * out on the last line of the report :)
     *
     * @param payData
     * @return
     */
    public static String getLowestEarner(double[][] payData, String[][] rawData) {
        double lowestEarner = Double.MAX_VALUE;
        String lowestName = "";

        //go though the data and find the poorest employee
        for (int i = 0; i < payData.length; i++) {
            if (payData[i][2] < lowestEarner) {
                lowestEarner = payData[i][2];
                lowestName = rawData[i][0];
            }
        }

        return lowestName;
    }

    /**
     * Sum up the total pays into a global total pay
     *
     * @param payData
     * @return
     */
    public static double getGlobalTotal(double[][] payData) {
        double totalGlobalPay = 0;

        //go though the data and add all total pay up
        for (int i = 0; i < payData.length; i++) {
            totalGlobalPay += payData[i][2];
        }

        return totalGlobalPay;
    }

    /**
     * Compile data into a table
     *
     * @param rawData
     * @param payData
     * @param header
     * @return
     */
    public static String getTable(String[][] rawData, double[][] payData, String header) {
        String outputString = header;

        //loop though rawData once for each employee and create a row for them
        for (int i = 0; i < rawData.length; i++) {
            //add a new line
            outputString += "\n";

            //add the name
            outputString += rawData[i][0];

            //add the hours
            outputString += "\t" + Double.parseDouble(rawData[i][2]);

            //add pay rate
            outputString += "\t" + money.format(Double.parseDouble(rawData[i][1]));

            //add reg pay
            outputString += "\t\t" + money.format(payData[i][0]);

            //add bonus pay
            outputString += "\t" + money.format(payData[i][1]);

            //add total pay
            outputString += "\t" + money.format(payData[i][2]);
        }

        return outputString;
    }

    /**
     * Preform 3 calculation to find Regular Pay, Bonus Pay, and Total pay and
     * store values in an array
     *
     * @param blankData - values will be stored here
     * @param rawData - data that values are derived from
     * @return blankData now not blank
     */
    public static double[][] getPay(double[][] blankData, String[][] rawData) {
        //loop though and find the pay for each employee
        for (int i = 0; i < blankData.length; i++) {
            //find the regular pay and put it in the first position
            blankData[i][0] = (Double.parseDouble(rawData[i][1])) * (Double.parseDouble(rawData[i][2]));

            //find the bonus pay and put it in the second position
            //check if the get bonus
            if (Double.parseDouble(rawData[i][2]) > 2000) {
                blankData[i][1] = (blankData[i][0] / 100) * (Double.parseDouble(rawData[i][3]));
            }

            //find the total pay and put it in the thrid position
            blankData[i][2] = (blankData[i][0]) + (blankData[i][1]);
        }

        return blankData;
    }

    /**
     * Populate a 2D array with data from a file
     *
     * @param blankArray - The array to populate
     * @param scanner - a scanner at the position with the data to load
     * @return blankArray now no longer blank
     */
    public static String[][] populateArray(String[][] blankArray, Scanner scanner) {
        //loop though the top arrays once for each employee
        for (int i = 0; i < blankArray.length; i++) {
            //now go through the just selected array and populate it's three fields of data
            for (int j = 0; j < blankArray[i].length; j++) {
                blankArray[i][j] = scanner.nextLine();
            }
        }

        return blankArray; //return the now populated array
    }

}
