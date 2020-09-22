/*
 * Lukas Krampitz
 * Sep 21, 2020
 * Design a short program that will prompt the user for their name, number of hours worked, and hourly rate, and then display the user’s total wages for the week. The program should calculate overtime if the user works more than 44 hours in the week. Overtime is calculated at 1.5 times the hourly rate on the overtime hours only.
 */
package reviewproblem2_1;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class ReviewProblem2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Formats
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        //Vars
        String name;
        double hourWorked;
        double payRate;
        
        double hourOvertime;
        double hourReg;
        double payOvertime;
        double payReg;
        double payTotal;
        
        int maxRegHours = 44; //when does overtime start
        double ovtimeMultiplier  = 1.5;
        
        //Lnput
        name = JOptionPane.showInputDialog("Please enter your name: ");
        hourWorked = Double.parseDouble(JOptionPane.showInputDialog("Please enter how many hours you worked this week: "));
        payRate = Double.parseDouble(JOptionPane.showInputDialog("Please enter your hourly rate: "));
        
        //Logic
        //Sort overtime hours from reg
        if (hourWorked > 44) {
            hourOvertime = hourWorked - 44;
            hourReg = 44;
        } else {
            hourOvertime = 0;
            hourReg = hourWorked;
        }
        
        //find pay for reg hours
        payReg = hourReg * payRate;
        //find pay for overtime
        payOvertime = hourOvertime * payRate * ovtimeMultiplier;
        
        //get the total
        payTotal = payOvertime + payReg;
        
        //Output
        System.out.println("================Total Weekly Wage for " + name + "================\n"
                        + "Hours worked\t\t\t\t\t" + hourWorked + "h\n"
                        + "Hourly rate\t\t\t\t\t" + money.format(payRate) + "/h\n"
                        + "======================================================\n"
                        + "Regular hours worked\t\t\t\t" + hourReg + "h\n"
                        + "Overtime hours worked\t\t\t\t" + hourOvertime + "h\n"
                        + "Regular pay rate\t\t\t\t" + money.format(payRate) + "/h\n"
                        + "Overtime pay rate\t\t\t\t" + money.format(payRate*ovtimeMultiplier) + "/h\n"
                        + "Regular pay\t\t\t\t\t" + money.format(payReg) + "\n"
                        + "Overtime pay\t\t\t\t\t" + money.format(payOvertime) + "\n"
                        + "======================================================\n"
                        + "Total pay\t\t\t\t\t" + money.format(payTotal) + "\n");
    }
    
}
