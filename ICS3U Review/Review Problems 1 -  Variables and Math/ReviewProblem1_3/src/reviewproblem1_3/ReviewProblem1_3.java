/*
 * Lukas Krampitz
 * Sep 20, 2020
 * A factory produces 1,022,957 widgets per day.  They sell them in packages of 12.  How many packages are produced in a day?  Indicate how many full boxes are required and how many widgets would be left in a partially filled box.
 */
package reviewproblem1_3;

import java.text.DecimalFormat;

/**
 *
 * @author Lukas
 */
public class ReviewProblem1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //formats
        DecimalFormat num = new DecimalFormat("#,##0");
        
        //vars
        int totalWidgets = 1022957;
        int packNum = 12;
        int totalBoxes;
        int amtInPartialBox;
        
        //logic
        //find the ramainder of widets
        amtInPartialBox = totalWidgets % packNum;
        //find the total number of boxes with all wigets that go into whole boxes only
        totalBoxes = (totalWidgets - amtInPartialBox) / packNum;
        
        //output
        System.out.println("Totak widgets\t\t" + num.format(totalWidgets) + 
                "\nNumber in Pack\t\t" + num.format(packNum) + 
                "\nTotal Boxes\t\t" + num.format(totalBoxes) + 
                "\nAmount in partial box\t" + num.format(amtInPartialBox));
    }
    
}
