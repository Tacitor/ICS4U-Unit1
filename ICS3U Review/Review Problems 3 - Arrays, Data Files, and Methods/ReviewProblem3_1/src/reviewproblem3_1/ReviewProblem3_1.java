
/*
 * Lukas Krampitz
 * Sep 22, 2020
 * The table below gives the distribution of the Canadian population in thousands by age and fan base.  Write a program to produce the table shown below.  For each age group, the column labeled %Leafs gives the percentage of the people in that age group that are Leafs fans, similarly for the column labeled %Habs. 
 */
package reviewproblem3_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class ReviewProblem3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Formats
        DecimalFormat num = new DecimalFormat("#,##0");
        DecimalFormat percent = new DecimalFormat("#,##0.00%");
        
        //vars
        String ageGroup;
        double leafFan;
        double habFan;
        String output = "\t\t\tCanadian Population (in thousands)"
                      + "\nAge Group\t\tLeafs Fans\tHabs Fans\t%Leafs\t\t%Habs";
        
        //read in the data file and create chart
        try {
            //load the data file
            File file = new File("src\\reviewproblem3_1\\fans.txt");
            //create the scanner
            Scanner scanner = new Scanner(file);
            
            //make the chart
            while (scanner.hasNextLine()) {
                //collect the record
                ageGroup = scanner.nextLine();
                leafFan = Integer.parseInt(scanner.nextLine());
                habFan = Integer.parseInt(scanner.nextLine());
                
                //add it to the chart
                output += "\n" + ageGroup + "\t\t" + num.format(leafFan) + "\t\t" + num.format(habFan) + "\t\t" + percent.format(leafFan / (leafFan + habFan)) + "\t\t" + percent.format(habFan / (leafFan + habFan));
            }
            
            System.out.println(output);
        } catch (FileNotFoundException e) {
            //display the error
            System.out.println("Error: " + e);
        }
    }
    
}