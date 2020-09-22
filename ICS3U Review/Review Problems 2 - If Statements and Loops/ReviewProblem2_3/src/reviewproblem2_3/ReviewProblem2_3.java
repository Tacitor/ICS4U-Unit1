/*
 * Lukas Krampitz
 * Sep 21, 2020
 * Create a program called ManyTickets. Your program should allow users to input their age. The computer should respond with the appropriate price for a ticket.
 */
package reviewproblem2_3;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class ReviewProblem2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Formats
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        //vars
        boolean inputActive = true;
        boolean validInput;
        int[] tickets = new int[3];
        String[] ticketTypes = {"Child","Adult","Senior"};
        double[] ticketPrices = {6,7.5,6.5};
        int inputAge = 0;
        
        double finalCost = 0;
        String output = "==========Ticket Sales==========";

        //input
        while (inputActive) {
            validInput = false;
            //error trap for invalid entries
            while (validInput == false) {                
                try {
                    inputAge = Integer.parseInt(JOptionPane.showInputDialog("Please enter the patron's age (999 to finish): "));
                    validInput = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "That is not a number please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            //determin the trype of ticket
            if (inputAge == 999) {
                //if the sentinel is found exit the loop
                inputActive = false;
            } else if (inputAge >= 0 && inputAge <= 12) {
                tickets[0]++; //the $6 ticket
            } else if (inputAge > 12 && inputAge <= 64) {
                tickets[1]++; //the $7.50 ticket
            } else if (inputAge > 65) {
                tickets[2]++; //the $6.50 ticket
            } else {
                JOptionPane.showMessageDialog(null, "Sorry that does not seem to be a valid age", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //logic
        for (int i = 0; i < 3; i++) {
            //add to the bill
            output += "\n" + tickets[i] + "x " + ticketTypes[i] + " tickets at " + money.format(tickets[i] * ticketPrices[i]);
            //add to the total
            finalCost += tickets[i] * ticketPrices[i];
        }
        
        //output
        //append the final line
        output += "\nFinal overal cost of: " + money.format(finalCost);
        
        System.out.println(output);
    }

}
