
package by.bsu.ibmt.grouppv115po.gabrusev;

/**
 * Description: The program calculates quadric equation
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 08.03.2016
 */

public class StartApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int a,b,c;
       if (args.length != 3)
       {
            System.out.println("No arguments a,b,c were found! \n Should be 3 argumnts for a, b and c \n Starting manual input ... \n");
            
            // reading a,b,c
            a = EquationReader.read("Enter value of a");
            b = EquationReader.read("Enter value of b");
            c = EquationReader.read("Enter value of c");
            
       }
       else
       {
           a = Integer.parseInt(args[0]);
           b = Integer.parseInt(args[1]);
           c = Integer.parseInt(args[2]);
       }       
       
       // creation object of class EquationCalculator
       EquationCalculator e_calcuator = new EquationCalculator(a, b, c);
       if (e_calcuator.validate())
       {
           e_calcuator.calculate();
           e_calcuator.print_result();
       }      
       
    }
}
