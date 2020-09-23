/*
 * Lukas Krampitz
 * Sep 22, 2020
 * Review for the test sandbox
 */
package unit1testreview1;

import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class Unit1TestReview1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //double usrHeight;
        
        //usrHeight = Double.parseDouble(JOptionPane.showInputDialog("What is your height in cm"));
        
        //int ranNum;
        //ranNum = (int)(Math.random() * 3) + 9;
        //System.out.println(ranNum);
        
        //System.out.println(11%6);
        
        //int a = 3;
        //int b = 4;
        //System.out.println(" " + a + b + " ");
        
        int t = 8;
        int x = 99;
        while (t < 99) {
            t+=12;
            x-=t;
            if(t % 2 == 0){
                x+= (t/2);
            }
        }
        System.out.println(t);
        System.out.println(x);
    }
    
}
